package Controller;


import GUI.MainScreen.HomePanel;
import GUI.MainScreen.ProductPanel;
import Model.Product.Product;
import Model.Product.Warehouse;
import java.awt.event.*;

public class HomePanel_controller {
    HomePanel homePanel;

    public HomePanel_controller(HomePanel homePanel) {
        this.homePanel = homePanel;
        this.homePanel.productNum = Warehouse.getNumProduct();
        this.homePanel.aboutExpireProductNum = Warehouse.getnumProductExpired();
    }

};
