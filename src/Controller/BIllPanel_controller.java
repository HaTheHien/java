package Controller;

import java.sql.Date;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.*;
import GUI.MainScreen.BillPanel;
import Model.Model;
import Model.Bill.Bill;
import Model.Product.Warehouse;

public class BillPanel_controller implements ActionListener, ListSelectionListener {
    BillPanel billPanel;

    public BillPanel_controller(BillPanel billPanel) {
        this.billPanel = billPanel;
        this.billPanel.startDate.getText();
        this.billPanel.listBill = controller.getAllBill(Model.conn);
        for (Bill b : this.billPanel.listBill) {
            this.billPanel.tableModel.addRow(
                    new String[] { b.getBillID(), b.getBuyDate().toString(), b.getSellerID(), b.getMembershipID() });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().compareTo("Search") == 0) {
            this.billPanel.listBill = controller.filterBillByDate(Model.conn,
                    Date.valueOf(this.billPanel.startDate.getText()), Date.valueOf(this.billPanel.endDate.getText()));
            if (this.billPanel.listBill != null) {
                this.billPanel.tableModel.setRowCount(0);
                for (Bill b : this.billPanel.listBill) {
                    this.billPanel.tableModel.addRow(new String[] { b.getBillID(), b.getBuyDate().toString(),
                            b.getSellerID(), b.getMembershipID() });
                }
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int rowSelected = this.billPanel.billTable.getSelectedRow();
        String id = this.billPanel.billTable.getValueAt(rowSelected, 0).toString();
        Bill b;
        try{
            b = controller.getAllBill(Model.conn).get(rowSelected);
        }catch(IndexOutOfBoundsException err){
            err.printStackTrace();
            return;
        }
        this.billPanel.mainScreen.setup_billdetailPanel(b);
    }
}
    