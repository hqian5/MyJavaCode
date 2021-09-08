package stockViewer.Java_Stock_Viewer;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class DataGraph {

    // arrays to store the data
    private String[] getDate;
    private double[] getOpen;
    private double[] getHigh;
    private double[] getLow;
    private double[] getClose;
    private int[] getVolume;

    private MarketPanel selectedData;
    private DownloadData downloadData;

    public DataGraph(String[] date, double[] open, double[] high, double[] low, double[] close, int[] volume, MarketPanel marketPanel, DownloadData download) {

        this.getDate = date;
        this.getOpen = open;
        this.getHigh = high;
        this.getLow = low;
        this.getClose = close;
        this.getVolume = volume;
        this.selectedData = marketPanel;
        this.downloadData = download;

        }

    // set X and Y axises for the graph of opening prices
    public XYChart.Series getOpenData() {

        Series<String, Double> openSeries = new XYChart.Series<String, Double>();
        openSeries.setName("Opening price");

        if (getOpen.length == 0){
            try {
                getOpen = zero;
            }catch (Exception e){System.out.println(e.getMessage());}
        }

        else {

            for (int i = 0; i < getDate.length; i++) {

                openSeries.getData().add(new XYChart.Data<>(getDate[i], getOpen[i]));

            }
        }

        return openSeries;
    }

    // set X and Y axises for the graph of high prices
    public XYChart.Series getHighData() {

        Series<String, Double> highSeries = new XYChart.Series<String, Double>();
        highSeries.setName("High price");

        if (getHigh.length == 0){
            try {
                getHigh = zero;
            }catch (Exception e){System.out.println(e.getMessage());}
        }

        else {

            for (int i = 0; i < getDate.length; i++) {

                highSeries.getData().add(new XYChart.Data<>(getDate[i], getHigh[i]));

            }
        }

        return highSeries;
    }

    // set X and Y axises for the graph of low prices
    public XYChart.Series getLowData() {

        Series<String, Double> lowSeries = new XYChart.Series<String, Double>();
        lowSeries.setName("Low price");

        if (getLow.length == 0){
            try {
                getLow = zero;
            }catch (Exception e){System.out.println(e.getMessage());}
        }

        else {

            for (int i = 0; i < getDate.length; i++) {

                lowSeries.getData().add(new XYChart.Data<>(getDate[i], getLow[i]));

            }
        }

        return lowSeries;
    }

    // set X and Y axises for the graph of cloing prices
    public XYChart.Series getCloseData() {

        Series<String, Double> closeSeries = new XYChart.Series<String, Double>();
        closeSeries.setName("Closing Price");

        if (getClose.length == 0){
            try {
                getClose = zero;
            }catch (Exception e){System.out.println(e.getMessage());}
        }

        else {

            for (int i = 0; i < getDate.length; i++) {

                closeSeries.getData().add(new XYChart.Data<>(getDate[i], getClose[i]));

            }
        }

        return closeSeries;
    }

    private double openMax() {

        double openMax = 1;

        if (getOpen.length == 0){
            try {
                openMax = 0;
            }catch (Exception e){System.out.println(e.getMessage());}
        }

        else {

            openMax = getOpen[0];

            for (int i = 0; i < getOpen.length; i++) {

                if (getOpen[i] > openMax) {
                    openMax = getOpen[i];
                }

            }
        }

        return openMax;
    }

    private double openMin() {

        double openMin = 1;

        if (getOpen.length == 0){
            try {
                openMin = 0;
            }catch (Exception e){System.out.println(e.getMessage());}
        }

        else {

            openMin = getOpen[0];

            for (int i = 0; i < getOpen.length; i++) {

                if (getOpen[i] < openMin) {
                    openMin = getOpen[i];
                }

            }
        }

        return openMin;
    }

    private double highMax() {

        double highMax = 1;

        if (getHigh.length == 0){
            try {
                highMax = 0;
            }catch (Exception e){System.out.println(e.getMessage());}
        }

        else {

            highMax = getHigh[0];

            for (int i = 0; i < getHigh.length; i++) {

                if (getHigh[i] > highMax) {
                    highMax = getHigh[i];
                }

            }
        }

        return highMax;
    }

    private double highMin() {

        double highMin = 1;

        if (getHigh.length == 0){
            try {
                highMin = 0;
            }catch (Exception e){System.out.println(e.getMessage());}
        }

        else {

            highMin = getHigh[0];

            for (int i = 0; i < getHigh.length; i++) {

                if (getHigh[i] < highMin) {
                    highMin = getHigh[i];
                }

            }
        }

        return highMin;
    }

    private double lowMax() {

        double lowMax = 1;

        if (getLow.length == 0){
            try {
                lowMax = 0;
            }catch (Exception e){System.out.println(e.getMessage());}
        }

        else {

            lowMax = getLow[0];

            for (int i = 0; i < getLow.length; i++) {

                if (getLow[i] > lowMax) {
                    lowMax = getLow[i];
                }

            }
        }

        return lowMax;
    }

    private double lowMin() {

        double lowMin = 1;

        if (getLow.length == 0){
            try {
                lowMin = 0;
            }catch (Exception e){System.out.println(e.getMessage());}
        }

        else {

            lowMin = getLow[0];

            for (int i = 0; i < getLow.length; i++) {

                if (getLow[i] < lowMin) {
                    lowMin = getLow[i];
                }

            }
        }

        return lowMin;
    }

    private double closeMax() {

        double closeMax = 1;

        if (getClose.length == 0){
            try {
                closeMax = 0;
            }catch (Exception e){System.out.println(e.getMessage());}
        }

        else {

            closeMax = getClose[0];

            for (int i = 0; i < getClose.length; i++) {

                if (getClose[i] > closeMax) {
                    closeMax = getClose[i];
                }

            }
        }

        return closeMax;
    }

    private double closeMin() {

        double closeMin = 1;

        if (getClose.length == 0){
            try {
                closeMin = 0;
            }catch (Exception e){System.out.println(e.getMessage());}
        }

        else {

            closeMin = getClose[0];

            for (int i = 0; i < getClose.length; i++) {

                if (getClose[i] < closeMin) {
                    closeMin = getClose[i];
                }

            }
        }

        return closeMin;
    }

    public double getYAxisMax() {

        double[] yAxis = {openMax(), highMax(), lowMax(), closeMax()};
        double yAxisMax = yAxis[0];

        for (int i = 0; i < yAxis.length; i++){

            if (yAxis[i] > yAxisMax) {
                yAxisMax = yAxis[i];
            }

        }

        return yAxisMax + 2;
    }

    public double getYAxisMin() {

        double[] yAxis = {openMin(), highMin(), lowMin(), closeMin()};
        double yAxisMin = yAxis[0];

        for (int i = 0; i < yAxis.length; i++){

            if (yAxis[i] < yAxisMin) {
                yAxisMin = yAxis[i];
            }

        }

        return yAxisMin - 2;
    }


    private double[] zero = {0};

}
