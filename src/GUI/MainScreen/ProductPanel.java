/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuand
 */
package GUI.MainScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.ProductPanel_controller;
import java.awt.event.*;
import java.awt.*;

public class ProductPanel extends JPanel {

    MainScreen mainScreen;
    // Variables declaration - do not modify
    public JTextField newbarCodeField;
    public JTextField searchField;
    public JTable productTable;
    public JScrollPane productsPanel;
    public DefaultTableModel tableModel;
    ProductPanel_controller productPanel_controller;
    // End of variables declaration
    /**
     * Creates new form ProductPanel
     */
    public ProductPanel(Dimension size, MainScreen mainScreen) {
        this.setPreferredSize(size);
        this.mainScreen = mainScreen;
        initComponents();
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

        productsPanel = new JScrollPane();
        productTable = new JTable();
        searchField = new JTextField();
        newbarCodeField = new JTextField();

        setLayout(new java.awt.GridBagLayout());

        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Bar code", "Product name", "Product type", "Price", "Stock" }) {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;// This causes all cells to be not editable
            }
        };

        // ADD PRODUCT HERE
        //tableModel.addRow(new String[] { "Bar code", "Product name", "Product type", "Price", "Stock" });
        
        productTable.setModel(tableModel);
        // productTable.getSelectionModel().addListSelectionListener(
        // new ListSelectionListener());

        productsPanel.setViewportView(productTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        // gridBagConstraints.ipadx = 571;
        // gridBagConstraints.ipady = 329;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 11, 10);
        add(productsPanel, gridBagConstraints);

        searchField.setText("search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 10, 0, 0);
        add(searchField, gridBagConstraints);

        // set combobox choice category
        newbarCodeField.setText("Enter new product's bar code");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 6, 0, 10);
        add(newbarCodeField, gridBagConstraints);

        //Create controller and binding UI to controller
        productPanel_controller =  new ProductPanel_controller(this);
        searchField.addKeyListener(productPanel_controller);
        newbarCodeField.addKeyListener(productPanel_controller);
        productTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // TODO:
            }
        });
    }// </editor-fold>
    
}
