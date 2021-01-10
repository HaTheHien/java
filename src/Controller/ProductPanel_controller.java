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
        if (allProducts != null)
            for (Product p : allProducts) {
                productPanel.tableModel.addRow(new String[] { p.getProductInfo().getCodeBar(),
                        p.getProductInfo().getProductName(), p.getProducType().getTypeName(),
                        p.getProductInfo().getPrice().toString(), p.getProductStockInfo().getNumStock().toString() });
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
            if (allProducts != null)
                for (Product p : allProducts) {
                    productPanel.tableModel.addRow(new String[] { p.getProductInfo().getCodeBar(),
                            p.getProductInfo().getProductName(), p.getProducType().getTypeName(),
                            p.getProductInfo().getPrice().toString(), p.getProductStockInfo().getNumStock().toString() });
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
