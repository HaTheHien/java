package Controller;

import GUI.GUI_Utility.Singleproduct_Panel;
import GUI.MainScreen.POSPanel;
import Model.Product.Product;
import Model.Product.Warehouse;

public class POSPanel_controller {
    POSPanel posPanel;
    public POSPanel_controller(POSPanel posPanel){
        this.posPanel = posPanel;
        this.posPanel.allProduct = Warehouse.getAllProduct();
        for(Product p : this.posPanel.allProduct ){
            Singleproduct_Panel spp = new Singleproduct_Panel(p);
            this.posPanel.productBoxPanel.add(spp);
        }
    }
}
