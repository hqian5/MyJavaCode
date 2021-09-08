package stockViewer.Java_Stock_Viewer;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class DownloadData {

    private String tikerSymbol;
    private String startDate, endDate;
    private MarketPanel selectedData;

    // Arraylists to store download data
    private List<String> dateList = new ArrayList<>();
    private List<Double> openList = new ArrayList<>();
    private List<Double> highList = new ArrayList<>();
    private List<Double> lowList = new ArrayList<>();
    private List<Double> closeList = new ArrayList<>();
    private List<Integer> volumeList = new ArrayList<>();

    // constructor
    public DownloadData(String symbol, String start, String end, MarketPanel marketPanel) {

        // pass selecting data to this class
        this.tikerSymbol = symbol;
        this.startDate = start;
        this.endDate = end;
        this.selectedData = marketPanel;

        // make up the URL to download the data
        String downloadURL = "https://quotes.wsj.com/" + tikerSymbol + "/historical-prices/download?MOD_VIEW=page&num_rows=3000&startDate="
                + startDate + "&endDate=" + endDate;

        try {

            // download the selected data
            URL url = new URL(downloadURL);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();

            Scanner scanner = new Scanner(inputStream);
            String firstLine = scanner.nextLine();

            // check the validity of the data
            if (!firstLine.contains("Date, Open, High, Low, Close, Volume")){
                throw new Exception("Incorrect data!");
            }
            else {
                System.out.println(firstLine);
            }

            // scan the data and store it to Arraylists
            while (scanner.hasNextLine()){

                String nextLine = scanner.nextLine();
                System.out.println(nextLine);

                String[] dataSplit = nextLine.split(", ");

                dateList.add(String.valueOf(dataSplit[0]));
                openList.add(Double.parseDouble(dataSplit[1]));
                highList.add(Double.parseDouble(dataSplit[2]));
                lowList.add(Double.parseDouble(dataSplit[3]));
                closeList.add(Double.parseDouble(dataSplit[4]));
                volumeList.add(Integer.parseInt(dataSplit[5]));

            }

        }catch (Exception e){
                System.out.println(e.getMessage());
        }

    }

    // class method to provide dates of the data
    public String[] getDate() {

        String[] getDate = new String[dateList.size()];
        Collections.reverse(dateList);

        for (int i = 0; i < dateList.size(); i++){
            getDate[i] = dateList.get(i);
        }

        return getDate;
    }

    // class method to provide opening prices of the data
    public double[] getOpen() {

        double[] getOpen = new double[openList.size()];
        Collections.reverse(openList);

        for (int i = 0; i < openList.size();i++){
            getOpen[i] = openList.get(i);
        }

        return getOpen;
    }

    // class method to provide high prices of the data
    public double[] getHigh() {

        double[] getHigh = new double[highList.size()];
        Collections.reverse(highList);

        for (int i = 0; i < highList.size(); i++){
            getHigh[i] = highList.get(i);
        }

        return getHigh;
    }

    // class method to provide low prices of the data
    public double[] getLow() {

        double[] getLow = new double[lowList.size()];
        Collections.reverse(lowList);

        for (int i = 0; i < lowList.size(); i++){
            getLow[i] = lowList.get(i);
        }

        return getLow;
    }

    // class method to provide closing prices of the data
    public double[] getClose() {

        double[] getClose = new double[closeList.size()];
        Collections.reverse(closeList);

        for (int i = 0; i < closeList.size(); i++){
            getClose[i] = closeList.get(i);
        }

        return getClose;
    }

    // class method to provide the number of shares traded of the data
    public int[] getVolume() {

        int[] getVolume = new int[volumeList.size()];
        Collections.reverse(volumeList);

        for (int i = 0; i < volumeList.size(); i++){
            getVolume[i] = volumeList.get(i);
        }

        return getVolume;
    }

}
