package GUI.GUI_Utility;
import javax.swing.*;
import java.awt.*;

public class  Utility {
    public static void addComponent(Container container, Component component, GridBagConstraints constraints, int gridx,
    int gridy, int gridwidth, int gridheight, int anchor, int ipadx, int ipady,float weightx, float weighty,int fill) {
        //constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.fill = fill;
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.anchor = anchor;
        constraints.ipadx = ipadx;
        constraints.ipady = ipady;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        container.add(component, constraints);
} 
}
