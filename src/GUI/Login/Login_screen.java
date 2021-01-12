package GUI.Login;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import Controller.*;
import Model.Login_model;
public class Login_screen{

    Connection conn = null;
    int size_x = 750;
    int size_y = 600;
    public JFrame mainFrame = new JFrame();
    JPanel mainPanel = new JPanel();

    JPanel loginImg_Panel = new JPanel();
    JPanel loginInput_Panel = new JPanel();

    public JTextField username_Field = new JTextField();
    public JPasswordField password_Field = new JPasswordField();

    JButton login_button = new JButton("Login");

    private void setup_mainPanel() {

        // set up img panel
        setup_loginImg_Panel();

        // set up input panel
        setup_loginInput_Panel();

        // layout for panel
        GroupLayout layout = new GroupLayout(mainPanel);

        // //auto gaps
        // layout.setAutoCreateGaps(true);
        // layout.setAutoCreateContainerGaps(true);

        // add component
        layout.setHorizontalGroup(layout.createSequentialGroup().addGap(0)
                .addComponent(loginImg_Panel, GroupLayout.PREFERRED_SIZE, size_x / 2, GroupLayout.PREFERRED_SIZE)
                .addGap(0)
                .addComponent(loginInput_Panel, GroupLayout.PREFERRED_SIZE, size_x / 2, GroupLayout.PREFERRED_SIZE)
                .addGap(0));

        layout.setVerticalGroup(layout.createSequentialGroup().addGap(0)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(loginImg_Panel, GroupLayout.PREFERRED_SIZE, size_y, GroupLayout.PREFERRED_SIZE)
                        .addComponent(loginInput_Panel, GroupLayout.PREFERRED_SIZE, size_y, GroupLayout.PREFERRED_SIZE))
                .addGap(0));
        mainPanel.setLayout(layout);
    }

    private void setup_loginInput_Panel() {
        loginInput_Panel.setBackground(Color.white);

        // set up welcome text
        JLabel signIn_JLabel = new JLabel("Welcome back");
        signIn_JLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 32));
        signIn_JLabel.setHorizontalAlignment(SwingConstants.CENTER);
        signIn_JLabel.setForeground(new Color(49, 50, 111));

        // set up USERNAME label
        JLabel username_JLabel = new JLabel("USERNAME");
        username_JLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        username_JLabel.setHorizontalAlignment(SwingConstants.LEFT);
        username_JLabel.setForeground(Color.gray);

        // set up PASSWORD label
        JLabel password_JLabel = new JLabel("PASSWORD");
        password_JLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        password_JLabel.setHorizontalAlignment(SwingConstants.LEFT);
        password_JLabel.setForeground(Color.gray);

        username_Field.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

        // set up layout
        GroupLayout layout = new GroupLayout(loginInput_Panel);

        layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(layout
                .createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(signIn_JLabel, GroupLayout.PREFERRED_SIZE, size_x / 2, GroupLayout.PREFERRED_SIZE)
                .addComponent(username_JLabel, GroupLayout.PREFERRED_SIZE, size_x / 3, GroupLayout.PREFERRED_SIZE)
                .addComponent(username_Field, GroupLayout.PREFERRED_SIZE, size_x / 3, GroupLayout.PREFERRED_SIZE)
                .addComponent(password_JLabel, GroupLayout.PREFERRED_SIZE, size_x / 3, GroupLayout.PREFERRED_SIZE)
                .addComponent(password_Field, GroupLayout.PREFERRED_SIZE, size_x / 3, GroupLayout.PREFERRED_SIZE)
                .addComponent(login_button, GroupLayout.PREFERRED_SIZE, size_x / 3, GroupLayout.PREFERRED_SIZE)));

        layout.setVerticalGroup(layout.createSequentialGroup().addGap(100).addComponent(signIn_JLabel).addGap(100)
                .addComponent(username_JLabel)
                .addComponent(username_Field, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(password_JLabel)
                .addComponent(password_Field, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(30)
                .addComponent(login_button, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE));

        login_button.setBackground(new Color(255, 155, 147));
        login_button.addActionListener(new Login_controller(this,new Login_model()));
        loginInput_Panel.setLayout(layout);

    }

    private void setup_loginImg_Panel() {
        // loginImg_Panel.setBackground(Color.white);

        GroupLayout layout = new GroupLayout(loginImg_Panel);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        ImageIcon imageIcon = new ImageIcon("GUI/Login/Untitled-5.png");

        JLabel imageJLabel = new JLabel();
        imageJLabel.setSize(new Dimension(loginImg_Panel.getSize()));

        // imageJLabel.setPreferredSize(new Dimension(size_x / 2,size_y));

        imageJLabel.setIcon(imageIcon);

        layout.setHorizontalGroup(layout.createSequentialGroup().addGap(0, 0, 0).addComponent(imageJLabel));

        layout.setVerticalGroup(layout.createSequentialGroup().addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(imageJLabel)));

        loginImg_Panel.setLayout(layout);

    }

    public Login_screen(Connection conn) {

        this.conn = conn;
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setPreferredSize(new Dimension(size_x, size_y));
        mainFrame.setResizable(true);

        mainPanel.setPreferredSize(new Dimension(size_x, size_y));

        setup_mainPanel();

        mainFrame.add(mainPanel);

        // disable decorated(title bar)
        mainFrame.setUndecorated(true);

        mainFrame.pack();

        // set window in center of screen
        mainFrame.setLocationRelativeTo(null);
        // mainFrame.setResizable(false);

        mainFrame.setVisible(true);
        //event_handling();
    }

    // void event_handling() {
    //     login_button.addMouseListener(new MouseAdapter() {
    //         public void mouseClicked(MouseEvent e) {
    //             // TODO: add action here
    //             username_Field.setText("nothing here");
    //         }
    //     });
    // }


    public static void main(String[] args) {
        new Login_screen(null);
    }
}

// layout.setHorizontalGroup(
// layout.createSequentialGroup()
// .addComponent(c1)
// .addComponent(c2)
// .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
// .addComponent(c3)
// .addComponent(c4))
// );
// layout.setVerticalGroup(
// layout.createSequentialGroup()
// .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
// .addComponent(c1)
// .addComponent(c2)
// .addComponent(c3))
// .addComponent(c4)
// );