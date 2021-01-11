package GUI.MainScreen;

import java.util.ArrayList;

import javax.swing.JLabel;

import Controller.POSPanel_controller;
import GUI.GUI_Utility.WrapLayout;
import Model.Bill.Bill;
import Model.Product.Product;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuand
 */


public class POSPanel extends javax.swing.JPanel {

    /**
     * Creates new form posPanel
     */

        public ArrayList<Product> allProduct;
        public POSPanel_controller posPanel_controller;
        public Bill posBill = new Bill();
        // Variables declaration - do not modify
        public javax.swing.JPanel Payment_Panel;
        public javax.swing.JScrollPane bill_ScrollPane;
        public javax.swing.JTable billunit_table;
        public javax.swing.JPanel cast_Panel;
        public javax.swing.JTextField coupon_Field;
        public javax.swing.JButton delBillunit_Btn;
        public javax.swing.JTextField finaltotal_Field;
        public javax.swing.JLabel jLabel3;
        public javax.swing.JLabel jLabel4;
        public javax.swing.JPanel jPanel2;
        public javax.swing.JPanel singleproduct_Panel;
        public javax.swing.JScrollPane jScrollPane2;
        public javax.swing.JLabel label;
        public javax.swing.JButton paid_Btn;
        public javax.swing.JPanel productBoxPanel;
        public javax.swing.JTextField search_Field;
        public javax.swing.JPanel search_Panel;
        public javax.swing.JTextField total_Field;
        public javax.swing.JComboBox<String> typesel_ComboBox;
        public javax.swing.JTextField membership_Field ;
        public javax.swing.JLabel jLabel5;
        public javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(
                new Object[][] { { null, null, null, null } },
                new String[] { "Tên hàng hoá", "Đơn giá", "Số  lượng", "Tổng" }) {
            /**
             *
             */
            private static final long serialVersionUID = 1L;
    
            boolean[] canEdit = new boolean[] { false, false, true, false };
    
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        // End of variables declaration
    public POSPanel(java.awt.Dimension size) {
        // TODO: combobox
        this.setPreferredSize(size);
        initComponents();
        //productBoxPanel.add(new Singleproduct_Panel());


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        productBoxPanel = new javax.swing.JPanel();
        singleproduct_Panel = new javax.swing.JPanel();
        search_Panel = new javax.swing.JPanel();
        search_Field = new javax.swing.JTextField();
        typesel_ComboBox = new javax.swing.JComboBox<>();
        Payment_Panel = new javax.swing.JPanel();
        bill_ScrollPane = new javax.swing.JScrollPane();
        billunit_table = new javax.swing.JTable();
        cast_Panel = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        finaltotal_Field = new javax.swing.JTextField();
        total_Field = new javax.swing.JTextField();
        coupon_Field = new javax.swing.JTextField();
        delBillunit_Btn = new javax.swing.JButton();
        paid_Btn = new javax.swing.JButton();
        membership_Field  = new  javax.swing.JTextField ();
        //singleproduct_Panel = new Singleproduct_Panel();
        setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        productBoxPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        productBoxPanel.setName(""); // NOI18N
        productBoxPanel.setLayout(new WrapLayout());

        singleproduct_Panel.setPreferredSize(new java.awt.Dimension(200, 180));
        singleproduct_Panel.setLayout(new java.awt.GridBagLayout());

        //productBoxPanel.add(singleproduct_Panel);

        jScrollPane2.setViewportView(productBoxPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 498;
        gridBagConstraints.ipady = 542;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 0);
        jPanel2.add(jScrollPane2, gridBagConstraints);

        search_Panel.setLayout(new java.awt.GridBagLayout());

        search_Field.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 240;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        search_Panel.add(search_Field, gridBagConstraints);

        // typesel_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]
        // { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 210;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        search_Panel.add(typesel_ComboBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        jPanel2.add(search_Panel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -304;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 0);
        add(jPanel2, gridBagConstraints);

        Payment_Panel.setLayout(new java.awt.GridBagLayout());

        billunit_table.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        billunit_table.setModel(tableModel);
        bill_ScrollPane.setViewportView(billunit_table);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.ipady = 250;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 10);
        Payment_Panel.add(bill_ScrollPane, gridBagConstraints);

        cast_Panel.setLayout(new java.awt.GridBagLayout());

        label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label.setText("SỐ TIỀN ĐƯỢC GIẢM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 76, 10, 0);
        cast_Panel.add(label, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("TỔNG CỘNG");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 76, 10, 0);
        cast_Panel.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("TỔNG TIỀN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.insets = new java.awt.Insets(18, 76, 10, 0);
        cast_Panel.add(jLabel4, gridBagConstraints);
        
       

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("ID thành viên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.insets = new java.awt.Insets(18, 76, 10, 0);
        cast_Panel.add(jLabel5, gridBagConstraints);
        
        membership_Field.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 256;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 80);
        cast_Panel.add(membership_Field, gridBagConstraints);

        finaltotal_Field.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 256;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 80);
        cast_Panel.add(finaltotal_Field, gridBagConstraints);

        total_Field.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 256;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 80);
        cast_Panel.add(total_Field, gridBagConstraints);

        coupon_Field.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 256;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 80);
        cast_Panel.add(coupon_Field, gridBagConstraints);

        delBillunit_Btn.setText("Xoá sản phẩm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 64;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 73, 0, 0);
        cast_Panel.add(delBillunit_Btn, gridBagConstraints);

        paid_Btn.setText("THANH TOÁN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 88;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 49, 0, 0);
        cast_Panel.add(paid_Btn, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 43;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 10);
        Payment_Panel.add(cast_Panel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -288;
        gridBagConstraints.ipady = 140;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 11, 0);
        add(Payment_Panel, gridBagConstraints);

        posPanel_controller = new POSPanel_controller(this);
    }// </editor-fold>


}
