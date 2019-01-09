package stockViewer;

import javax.swing.*;
import java.awt.*;

public class MarketGUI extends JFrame {

    private MarketPanel marketPanel;

    // constructor
    public MarketGUI () {

        // set the title of the first window
        setTitle("Stock Market Data Searcher");

        // position and size
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        double width = dimension.getWidth();
        double height = dimension.getHeight();
        setBounds(0,0, (int)width/2, (int)height/2);

        // add the main panel
        marketPanel = new MarketPanel();
        Container container = getContentPane();
        container.add(marketPanel);

    }

    public static void main(String args[]) {

        // visualise the first window
        JFrame frm = new MarketGUI();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);

    }
}
