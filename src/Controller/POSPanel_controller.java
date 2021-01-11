package Controller;

import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;

import GUI.GUI_Utility.Singleproduct_Panel;
import GUI.MainScreen.POSPanel;
import Model.Bill.BillUnit;
import Model.Other.Membership;
import Model.Product.Product;
import Model.Product.ProductType;
import Model.Product.Warehouse;
import Model.Model;

public class POSPanel_controller implements KeyListener, ActionListener  {
    POSPanel posPanel;

    public POSPanel_controller(POSPanel posPanel) {
        this.posPanel = posPanel;
        this.posPanel.allProduct = Warehouse.getAllProduct();
        this.posPanel.allType = Warehouse.getAllProductType();
        // all product
        this.posPanel.allType.add(0, null);

        // set up product selection panel
        this.displayAllProduct();
        for (ProductType pt :this.posPanel.allType) {
            if(pt == null)
                this.posPanel.typesel_ComboBox.addItem("All");
            else
                this.posPanel.typesel_ComboBox.addItem(pt.getTypeName());
        }
        this.posPanel.typesel_ComboBox.setSelectedIndex(0);

    }

    private Integer checkExisted(Product p) {
        int sr = 0;
        System.out.println(this.posPanel.tableModel.getRowCount());

        while (sr < this.posPanel.tableModel.getRowCount()) {
            if (this.posPanel.billunit_table.getValueAt(sr, 0).toString()
                    .compareTo(p.getProductInfo().getCodeBar()) == 0) {
                return sr;
            }
            sr++;
        }
        return -1;
    }

    private void updatePOS(Product p) {
        Integer sr = this.checkExisted(p);

        Integer preNum = Integer.parseInt((String) this.posPanel.billunit_table.getValueAt(sr, 3));
        // out of stock
        if (p.getProductStockInfo().getNumStock() > preNum) {
            System.out.println(preNum);
            this.posPanel.billunit_table.setValueAt(Integer.toString(preNum + 1), sr, 3);
            this.posPanel.posBill.getAllProductBill().get(sr).increOne();

            this.posPanel.billunit_table.setValueAt(Long.toString((preNum + 1) * p.getProductInfo().getPrice()), sr, 4);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 10){
            this.posPanel.productBoxPanel.removeAll();
            
            String searchString = this.posPanel.search_Field.getText();
            Integer typeIndex = this.posPanel.typesel_ComboBox.getSelectedIndex();
            if (typeIndex == 0)
                this.posPanel.allProduct = Warehouse.getAllProductByName(searchString);
            else
                this.posPanel.allProduct = Warehouse.getProductByNameAndType(searchString, this.posPanel.allType.get(typeIndex).getTypeID());
            
            if (this.posPanel.allProduct != null)
                this.displayAllProduct();
            this.posPanel.productBoxPanel.revalidate();
            this.posPanel.productBoxPanel.repaint();
         }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
    private void displayAllProduct(){
        for (Product p : this.posPanel.allProduct) {
            Singleproduct_Panel spp = new Singleproduct_Panel(p, this);
            this.posPanel.productBoxPanel.add(spp);
            spp.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    if (checkExisted(spp.p) == -1) {
                        posPanel.tableModel.addRow(new String[] { spp.p.getProductInfo().getCodeBar(),
                                spp.p.getProductInfo().getProductName(),
                                Long.toString(spp.p.getProductInfo().getPrice()), "1",
                                Long.toString(spp.p.getProductInfo().getPrice()) });
                        posPanel.posBill.addBillUnit(new BillUnit(spp.p, 1));
                    } else {
                        updatePOS(p);
                    }
                    Long total = posPanel.posBill.getTotalPriceWithDiscount();
                    Long finaltotal = posPanel.posBill.getTotalPriceWithoutDiscount();
                    posPanel.total_Field.setText(total.toString());
                    posPanel.finaltotal_Field.setText(finaltotal.toString());
                    posPanel.coupon_Field.setText(Long.toString(posPanel.posBill.getDiscount()));
                }
            });
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().compareTo("Delete") == 0){
            int index = this.posPanel.billunit_table.getSelectedRow();
            this.posPanel.tableModel.removeRow(index);
            this.posPanel.posBill.getAllProductBill().remove(index);
        }
        if(e.getActionCommand().compareTo("Paid") == 0){

            try{
                //Set id
                this.posPanel.posBill.setBillID(Integer.toString(controller.getnumBill(Model.conn) + 1));
                //set Date
                Date date = new Date();
                this.posPanel.posBill.setBuyDate(new java.sql.Date(date.getTime()));
                //Set membership
                try{
                    String membershipID = (this.posPanel.membership_Field.getText());
                    Integer.parseInt(membershipID);
                    if (membershipID.length() == 0 || controller.getMemberShip(Model.conn, this.posPanel.membership_Field.getText()) == null){
                        throw new Exception();
                    }
                    this.posPanel.posBill.setMembershipID(membershipID);
                }catch(Exception err){
                    JOptionPane.showMessageDialog(this.posPanel, "Mã thành viên không hợp lệ");
                }

                //seller nữa
                this.posPanel.posBill.exportBill();
                JOptionPane.showMessageDialog(this.posPanel, "Đã thanh toán");
            }catch(Exception err){
                err.printStackTrace();
                JOptionPane.showMessageDialog(this.posPanel, "Thanh toán thất bại");
            }finally{
                this.posPanel.mainScreen.setup_POSPanel();
            }
        }
		
	}
}
