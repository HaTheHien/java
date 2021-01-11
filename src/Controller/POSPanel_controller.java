package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import GUI.GUI_Utility.Singleproduct_Panel;
import GUI.MainScreen.POSPanel;
import Model.Bill.BillUnit;
import Model.Product.Product;
import Model.Product.Warehouse;

public class POSPanel_controller {
    POSPanel posPanel;

    public POSPanel_controller(POSPanel posPanel) {
        this.posPanel = posPanel;
        this.posPanel.allProduct = Warehouse.getAllProduct();
        for (Product p : this.posPanel.allProduct) {
            Singleproduct_Panel spp = new Singleproduct_Panel(p, this);
            this.posPanel.productBoxPanel.add(spp);
            spp.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    if (checkExisted(spp.p) == -1) {
                        posPanel.tableModel.addRow(new String[] { spp.p.getProductInfo().getCodeBar(),
                                spp.p.getProductInfo().getProductName(),
                                Long.toString(spp.p.getProductInfo().getPrice()), "1",
                                Long.toString(spp.p.getProductInfo().getPrice())});
                        posPanel.posBill.addBillUnit(new BillUnit(spp.p.getProductInfo().getCodeBar(), 1));
                    } else {
                        updatePOS(p);
                    }
                }
            });
        }
    }

    private Integer checkExisted(Product p) {
        int sr = 0;
        System.out.println(this.posPanel.tableModel.getRowCount());

        while (sr < this.posPanel.tableModel.getRowCount()) {
            System.out.println(this.posPanel.billunit_table.getValueAt(sr, 0).toString());
            System.out.println(p.getProductInfo().getCodeBar());
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
        System.out.println(preNum);
        this.posPanel.billunit_table.setValueAt(
                Integer.toString(preNum + 1), sr,3);
        this.posPanel.billunit_table.setValueAt(
                Long.toString((preNum+1) *p.getProductInfo().getPrice()), sr,4);
    }
}
