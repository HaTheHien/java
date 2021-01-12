package Controller;

import GUI.MainScreen.BillPanel;
import GUI.MainScreen.BilldetailPanel;
import Model.Bill.BillUnit;

public class BillDetail_controller {
    BilldetailPanel billdetailPanel;

    public BillDetail_controller(BilldetailPanel billdetailPanel) {

        this.billdetailPanel = billdetailPanel;
        for (BillUnit bu : this.billdetailPanel.b.getAllProductBill()) {
            this.billdetailPanel.tablemodel.addRow(new String[] { bu.getProduct().getProductInfo().getProductName(),
                    Long.toString(bu.getProduct().getProductInfo().getPrice()), bu.getAmount().toString() });
        }
    }
}
