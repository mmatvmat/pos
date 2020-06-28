package owca.czarna;

import org.jfree.chart.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa tworzy okno i umożliwia oglądanie i zarządzenie wykresami
 */
public class ManageCharts extends ApplicationFrame {

    private String filename = "dane.xls";
    protected final String[] exercises;
    protected JPanel panel;
    public ManageCharts(String title) {
        super(title);
        //TODO: Dodac wszystkie cwiczenia
        exercises = new String[]{"Podciąganie nachwytem", "Szerokie pompki", "Podciąganie podchwytem",
                "Wąskie pompki", "Stanie na rękach", "Przysiady", "Wspięcia na palce", "Unoszenie nóg",
        "Superman", "Plank"};
        setDefaultCloseOperation(3);
        initialize();
    }

    /**
     * Metoda tworzy panel i dodaje do niego comoboBoxa oraz wykres
     */
    private void initialize() {
        panel = new JPanel(new BorderLayout());
        JPanel chartPanel = new JPanel();
        JComboBox<String> exComboBox = new JComboBox<>(exercises);
        exComboBox.setSelectedItem(null);
        exComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(exComboBox.getSelectedItem().equals(exercises[0])){
                    DrawGraph pompkiGraph = new DrawGraph(filename, exercises[0]);
                    chartPanel.removeAll();
                    chartPanel.add(pompkiGraph.getPanel(), BorderLayout.CENTER);
                }
                if(exComboBox.getSelectedItem().equals(exercises[1])){
                    DrawGraph plankGraph = new DrawGraph(filename, exercises[1]);
                    chartPanel.removeAll();
                    chartPanel.add(plankGraph.getPanel());
                }
                if(exComboBox.getSelectedItem().equals(exercises[2])){
                    DrawGraph brzuszkiGrph = new DrawGraph(filename,exercises[2]);
                    chartPanel.removeAll();
                    chartPanel.add(brzuszkiGrph.getPanel());
                }
                if(exComboBox.getSelectedItem().equals(exercises[3])){
                    DrawGraph podciagnieciaGraph = new DrawGraph(filename,exercises[3]);
                    chartPanel.removeAll();
                    chartPanel.add(podciagnieciaGraph.getPanel());
                }
                if(exComboBox.getSelectedItem().equals(exercises[4])){
                    DrawGraph pomGraph = new DrawGraph(filename,exercises[4]);
                    chartPanel.removeAll();
                    chartPanel.add(pomGraph.getPanel());
                }
                if(exComboBox.getSelectedItem().equals(exercises[5])){
                    DrawGraph podciagnieciaGraph = new DrawGraph(filename,exercises[5]);
                    chartPanel.removeAll();
                    chartPanel.add(podciagnieciaGraph.getPanel());
                }
                if(exComboBox.getSelectedItem().equals(exercises[6])){
                    DrawGraph podciagnieciaGraph = new DrawGraph(filename,exercises[6]);
                    chartPanel.removeAll();
                    chartPanel.add(podciagnieciaGraph.getPanel());
                }
                if(exComboBox.getSelectedItem().equals(exercises[7])){
                    DrawGraph podciagnieciaGraph = new DrawGraph(filename,exercises[7]);
                    chartPanel.removeAll();
                    chartPanel.add(podciagnieciaGraph.getPanel());
                }
                if(exComboBox.getSelectedItem().equals(exercises[8])){
                    DrawGraph podciagnieciaGraph = new DrawGraph(filename,exercises[8]);
                    chartPanel.removeAll();
                    chartPanel.add(podciagnieciaGraph.getPanel());
                }
                if(exComboBox.getSelectedItem().equals(exercises[9])){
                    DrawGraph podciagnieciaGraph = new DrawGraph(filename,exercises[9]);
                    chartPanel.removeAll();
                    chartPanel.add(podciagnieciaGraph.getPanel());
                }

                invalidate();
                validate();
                repaint();
            }
        });

        panel.add(exComboBox, BorderLayout.NORTH);
        panel.add(chartPanel);
        add(panel);
        //TODO: tutaj chyba względem naszej aplikacji trzeba to poprawic
        setLocationRelativeTo(null);
        setSize(750,460);
        setVisible(true);
    }

}
