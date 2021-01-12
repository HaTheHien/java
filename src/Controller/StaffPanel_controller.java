package Controller;

import GUI.MainScreen.StaffPanel;
import Model.User.Staff;
import Model.Model;

public class StaffPanel_controller {
    StaffPanel staffPanel;

    public StaffPanel_controller(StaffPanel staffPanel) {
        this.staffPanel = staffPanel;
        for (Staff b : controller.getAllAccount(Model.conn)) {
            this.staffPanel.tableModel.addRow(
                    new String[] { b.getId(),b.getFullname(),b.getPermission()});
        }
    }
}
