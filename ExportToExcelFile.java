import java.awt.event.*;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.*;
import javax.swing.table.*;
import jxl.*;
import jxl.write.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportToExcelFile {

    /**
     * Funkcja tworzenia nowgo arkusza pliku Excel.
     * Zapisywanie do pliku.
     */
    void fillData(JTable table, File file) {

        try {

            WritableWorkbook workbook1 = Workbook.createWorkbook(file);
            WritableSheet sheet1 = workbook1.createSheet("First Sheet", 0);
            TableModel model = table.getModel();

            for (int i = 0; i < model.getColumnCount(); i++) {
                Label column = new Label(i, 0, model.getColumnName(i));
                sheet1.addCell(column);
            }
            int j = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                for (j = 0; j < model.getColumnCount(); j++) {
                    Label row = new Label(j, i + 1,
                            model.getValueAt(i, j).toString());
                    sheet1.addCell(row);
                    sheet1.addRowPageBreak(i);
                }
            }
            workbook1.write();
            workbook1.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        /**
         * Utworzenie gotowych obiektów - rodzajów ćwiczeń. Obiekty mogą być modyfikowane, dodawane, usuwane.
         * Obiekty utworzone w kodzie, zawsze pojawiają się po włączeniu okna aplikacji w takiej samej formie
         */
        Object[] row1 = {"Podciąganie nachwytem", "", "yyyy-mm-dd"};
        Object[] row2 = {"Szerokie pompki", "", "yyyy-mm-dd"};
        Object[] row3 = {"Podciąganie podchwytem", "", "yyyy-mm-dd"};
        Object[] row4 = {"Wąskie pompki", "", "yyyy-mm-dd"};
        Object[] row5 = {"Stanie na rękach", "", "yyyy-mm-dd"};
        Object[] row6 = {"Przysiady", "", "yyyy-mm-dd"};
        Object[] row7 = {"Wspięcia na palce", "", "yyyy-mm-dd"};
        Object[] row8 = {"Unoszenie nóg", "", "yyyy-mm-dd"};
        Object[] row9 = {"Superman", "", "yyyy-mm-dd"};
        Object[] row10 = {"Plank", "", "yyyy-mm-dd"};
        Object[] row = new Object[4];

        /**
         * Nagłówki wyświetlanych kolumn
         */
        Object[] headers = {"Nazwa cwiczenia", "Powtórzenia", "Data"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(headers);

        /**
         * Utworzenie JFrame
         */
        JFrame frame = new JFrame("Zapis postępów do pliku Excel");

        final JTable table = new JTable(model);
        table.setModel(model);

        /**
         * Dodanie do modelu wcześniej utworzonych obiektów
         */
        model.addRow(row1);
        model.addRow(row2);
        model.addRow(row3);
        model.addRow(row4);
        model.addRow(row5);
        model.addRow(row6);
        model.addRow(row7);
        model.addRow(row8);
        model.addRow(row9);
        model.addRow(row10);

        JScrollPane scroll = new JScrollPane(table);

        JTextField textExercises = new JTextField("Cwiczenie");
        JTextField textRepeat = new JTextField("Powtórzenia");
        //JSpinner spinRepeat = new JSpinner();
        JLabel labelSavePath1 = new JLabel("Wybierz folder i zapisz plik w rozszerzeniu");
        JLabel labelSavePath2 = new JLabel(".xls, np.: 'Progres.xls'");

        LocalDate data = LocalDate.now();
        JTextField textData = new JTextField(data.toString());

        JButton bAdd = new JButton("Dodaj");
        JButton bDelete = new JButton("Usuń");
        JButton bUpdate = new JButton("Aktuallizacja");
        JButton bSave = new JButton("Zapisz");

        textExercises.setBounds(150, 250, 100, 25);
        textRepeat.setBounds(300, 250, 100, 25);
        //spinRepeat.setBounds(300, 250, 100, 25);
        textData.setBounds(450, 250, 100, 25);
        labelSavePath1.setBounds(600, 250, 1000, 25);
        labelSavePath2.setBounds(600, 270, 1000, 25);

        bAdd.setBounds(150, 300, 100, 25);
        bUpdate.setBounds(300, 300, 100, 25);
        bDelete.setBounds(450, 300, 100, 25);
        bSave.setBounds(600, 300, 100, 25);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);


        /**
         * Funkcja wybierania i zapisu do wybranego pliku (wybranie ścieżki do zapisu)
         */
                bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Specify a file to save");

                    int userSelection = fileChooser.showSaveDialog(frame);

                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        File fileToSave = fileChooser.getSelectedFile();
                        System.out.println("Save as file: " + fileToSave.getAbsolutePath());

                        ExportToExcelFile exp = new ExportToExcelFile();
                        exp.fillData(table, new File(String.valueOf(fileToSave)));
                        JOptionPane.showMessageDialog(null, "Zapisano w  " + String.valueOf(fileToSave) +
                                        " poprawnie", "Informacja",
                                JOptionPane.INFORMATION_MESSAGE);

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });

        /**
         * Funkcje przycisku dodawania danych
         */
        bAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                row[0] = textExercises.getText();
                row[1] = Integer.parseInt(textRepeat.getText());
                //row[1] = spinRepeat.getValue();
                row[2] = textData.getText();

                // add row to the model
                model.addRow(row);
            }
        });

        /**
         * Funkcje przycisku usuwania danych
         */
        bDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });

        /**
         * Dodanie słuchacza myszy
         */
        table.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e){

                // i = the index of the selected row
                int i = table.getSelectedRow();

                textExercises.setText(model.getValueAt(i, 0).toString());
                textRepeat.setText(model.getValueAt(i, 1).toString());
                Integer.valueOf(String.valueOf(textRepeat));
                //spinRepeat.setValue(model.getValueAt(i,1));
                //textData.setText(model.getValueAt(i, 2).toString());

            }
        });

        /**
         * Funkcje przycisku aktualizacji danych
         */
        bUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();

                if(i >= 0)
                {
                    model.setValueAt(textExercises.getText(), i, 0);
                    model.setValueAt(Integer.parseInt(textRepeat.getText()), i, 1);
                    //spinRepeat.setValue(model.getValueAt(i,1));
                    model.setValueAt(textData.getText(), i, 2);

                }
                else{
                    System.out.println("Update Error");
                }
            }
        });

        /**
         * Dodanie do JFrame wszystkich komponentów
         */
        frame.setLayout(null);
        frame.add(pane);

        frame.add(textExercises);
        frame.add(textRepeat);
        //frame.add(spinRepeat);
        frame.add(textData);
        frame.add(labelSavePath1);
        frame.add(labelSavePath2);

        frame.add(bAdd);
        frame.add(bDelete);
        frame.add(bUpdate);

        frame.setVisible(true);
        frame.setResizable(true);
        frame.getContentPane().add("Center", scroll);
        frame.getContentPane().add("South", bSave);
        frame.pack();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(895,600);
        frame.setLocationRelativeTo(null);
    }
}



