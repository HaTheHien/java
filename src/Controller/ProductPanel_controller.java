package Controller;

import java.util.ArrayList;

import GUI.MainScreen.ProductPanel;
import Model.Product.Product;
import Model.Product.Warehouse;
import java.awt.event.*;

public class ProductPanel_controller implements KeyListener {
    ProductPanel productPanel;

    public ProductPanel_controller(ProductPanel productPanel) {
        this.productPanel = productPanel;
        ArrayList<Product> allProducts = Warehouse.getAllProduct();
        for (Product p : allProducts) {
            // new String[] { "Bar code", "Product name", "Product type", "Price", "Stock"
            productPanel.tableModel
                    .addRow(new String[] { p.getProductInfo().getCodeBar(), p.getProductInfo().getProductName(),
                            "Product type", p.getProductInfo().getPrice().toString(), "Stock" });
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            this.productPanel.tableModel.setRowCount(0);
            ArrayList<Product> allProducts = Warehouse.getAllProductByName(this.productPanel.searchField.getText());
            for (Product p : allProducts) {
                // new String[] { "Bar code", "Product name", "Product type", "Price", "Stock"
                productPanel.tableModel
                        .addRow(new String[] { p.getProductInfo().getCodeBar(), p.getProductInfo().getProductName(),
                                "Product type", p.getProductInfo().getPrice().toString(), "Stock" });
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
