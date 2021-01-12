package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import GUI.MainScreen.MembershipPanel;
import Model.Model;
import Model.Other.Membership;

public class MembershipPanel_controller implements ListSelectionListener, ActionListener {
    MembershipPanel mPanel;

    public MembershipPanel_controller(MembershipPanel mPanel) {
        this.mPanel = mPanel;
        ArrayList<Membership> list = controller.getAllMemberShip(Model.conn);
        for (int i = 0; i < list.size(); i++)
            this.mPanel.tableModel
                    .addRow(new String[] { list.get(i).getIdMem(), list.get(i).getName(), list.get(i).getPhoneNum() });
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int rowSelected = this.mPanel.membershipTable.getSelectedRow();
        String id = this.mPanel.membershipTable.getValueAt(rowSelected, 0).toString();
        Membership m = controller.getMemberShip(Model.conn, id);
        this.mPanel.mainScreen.setup_MemberDetailPanel(m);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().compareTo("Add") == 0){
            Membership m = new Membership();
            m.setPhoneNum(this.mPanel.memSDT_Field.getText());
            m.setIdMem(this.mPanel.memname_Field.getText());
            m.setAddress("");
            controller.createMemberShip(Model.conn, m.getName(), m.getAddress(), m.getPhoneNum());
            mPanel.mainScreen.setup_membershipPanel();
        }
    }
}
