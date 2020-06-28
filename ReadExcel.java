package owca.czarna;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sun.deploy.security.SelectableSecurityManager;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    private String filename;
    private List<Float> repData = new ArrayList<>();
    private List<String> exData = new ArrayList<>();
    /**
     * Konstruktor z jednym parametrem - nazwą pliku excel
     * @param filename
     */
    public ReadExcel(String filename){
        this.filename=filename;
    }

    /**
     * Odczytuje dane z pliku excel
     */
    public void readData(){
        try (FileInputStream file = new FileInputStream(new File(filename)))
        {
            Workbook workbook;
            if(filename.endsWith("s")) {
                workbook = new HSSFWorkbook(file);
//                sheet = workbook.getSheetAt(0);

            }
            else {
                workbook = new XSSFWorkbook(file);
            }
            //wez pierwszy arkusz z pliku
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            int i = 0;
            int j = -1;
            //Petla po danych
            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                j++;
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()){
                    i++;
                    Cell cell = cellIterator.next();

                    //wypisywanie dla testu
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            repData.add((float) cell.getNumericCellValue());
                            System.out.println("float" + cell.getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            if (i == 2 + 3 * j && j > 1) {
                                repData.add(Float.parseFloat(cell.getStringCellValue()));
                            }
                          else {
                            exData.add(cell.getStringCellValue());
                            System.out.println("string" + cell.getStringCellValue());
                          }
                            break;
                    }
                }
            }

        } catch (FileNotFoundException e){
            System.out.println("Nie odnaleziono pliku");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Zwraca listę z ilością powtórzeń
     * @return <code>List<Float></code>
     */
    public List<Float> getRepData() {
        return repData;
    }

    /**
     * Zwraca listę z nazwą ćwicznia i datą
     * @return <code>List<String></code>
     */
    public List<String> getExData() {
        return exData;
    }
}
