package GUI.MainScreen;

import GUI.GUI_Utility.*;
import Model.Model;
import Model.Product.Product;
import Model.Product.Warehouse;
import Model.User.Staff;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.*;
import javax.swing.*;

public class MainScreen {
    Dimension screenSize;
    JFrame mainFrame = new JFrame();
    JPanel naviPanel = new JPanel();
    JLabel menuBtn = new JLabel("CSM");
    JLabel shopname =  new JLabel("Shop name");
    JLabel username = new JLabel("User name");
    JPanel menuPanel = new JPanel();
    Staff staff;
    
    JPanel centerPanel =  null;
 
    private void setup_naviPanel() {
        naviPanel.setPreferredSize(new Dimension(screenSize.width,screenSize.height/20));
        naviPanel.setBackground(Color.GRAY);
        naviPanel.setLayout(new GridBagLayout());
    
        GridBagConstraints consLayout = new GridBagConstraints();
        Utility.addComponent(naviPanel, menuBtn, consLayout, 0, 0, 1, 1,GridBagConstraints.CENTER,0,0,1,1,GridBagConstraints.HORIZONTAL);
        Utility.addComponent(naviPanel, shopname, consLayout, 4, 0, 1, 1,GridBagConstraints.CENTER,0,0,1,1,GridBagConstraints.HORIZONTAL);
        Utility.addComponent(naviPanel, username, consLayout, 5, 0, 1, 1,GridBagConstraints.CENTER,0,0,1,1,GridBagConstraints.HORIZONTAL);
    }
    
    public void setup_menuPanel(){
        menuPanel =  new MenuBar(new Dimension(screenSize.width*2/10,screenSize.height - naviPanel.getHeight()),this);
    }
    
    public void setup_homePanel(){
        if(centerPanel == null){
            centerPanel = HomePanel.createMenuBar(new Dimension(screenSize.width*8/10,screenSize.height - naviPanel.getHeight()));
        }
        else{
            mainFrame.remove(this.centerPanel);
            centerPanel = HomePanel.createMenuBar(new Dimension(screenSize.width*8/10,screenSize.height - naviPanel.getHeight()));
            Utility.addComponent(mainFrame, centerPanel, new GridBagConstraints(), 2, 1, 8, 19,GridBagConstraints.PAGE_START,0,0,8,19,GridBagConstraints.BOTH);
            mainFrame.revalidate();
            mainFrame.repaint();
        }

    }
    
    public void setup_productPanel(){

        mainFrame.remove(this.centerPanel);
        centerPanel = new ProductPanel(new Dimension(screenSize.width*8/10,screenSize.height - naviPanel.getHeight()),this);
        Utility.addComponent(mainFrame, centerPanel, new GridBagConstraints(), 2, 1, 8, 19,GridBagConstraints.PAGE_START,0,0,8,19,GridBagConstraints.BOTH);
        mainFrame.revalidate();
        mainFrame.repaint();
    }   
    public void setup_membershipPanel(){
        mainFrame.remove(this.centerPanel);
        centerPanel = new MembershipPanel(new Dimension(screenSize.width*8/10,screenSize.height - naviPanel.getHeight()),this);
        Utility.addComponent(mainFrame, centerPanel, new GridBagConstraints(), 2, 1, 8, 19,GridBagConstraints.PAGE_START,0,0,8,19,GridBagConstraints.BOTH);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void setup_promotionPanel(){
        mainFrame.remove(this.centerPanel);
        centerPanel = new PromotionPanel(new Dimension(screenSize.width*8/10,screenSize.height - naviPanel.getHeight()),this);
        Utility.addComponent(mainFrame, centerPanel, new GridBagConstraints(), 2, 1, 8, 19,GridBagConstraints.PAGE_START,0,0,8,19,GridBagConstraints.BOTH);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    public void setup_POSPanel(){
        mainFrame.remove(this.centerPanel);
        centerPanel = new POSPanel(new Dimension(screenSize.width*8/10,screenSize.height - naviPanel.getHeight()));
        Utility.addComponent(mainFrame, centerPanel, new GridBagConstraints(), 2, 1, 8, 19,GridBagConstraints.PAGE_START,0,0,8,19,GridBagConstraints.BOTH);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    public void setup_productDetailPanel(Product p){
        mainFrame.remove(this.centerPanel);
        centerPanel = new ProductDetailPanel(new Dimension(screenSize.width*8/10,screenSize.height - naviPanel.getHeight()),this,p);
        Utility.addComponent(mainFrame, centerPanel, new GridBagConstraints(), 2, 1, 8, 19,GridBagConstraints.PAGE_START,0,0,8,19,GridBagConstraints.BOTH);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void setup_billPanel(){
        mainFrame.remove(this.centerPanel);
        centerPanel = new BillPanel(new Dimension(screenSize.width*8/10,screenSize.height - naviPanel.getHeight()),this);
        Utility.addComponent(mainFrame, centerPanel, new GridBagConstraints(), 2, 1, 8, 19,GridBagConstraints.PAGE_START,0,0,8,19,GridBagConstraints.BOTH);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    public MainScreen(Staff staff) {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.setSize(screenSize.getWidth()/1.2, screenSize.getHeight()/1.2);
        
        setup_naviPanel();
        setup_menuPanel();
        setup_homePanel();

        mainFrame.setLayout(new GridBagLayout());
        GridBagConstraints consLayout = new GridBagConstraints();
        Utility.addComponent(mainFrame, naviPanel, consLayout, 0, 0, 10, 1,GridBagConstraints.CENTER,0,0,10,1,GridBagConstraints.BOTH);
        Utility.addComponent(mainFrame, menuPanel, consLayout, 0, 1, 2, 19,GridBagConstraints.PAGE_START,0,0,2,19,GridBagConstraints.HORIZONTAL);
        Utility.addComponent(mainFrame, centerPanel, consLayout, 2, 1, 8, 19,GridBagConstraints.PAGE_START,0,0,8,19,GridBagConstraints.BOTH);
        mainFrame.pack();
        mainFrame.setVisible(true);

        this.staff = staff;

    }

    public static void main(String[] args) {
        Model.setupModel();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainScreen(null);
            }
        });
    }
}