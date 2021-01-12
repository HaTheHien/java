package Controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import GUI.MainScreen.StaffPanel;
import Model.User.Staff;
import Model.Model;

public class StaffPanel_controller implements ListSelectionListener {
    StaffPanel staffPanel;

    public StaffPanel_controller(StaffPanel staffPanel) {
        this.staffPanel = staffPanel;
        for (Staff b : controller.getAllAccount(Model.conn)) {
            this.staffPanel.tableModel.addRow(
                    new String[] { b.getId(),b.getFullname(),b.getType()});
        }
    }
    public void valueChanged(ListSelectionEvent e) {
        int rowSelected = this.staffPanel.staff_table.getSelectedRow();
        String id = this.staffPanel.staff_table.getValueAt(rowSelected, 0).toString();
        Staff s = null;
        try{
           s  = controller.getAccount(Model.conn,id);
        }catch(IndexOutOfBoundsException err){
            err.printStackTrace();
            return;
        }
        if (s!= null){
            this.staffPanel.mainScreen.setup_staffDetailPanel(s);
        }
        else{

        }
}
}
