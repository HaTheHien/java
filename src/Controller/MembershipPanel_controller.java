package Controller;

import java.util.ArrayList;

import GUI.MainScreen.MembershipPanel;
import Model.Model;
import Model.Other.Membership;

public class MembershipPanel_controller {
    public MembershipPanel_controller(MembershipPanel mPanel){
        ArrayList<Membership> list = controller.getAllMemberShip(Model.conn);
        for (int i=0;i<list.size();i++)
            mPanel.tableModel.addRow(new String[] {list.get(i).getIdMem(),list.get(i).getName(),list.get(i).getPhoneNum()});
    }
}
