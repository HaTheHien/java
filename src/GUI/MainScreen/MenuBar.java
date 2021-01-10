package GUI.MainScreen;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import GUI.GUI_Utility.*;

public class MenuBar extends JPanel {
    MainScreen mainScreen;
    JLabel home_label = new JLabel("Trang chủ");
    JLabel pos_label = new JLabel("POS");
    JLabel product_label = new JLabel("Hàng hoá");
    JLabel promotion_label = new JLabel("Khuyến mại");
    JLabel membership_label = new JLabel("Khách hàng");
    JLabel bill_label = new JLabel("Danh sách hoá đơn");

    public MenuBar(Dimension size, MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        setSize(size);
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));
        GridBagConstraints layoutConstraints = new GridBagConstraints();

        home_label.setPreferredSize(new Dimension(size.width, size.height / 10));
        pos_label.setPreferredSize(new Dimension(size.width, size.height / 10));
        product_label.setPreferredSize(new Dimension(size.width, size.height / 10));
        promotion_label.setPreferredSize(new Dimension(size.width, size.height / 10));
        membership_label.setPreferredSize(new Dimension(size.width, size.height / 10));
        bill_label.setPreferredSize(new Dimension(size.width, size.height / 10));

        home_label.setBorder(BorderFactory.createLineBorder(Color.black));
        pos_label.setBorder(BorderFactory.createLineBorder(Color.black));
        product_label.setBorder(BorderFactory.createLineBorder(Color.black));
        promotion_label.setBorder(BorderFactory.createLineBorder(Color.black));
        membership_label.setBorder(BorderFactory.createLineBorder(Color.black));
        bill_label.setBorder(BorderFactory.createLineBorder(Color.black));

        Utility.addComponent(this, home_label, layoutConstraints, 0, 0, 1, 1, GridBagConstraints.CENTER, 0, 5, 1, 1,
                GridBagConstraints.HORIZONTAL);
        Utility.addComponent(this, pos_label, layoutConstraints, 0, 1, 1, 1, GridBagConstraints.CENTER, 0, 5, 1, 1,
                GridBagConstraints.HORIZONTAL);
        Utility.addComponent(this, product_label, layoutConstraints, 0, 2, 1, 1, GridBagConstraints.CENTER, 0, 5, 1, 1,
                GridBagConstraints.HORIZONTAL);
        Utility.addComponent(this, product_label, layoutConstraints, 0, 3, 1, 1, GridBagConstraints.CENTER, 0, 5, 1, 1,
                GridBagConstraints.HORIZONTAL);
        Utility.addComponent(this, promotion_label, layoutConstraints, 0, 4, 1, 1, GridBagConstraints.CENTER, 0, 5, 1,
                1, GridBagConstraints.HORIZONTAL);
        Utility.addComponent(this, membership_label, layoutConstraints, 0, 5, 1, 1, GridBagConstraints.CENTER, 0, 5, 1,
                1, GridBagConstraints.HORIZONTAL);
        Utility.addComponent(this, bill_label, layoutConstraints, 0, 6, 1, 1, GridBagConstraints.CENTER, 0, 5, 1, 1,
                GridBagConstraints.HORIZONTAL);
        this.product_label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                mainScreen.setup_productPanel();
            }
        });
        this.home_label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                mainScreen.setup_homePanel();
            }
        });
        this.promotion_label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                mainScreen.setup_promotionPanel();
            }
        });
        this.membership_label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                mainScreen.setup_membershipPanel();
            }
        });
        this.pos_label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                mainScreen.setup_POSPanel();
            }
        });
    }
}
