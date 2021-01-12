package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import GUI.MainScreen.StaffDetailPanel;
import Model.User.Staff;
import Model.Model;

public class StaffPanelDetail_controller implements ActionListener {
    StaffDetailPanel staffDetailPanel;

    public StaffPanelDetail_controller(StaffDetailPanel staffDetailPanel) {
        this.staffDetailPanel = staffDetailPanel;
        Staff s = this.staffDetailPanel.s;
        this.staffDetailPanel.id_field.setText(s.getId());
        this.staffDetailPanel.dob_field.setText(s.getDob().toString());
        this.staffDetailPanel.name_filed.setText(s.getFullname());
        this.staffDetailPanel.pass_filed.setText(s.getPassword());
        this.staffDetailPanel.type_filed.setText(s.getType());
        this.staffDetailPanel.addres_filed.setText(s.getAddress());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().compareTo("Update") == 0) {
            this.staffDetailPanel.s.setId(this.staffDetailPanel.id_field.getText());
            this.staffDetailPanel.s.setFullname(this.staffDetailPanel.name_filed.getText());
            this.staffDetailPanel.s.setDob(Date.valueOf(this.staffDetailPanel.dob_field.getText()));
            this.staffDetailPanel.s.setAddress(this.staffDetailPanel.addres_filed.getText());
            this.staffDetailPanel.s.setPassword(this.staffDetailPanel.pass_filed.getText());
            this.staffDetailPanel.s.setType(this.staffDetailPanel.type_filed.getText());
            Staff s = this.staffDetailPanel.s;
            controller.updateAccount(Model.conn, s.getId(), s.getFullname(), s.getDob().toString(), s.getAddress(),
                    s.getPassword(), s.getType());

        }

    }

}
