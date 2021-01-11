package Controller;

import javax.swing.ImageIcon;
import java.awt.Image;
import GUI.MainScreen.MainScreen;
import GUI.MainScreen.ProductDetailPanel;
import Model.Product.ProductType;
import Model.Product.Warehouse;
import java.awt.event.*;
import java.sql.Date;
import java.util.ArrayList;

public class ProductDetailPanel_controller implements KeyListener, ActionListener {
    ProductDetailPanel productDetailPanel;
    MainScreen mainScreen;


    public ProductDetailPanel_controller(ProductDetailPanel productDetailPanel, MainScreen mainScreen) {
        // load product data
        this.productDetailPanel = productDetailPanel;
        this.mainScreen = mainScreen;
        this.productDetailPanel.productLabel.setText(this.productDetailPanel.p.getProductInfo().getProductName());

        this.productDetailPanel.barcode_Field.setText(this.productDetailPanel.p.getProductInfo().getCodeBar());

        this.productDetailPanel.productname_Field.setText(this.productDetailPanel.p.getProductInfo().getProductName());

        this.productDetailPanel.price_Field.setText(Long.toString(this.productDetailPanel.p.getProductInfo().getPrice()));

        this.productDetailPanel.brand_Field.setText(this.productDetailPanel.p.getProductInfo().getBrand());

        this.productDetailPanel.stock_Field
                .setText(this.productDetailPanel.p.getProductStockInfo().getNumStock().toString());

        this.productDetailPanel.lastestEXP_Field
                .setText(this.productDetailPanel.p.getProductStockInfo().getLastestEXP().toString());

        this.productDetailPanel.promo_Field
                .setText(Long.toString(productDetailPanel.p.getPromotion().getPromoDiscount()));

        this.productDetailPanel.urlImg_Field.setText(this.productDetailPanel.p.getUrlImgString());

        ImageIcon productImg = new ImageIcon(this.productDetailPanel.p.getUrlImgString());
        Image image = productImg.getImage().getScaledInstance(250,250,java.awt.Image.SCALE_SMOOTH); // scale it the smooth way // transform it
        productImg = new ImageIcon(image); 
        this.productDetailPanel.productImg_Label.setIcon(productImg);

        //load product type
        int index = 0;
        for (ProductType pt :this.productDetailPanel.allType) {
            this.productDetailPanel.typeProduct_ComboBox.addItem(pt.getTypeName());
            if(pt.getTypeID().compareTo(this.productDetailPanel.p.getProducType().getTypeID()) == 0){
                this.productDetailPanel.typeProduct_ComboBox.setSelectedIndex(index);
            }
            index ++;
        }
    }

    public boolean updateProduct() {
        //update product in database

        this.productDetailPanel.p.getProductInfo().setCodeBar(this.productDetailPanel.barcode_Field.getText());

        this.productDetailPanel.p.getProductInfo().setProductName(this.productDetailPanel.productname_Field.getText());

        this.productDetailPanel.p.getProductInfo().setPrice(Integer.parseInt(productDetailPanel.price_Field.getText()));

        this.productDetailPanel.p.getProductInfo().setBrand(this.productDetailPanel.brand_Field.getText());

        this.productDetailPanel.p.getProductStockInfo()
                .setNumStock(Integer.parseInt(this.productDetailPanel.stock_Field.getText()));

        this.productDetailPanel.p.getProductStockInfo()
                .setLastestEXP(Date.valueOf(this.productDetailPanel.lastestEXP_Field.getText()));

        this.productDetailPanel.p.getPromotion()
                .setPromoDiscount(Integer.parseInt(this.productDetailPanel.promo_Field.getText()));

        this.productDetailPanel.p.setUrlImgString(this.productDetailPanel.urlImg_Field.getText());
        
        this.productDetailPanel.p.getProducType().setTypeID(
                this.productDetailPanel.allType.get(this.productDetailPanel.typeProduct_ComboBox.getSelectedIndex()).getTypeID());

        return this.productDetailPanel.p.updateProduct();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().compareTo("update") == 0) {
            if (this.updateProduct() == true) {
                this.productDetailPanel.jLabel1.setText("Cập nhật thành công");
            } else {
                this.productDetailPanel.jLabel1.setText("Cập nhật thất bại");
            }
        }
    }

}
