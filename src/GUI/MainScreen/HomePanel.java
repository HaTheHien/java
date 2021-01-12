package GUI.MainScreen;

import GUI.GUI_Utility.Utility;
import javax.swing.*;
import javax.swing.text.StyleConstants;

import Controller.HomePanel_controller;

import java.awt.*;

public class HomePanel extends JPanel {
        JTextArea revenue_label = new JTextArea();
        JTextArea billNum_label = new JTextArea();
        JTextArea productNum_label = new JTextArea();

        JPanel activity_panel = new JPanel();
        JPanel stock_panel = new JPanel();
        JPanel product_panel = new JPanel();

        public long revenue = 0;
        public long billNum = 0;
        public long soldProductNum = 0;
        public long stockProductNum = 0;
        public long aboutExpireProductNum = 0;
        public long aboutOutStockProductNum = 0;
        public long outStockProductNum = 0;
        public long productNum = 0;
        public long productTypeNum = 0;

        HomePanel_controller home_controller = new HomePanel_controller(this);

    private HomePanel(Dimension size) {
        setPreferredSize(size);
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        setup(size);
    }

    private void setup_activityPanel() {
        JTextArea activity_info = new JTextArea();
        activity_info.setColumns(15);
        JTextField activity_title = new JTextField("Hoạt động");
        activity_title.setColumns(15);
        String info = "Doanh thu\t\t" + this.revenue + "\nSố hoá đơn bán được\t" + this.billNum
                + "\nSố hàng hoá bán được\t" + this.soldProductNum;
        activity_panel.setBorder(BorderFactory.createLineBorder(Color.black));
        activity_title.setBorder(BorderFactory.createLineBorder(Color.black));
        activity_info.setText(info);
        activity_info.setAlignmentX(StyleConstants.ALIGN_CENTER);
        activity_info.setAlignmentY(StyleConstants.ALIGN_CENTER);

        activity_panel.setLayout(new GridBagLayout());
        Utility.addComponent(activity_panel, activity_title, new GridBagConstraints(), 0, 0, 1, 1,
                GridBagConstraints.PAGE_START, 0, 0, 1, 1, GridBagConstraints.BOTH);
        Utility.addComponent(activity_panel, activity_info, new GridBagConstraints(), 0, 1, 1, 1,
                GridBagConstraints.PAGE_END, 0, 0, 1, 1, GridBagConstraints.BOTH);
    }

    private void setup_stockPanel() {
        JTextArea stock_info = new JTextArea();
        stock_info.setColumns(15);
        JTextField stock_title = new JTextField("Thông tin kho");
        stock_title.setColumns(15);
        String info = "Hàng đang trong kho\t" + this.stockProductNum + "\nSố hàng sắp hết hạng\t"
                + this.aboutExpireProductNum + "\nHết hàng\t\t" + this.outStockProductNum + "\nSắp hết hàng\t\t"
                + this.aboutOutStockProductNum;
        stock_panel.setBorder(BorderFactory.createLineBorder(Color.black));
        stock_title.setBorder(BorderFactory.createLineBorder(Color.black));
        stock_info.setText(info);
        stock_info.setAlignmentX(StyleConstants.ALIGN_CENTER);
        stock_info.setAlignmentY(StyleConstants.ALIGN_CENTER);

        stock_panel.setLayout(new GridBagLayout());
        Utility.addComponent(stock_panel, stock_title, new GridBagConstraints(), 0, 0, 1, 1,
                GridBagConstraints.PAGE_START, 0, 0, 1, 1, GridBagConstraints.BOTH);
        Utility.addComponent(stock_panel, stock_info, new GridBagConstraints(), 0, 1, 1, 1, GridBagConstraints.PAGE_END,
                0, 0, 1, 1, GridBagConstraints.BOTH);
    }

