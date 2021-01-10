package Controller;


import GUI.MainScreen.HomePanel;
import GUI.MainScreen.ProductPanel;
import Model.Model;
import Model.Product.Product;
import Model.Product.Warehouse;
import java.awt.event.*;

public class HomePanel_controller {
    HomePanel homePanel;

    public HomePanel_controller(HomePanel homePanel) {
        this.homePanel = homePanel;
        this.homePanel.productNum = Warehouse.getNumProduct();
        this.homePanel.aboutExpireProductNum = Warehouse.getnumProductExpired();
        this.homePanel.outStockProductNum =  controller.numProductOutStock(Model.conn);
        this.homePanel.productTypeNum = controller.numTypeProduct(Model.conn);
        this.homePanel.soldProductNum = controller.getNumSoldProduct(Model.conn);
        this.homePanel.revenue = controller.getRevenue(Model.conn);
        this.homePanel.billNum = controller.getnumBill(Model.conn);
        this.homePanel.stockProductNum = controller.getStockProductNum(Model.conn);
        this.homePanel.aboutOutStockProductNum =controller.getAboutOutStockProductNum(Model.conn);
        this.homePanel.aboutExpireProductNum =controller.getAboutExpireProductNum(Model.conn);
    }

};
