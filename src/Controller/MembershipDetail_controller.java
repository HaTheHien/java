package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.MainScreen.MembershipDetail_Panel;

public class MembershipDetail_controller implements ActionListener {
    MembershipDetail_Panel membershipDetail_Panel;

    public MembershipDetail_controller(MembershipDetail_Panel membershipDetail_Panel) {
        this.membershipDetail_Panel = membershipDetail_Panel;
        this.membershipDetail_Panel.idfield.setText(this.membershipDetail_Panel.m.getIdMem());
        this.membershipDetail_Panel.namefield.setText(membershipDetail_Panel.m.getName());
        this.membershipDetail_Panel.numField.setText(membershipDetail_Panel.m.getPhoneNum());
        this.membershipDetail_Panel.addressField.setText(this.membershipDetail_Panel.m.getAddress());
        this.membershipDetail_Panel.poiintField.setText(this.membershipDetail_Panel.m.getPoint().toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().compareTo("update") == 0){
            String oldID  = this.membershipDetail_Panel.m.getIdMem();
            this.membershipDetail_Panel.m.setName(this.membershipDetail_Panel.namefield.getText());
            this.membershipDetail_Panel.m.setPhoneNum(this.membershipDetail_Panel.numField .getText());
            this.membershipDetail_Panel.m.setPoint(Integer.parseInt(this.membershipDetail_Panel.poiintField.getText()));
            this.membershipDetail_Panel.m.setAddress(this.membershipDetail_Panel.addressField.getText());
            this.membershipDetail_Panel.m.setIdMem(this.membershipDetail_Panel.idfield.getText());
            try{
                this.membershipDetail_Panel.m.updateMembership(oldID);
                JOptionPane.showMessageDialog(this.membershipDetail_Panel, "Cập nhật thành công");
            }catch(Exception err){
                err.printStackTrace();
                JOptionPane.showMessageDialog(this.membershipDetail_Panel, "Cập nhật thất bại");
            }
        }

    }
}