    private void product_panel(){
        JTextArea product_info = new JTextArea();
        product_info.setColumns(15);
        JTextField product_title = new JTextField("Hoạt động");
        product_title.setColumns(15);
        String info = "Hàng đang trong kho\t" + this.stockProductNum + "\nSố hàng sắp hết hạng\t"
                + this.aboutExpireProductNum + "\nHết hàng\t" + this.outStockProductNum + "\nSắp hết hàng"
                + this.aboutOutStockProductNum;
        product_panel.setBorder(BorderFactory.createLineBorder(Color.black));
        product_title.setBorder(BorderFactory.createLineBorder(Color.black));
        product_info.setText(info);
        product_info.setAlignmentX(StyleConstants.ALIGN_CENTER);
        product_info.setAlignmentY(StyleConstants.ALIGN_CENTER);

        product_panel.setLayout(new GridBagLayout());
        Utility.addComponent(product_panel, product_title, new GridBagConstraints(), 0, 0, 1, 1,
                GridBagConstraints.PAGE_START, 0, 0, 1, 1, GridBagConstraints.BOTH);
        Utility.addComponent(product_panel, product_info, new GridBagConstraints(), 0, 1, 1, 1, GridBagConstraints.PAGE_END,
                0, 0, 1, 1, GridBagConstraints.BOTH);

    }

    private void setup_revenue_label() {
        revenue_label.setEditable(false);
        revenue_label.setBorder(BorderFactory.createLineBorder(Color.black));
        revenue_label.setAlignmentX(StyleConstants.ALIGN_CENTER);
        revenue_label.setText("Doanh thu\n" + revenue + "đ");
    }

    private void setup_bill_label() {
        billNum_label.setEditable(false);
        billNum_label.setBorder(BorderFactory.createLineBorder(Color.black));
        billNum_label.setAlignmentX(StyleConstants.ALIGN_CENTER);
        billNum_label.setText("Hoá đơn đã thanh toán\n" + billNum);
    }

    private void setup_productNum_label() {
        productNum_label.setEditable(false);
        productNum_label.setBorder(BorderFactory.createLineBorder(Color.black));
        productNum_label.setAlignmentX(StyleConstants.ALIGN_CENTER);
        productNum_label.setText("Số hàng\n" + productNum);
    }

    private void setup(Dimension size) {
        setup_revenue_label();
        setup_bill_label();
        setup_productNum_label();

        setup_activityPanel();
        setup_stockPanel();
        //product_panel();
        GridBagConstraints lc = new GridBagConstraints();
        Utility.addComponent(this, revenue_label, lc, 0, 0, 5, 2, GridBagConstraints.CENTER, 0, 0, 5, 2,
                GridBagConstraints.NONE);
        Utility.addComponent(this, billNum_label, lc, 6, 0, 5, 2, GridBagConstraints.CENTER, 0, 0, 5, 2,
                GridBagConstraints.NONE);
        Utility.addComponent(this, productNum_label, lc, 12, 0, 5, 2, GridBagConstraints.CENTER, 0, 0, 5, 2,
                GridBagConstraints.NONE);
        Utility.addComponent(this, activity_panel, lc, 0, 2, 5, 2, GridBagConstraints.PAGE_START, 0, 0, 5, 2,
                GridBagConstraints.NONE);
        Utility.addComponent(this, stock_panel, lc, 6, 2, 5, 2, GridBagConstraints.PAGE_START, 0, 0, 5, 2,
                GridBagConstraints.NONE);
        Utility.addComponent(this, product_panel, lc, 12, 2, 5, 2, GridBagConstraints.PAGE_START, 0, 0, 5, 2,
                GridBagConstraints.NONE);
        setSizeAll(size);

    }

    private void setSizeAll(Dimension size) {
        revenue_label.setColumns(15);
        billNum_label.setColumns(15);
        productNum_label.setColumns(15);
        // activity_panel.setColumns(15);
    }

    static public JPanel createMenuBar(Dimension size) {
        return new HomePanel(size);
    }

}
