package Controller;

import java.sql.Date;
import java.awt.event.*;
import GUI.MainScreen.BillPanel;
import Model.Model;
import Model.Bill.Bill;

public class BIllPanel_controller implements ActionListener {
    BillPanel billPanel;

    public BIllPanel_controller(BillPanel billPanel) {
        this.billPanel = billPanel;
        this.billPanel.startDate.getText();
        this.billPanel.listBill = controller.filterBillByDate(Model.conn, Date.valueOf("1970-1-1"),Date.valueOf("2021-2-1"));
        for (Bill b : this.billPanel.listBill) {
            this.billPanel.tableModel.addRow(new String[]{b.getBillID(),b.getBuyDate().toString(),b.getSellerID(),b.getMembershipID()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().compareTo("Search") == 0){
                this.billPanel.listBill = controller.filterBillByDate(Model.conn, Date.valueOf(this.billPanel.startDate.getText()),Date.valueOf(this.billPanel.endDate.getText()));
            if (this.billPanel.listBill != null){
                this.billPanel.tableModel.setRowCount(0);
                for (Bill b : this.billPanel.listBill) {
                    this.billPanel.tableModel.addRow(new String[]{b.getBillID(),b.getBuyDate().toString(),b.getSellerID(),b.getMembershipID()});
                }
            }
        }

    }
}
