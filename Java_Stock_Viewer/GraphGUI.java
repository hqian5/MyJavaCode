package stockViewer.Java_Stock_Viewer;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphGUI extends JFrame implements ActionListener {

    private DataGraph dataGraph;
    private JFXPanel jfxPanel;

    private JPanel backPanel;
    private JButton backButton;

    public GraphGUI(DataGraph graph) {

        this.dataGraph = graph;

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        double width = dimension.getWidth();
        double height = dimension.getHeight();
        setBounds(50,50, (int)width/2, (int)height/2);

        jfxPanel = new JFXPanel();
        backPanel = new JPanel();
        backButton = new JButton("back");


        backPanel.add(backButton);

        this.add(jfxPanel);
        this.add(backPanel, BorderLayout.SOUTH);

        backButton.addActionListener(this);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                CategoryAxis xAxis = new CategoryAxis();
                NumberAxis yAxis = new NumberAxis(dataGraph.getYAxisMin(), dataGraph.getYAxisMax(), 1);
                LineChart<String, Number> lineChart = new LineChart(xAxis, yAxis);
                lineChart.setCreateSymbols(false);

                // add selected data to the chart
                lineChart.getData().add(dataGraph.getOpenData());
                lineChart.getData().add(dataGraph.getHighData());
                lineChart.getData().add(dataGraph.getLowData());
                lineChart.getData().add(dataGraph.getCloseData());
                Scene scene = new Scene(lineChart);

                jfxPanel.setScene(scene);

            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getActionCommand();

        if (source == "back"){
            setVisible(false);
        }
    }
}
