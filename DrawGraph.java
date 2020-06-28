package owca.czarna;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.*;
import java.util.List;

/**
 * Klasa w której zbierane są dane i tworzony jest wykres
 */
public class DrawGraph {

    private String chartTitle = "Twoje osiągnięcia";
    private String dataFilename;
    private List<Float> repData = new ArrayList<>();
    private List<String> exData = new ArrayList<>();
    private ChartPanel chartPanel;
    public DrawGraph(String dataFilename, String exName) {
        this.dataFilename = dataFilename;
        JFreeChart barChart = ChartFactory.createBarChart(chartTitle,
                "Data", "Wynik",
                createDataset(dataFilename, exName), PlotOrientation.VERTICAL,true,true,false );

        chartPanel = new ChartPanel(barChart);
        getPanel();
    }

    public ChartPanel getPanel() {
        return chartPanel;
    }

    /**
     * Metoda wykreśla wykres na podstawie odczytanych danych z excel
     * @param dataFilename nazwa pliku wejściowego
     * @param exName nazwa ćwiczenia
     * @return dataset czyli zestaw uporządkowanych danych do wykreślenia
     */
    private CategoryDataset createDataset(String dataFilename, String exName) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //tutaj wczytywanie z pliku danych
        ReadExcel readExcel = new ReadExcel(dataFilename);
        //wczytaj
        readExcel.readData();
        repData = readExcel.getRepData();
        exData = readExcel.getExData();
        Iterator<Float> repIterator = repData.iterator();
//        Iterator<String> exIterator = exData.iterator();
        int i = 0, j=0;
        while(repIterator.hasNext()){
            if(exData.get(i).equals(exName))
                dataset.addValue(repData.get((i-3)/2), exData.get(i), exData.get(i+1));
            if(i<exData.size()-1) {
                i++;
            } else
                break;
        }

        return dataset;

    }

}
