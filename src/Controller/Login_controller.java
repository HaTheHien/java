package Controller;

import java.awt.event.*;
import javax.swing.*;
import GUI.Login.*;
import GUI.MainScreen.MainScreen;
import Model.*;
import Model.User.*;



public class Login_controller implements ActionListener {
    Login_screen loginScreen;
    Login_model loginModel ;
    public Login_controller(Login_screen loginScreen,  Login_model loginModel){
        this.loginScreen = loginScreen;
        this.loginModel = loginModel;
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        if  (e.getActionCommand() == "Login"){
            String username = loginScreen.username_Field.getText();
            String password = new String(loginScreen.password_Field.getPassword());
            Staff s = loginModel.getStaff(username, password);
            if(s == null){
                System.out.println("Login fail");
            }
            else{
                this.loginScreen.mainFrame.setVisible(false);  
                this.loginScreen.mainFrame.dispose(); 
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        new MainScreen(s);
                    }
                });
            }
        }
    }
    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Login_screen(null);
                }
            });
    }

}
