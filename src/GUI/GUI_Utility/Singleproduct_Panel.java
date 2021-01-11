package GUI.GUI_Utility;

import javax.swing.ImageIcon;

import java.awt.Image;
import Model.Product.Product;

public class Singleproduct_Panel extends javax.swing.JPanel {
    java.awt.GridBagConstraints gridBagConstraints;
    javax.swing.JLabel productImg = new javax.swing.JLabel();
    javax.swing.JLabel productPrice = new javax.swing.JLabel();
    javax.swing.JLabel productName = new javax.swing.JLabel();
    javax.swing.JLabel productStock = new javax.swing.JLabel();
    public Singleproduct_Panel(Product p){
        this.setPreferredSize(new java.awt.Dimension(200, 400));
        this.setLayout(new java.awt.GridBagLayout());


        ImageIcon img = new ImageIcon(p.getUrlImgString());
        Image image = img.getImage().getScaledInstance(180,180,java.awt.Image.SCALE_SMOOTH); // scale it the smooth way // transform it
        img = new ImageIcon(image); 
        productImg.setIcon(img);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        this.add(productImg, gridBagConstraints);

        productStock.setText("Số lượng:" + p.getProductStockInfo().getNumStock());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        this.add(productStock, gridBagConstraints);

        productPrice.setText("Giá:" + Long.toString(p.getProductInfo().getPrice()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 11, 0);
        this.add(productPrice, gridBagConstraints);

        productName.setText(p.getProductInfo().getProductName());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        this.add(productName, gridBagConstraints);

    }
}
