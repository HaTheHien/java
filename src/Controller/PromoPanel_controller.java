package Controller;

import Model.Model;
import Model.Other.Promotion;

import java.util.ArrayList;

import GUI.MainScreen.PromotionPanel;

public class PromoPanel_controller {
    public PromoPanel_controller(PromotionPanel mPanel){
        ArrayList<Promotion> list = controller.getAllPromo(Model.conn);
        for (int i=0;i<list.size();i++)
            mPanel.tableModel.addRow(new String[] {String.valueOf(list.get(i).getPromoID()),list.get(i).getProductName(),String.valueOf(list.get(i).getPromoDiscount())+ "vnd"});
    }
}
