package stockViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarketPanel extends JPanel implements ActionListener {

    // widgets for the panel of selecting ticker symbol
    private JLabel tickerSymbol;
    private JComboBox symbolChoice = new JComboBox();
    private String[] symbols = new String[] {"MSFT", "AAPL", "AMZN"};

    // widgets for the panel of selecting start and end dates
    private JLabel startyearLabel, endyearLabel;
    private JComboBox startyearBox = new JComboBox(), endyearBox = new JComboBox();
    private int startYear = 2012, endYear = 2018;
    private JLabel startmonthLabel, endmonthLabel;
    private JComboBox startmonthBox = new JComboBox(), endmonthBox = new JComboBox();
    private JLabel startdayLabel, enddayLabel;
    private JComboBox startdayBox = new JComboBox(), enddayBox = new JComboBox();

    // text to show the status of data to user
    private JTextArea statusArea;

    // buttons for search and exit
    private JButton searchButton;
    private JButton exitButton;

    // five panels for different areas
    private JPanel symbolPanel = new JPanel();
    private JPanel datePanel1 = new JPanel();
    private JPanel datePanel2 = new JPanel();
    private JPanel statusPanel = new JPanel();
    private JPanel searchPanel = new JPanel();

    // constructor
    public MarketPanel() {

        // the drop-down menu for selecting ticker symbols
        tickerSymbol = new JLabel("Select a ticker symbol:");
        symbolChoice.setPreferredSize(new Dimension(70,20));

        // add widgets for ticker symbols to a subPanel
        symbolPanel.add(tickerSymbol);
        symbolPanel.add(symbolChoice);

        for (int i = 0; i < symbols.length; i++){
            symbolChoice.addItem(symbols[i]);
        }

        // drop-down menus for selecting start and end dates
        startyearLabel = new JLabel("Start date: Year");
        startmonthLabel = new JLabel("Month");
        startdayLabel = new JLabel("Day");

        endyearLabel = new JLabel("End date: Year");
        endmonthLabel = new JLabel("Month");
        enddayLabel = new JLabel("Day");

        startyearBox.setPreferredSize(new Dimension(70, 20));
        startmonthBox.setPreferredSize(new Dimension(50, 20));
        startdayBox.setPreferredSize(new Dimension(50, 20));

        endyearBox.setPreferredSize(new Dimension(70, 20));
        endmonthBox.setPreferredSize(new Dimension(50, 20));
        enddayBox.setPreferredSize(new Dimension(50, 20));

        // add widgets for selecting dates to a subPanel for dates
        datePanel1.add(startyearLabel);
        datePanel1.add(startyearBox);
        datePanel1.add(startmonthLabel);
        datePanel1.add(startmonthBox);
        datePanel1.add(startdayLabel);
        datePanel1.add(startdayBox);

        datePanel2.add(endyearLabel);
        datePanel2.add(endyearBox);
        datePanel2.add(endmonthLabel);
        datePanel2.add(endmonthBox);
        datePanel2.add(enddayLabel);
        datePanel2.add(enddayBox);

        // add items to drop-down menus of dates
        for (int i = startYear; i <= endYear; i++) {
            startyearBox.addItem(i);
            endyearBox.addItem(i);
        }

        for (int j = 0; j < 12; j++){
            startmonthBox.addItem(j+1);
            endmonthBox.addItem(j+1);
        }

        for (int k = 0; k < 31; k++){
            startdayBox.addItem(k+1);
            enddayBox.addItem(k+1);
        }

        // area to show the status of data
        statusArea = new JTextArea();
        statusArea.setVisible(false);

        // add the status area to a subPanel
        statusPanel.add(statusArea);

        // buttons for search and exit
        searchButton = new JButton("search");
        exitButton = new JButton("exit");

        // add buttons for search and exit to a subPanel
        searchPanel.add(searchButton);
        searchPanel.add(exitButton);

        // set the layout for the whole GUI
        GridLayout gridLayout = new GridLayout(5,1);
        this.setLayout(gridLayout);

        // add all subPanels to the GUI
        this.add(symbolPanel);
        this.add(datePanel1);
        this.add(datePanel2);
        this.add(statusPanel);
        this.add(searchPanel);

        // add actions to date widgets
        startdayBox.addActionListener(this);
        startmonthBox.addActionListener(this);
        startyearBox.addActionListener(this);

        enddayBox.addActionListener(this);
        endmonthBox.addActionListener(this);
        endyearBox.addActionListener(this);

        // add actions to search and exit buttons
        searchButton.addActionListener(this);
        exitButton.addActionListener(this);

    }

    public void actionPerformed (ActionEvent actionEvent) {

        // set the standard date format for date boxes
        Object source1 = startmonthBox.getSelectedItem();

        // record situation before changing the drop-down box
        int selectedIndex1 = startdayBox.getSelectedIndex();
        int months1 = Integer.parseInt(source1.toString());
        int days1 = 31;

        startdayBox.removeAllItems();

        // 30-day months
        if (months1 == 4 || months1 == 6 || months1 == 9 || months1 == 11){
            days1 = 30;
        }

        // leap years
        else if (months1 == 2){

            int years1 = Integer.parseInt(startyearBox.getSelectedItem().toString());
            if (years1 % 400 == 0 || (years1 % 4 == 0 && years1 % 100 != 0)){
                days1 = 29;
            }

            // common years
            else {
                days1 = 28;
            }
        }

        for (int i = 0; i < days1; i++){
            startdayBox.addItem(i+1);
        }

        // set the former situation
        startdayBox.setSelectedIndex(selectedIndex1);

        Object source2 = endmonthBox.getSelectedItem();

        // record situation before changing the drop-down box
        int selectedIndex2 = enddayBox.getSelectedIndex();
        int months2 = Integer.parseInt(source2.toString());
        int days2 = 31;

        enddayBox.removeAllItems();

        // 30-day months
        if (months2 == 4 || months2 == 6 || months2 == 9 || months2 == 11){
            days2 = 30;
        }

        // leap months
        else if (months2 == 2){

            int years2 = Integer.parseInt(endyearBox.getSelectedItem().toString());
            if (years2 % 400 == 0 || (years2 % 4 == 0 && years2 % 100 != 0)){
                days2 = 29;
            }

            // common years
            else {
                days2 = 28;
            }
        }

        for (int j = 0; j < days2; j++){
            enddayBox.addItem(j+1);
        }

        // set the former situation
        enddayBox.setSelectedIndex(selectedIndex2);

        // set actions for search and exit buttons
        String source = actionEvent.getActionCommand();

        if (source == "search"){

            // check if selecting dates are correct
            if (Integer.valueOf(startyearBox.getSelectedItem().toString()) > Integer.valueOf(endyearBox.getSelectedItem().toString())){

                try {
                    statusArea.setVisible(true);
                    statusArea.setText("Invalid date!");
                }catch (Exception e1){
                    System.out.println(e1.getMessage());
                }

            }

            // show the second window if the selecting dates are correct
            else {

                statusArea.setVisible(true);
                statusArea.setText("Correct date, showing...");
                DownloadData downloadData = new DownloadData(getTikerSymbol(), getStartDate(), getEndDate(), this);
                DataGraph dataGraph = new DataGraph(downloadData.getDate(), downloadData.getOpen(), downloadData.getHigh(), downloadData.getLow(), downloadData.getClose(), downloadData.getVolume(), this, downloadData);
                GraphGUI graphGUI = new GraphGUI(dataGraph);
                graphGUI.setTitle(" The graph of " + getTikerSymbol());
                graphGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                graphGUI.setVisible(true);

            }

        }

        // action for exit button
        if (source == "exit") {
            System.exit(0);
        }

    }

    // a class method to obtain the selected ticker symbol
    public String getTikerSymbol(){

        return symbolChoice.getSelectedItem().toString();

    }

    // a class method to acquire the selected start date
    public String getStartDate() {

        String startMonth = startmonthBox.getSelectedItem().toString();
        String startDay = startdayBox.getSelectedItem().toString();
        String startYear = startyearBox.getSelectedItem().toString();

        int startMonth1 = Integer.parseInt(startMonth);
        int startDay1 = Integer.parseInt(startDay);

        String startDate;

        // correct the date format to fit the standard of Wall Street Journal
        if (startMonth1 < 10){
            if (startDay1 < 10){
                startDate = "0" + startMonth + "/" + "0" + startDay + "/" + startYear;
            }
            else{
                startDate = "0" + startMonth + "/" + startDay + "/" + startYear;
            }
        }

        else {
            if (startDay1 < 10){
                startDate = startMonth + "/" + "0" + startDay + "/" + startYear;
            }
            else {
                startDate = startMonth + "/" + startDay + "/" + startYear;
            }
        }

        return startDate;

    }

    // a class method to gain the selected end date
    public String getEndDate(){

        String endMonth = endmonthBox.getSelectedItem().toString();
        String endDay = enddayBox.getSelectedItem().toString();
        String endYear = endyearBox.getSelectedItem().toString();

        int endMonth1 = Integer.parseInt(endMonth);
        int endDay1 = Integer.parseInt(endDay);

        String endDate;

        // correct the date format to fit the standard of Wall Street Journal
        if (endMonth1 < 10){
            if (endDay1 < 10){
                endDate = "0" + endMonth + "/" + "0" + endDay + "/" + endYear;
            }
            else {
                endDate = "0" + endMonth + "/" + endDay + "/" + endYear;
            }
        }

        else {
            if (endDay1 < 10) {
                endDate = endMonth + "/" + "0" + endDay + "/" + endYear;
            }
            else {
                endDate = endMonth + "/" + endDay + "/" + endYear;
            }
        }

        return endDate;

    }

}
