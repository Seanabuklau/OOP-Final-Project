package g2t1.DigitalRemittance.processor;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelProcessor {
    
    public static ArrayList<String> uploadAndGetHeaders(String fileLocation, int headerRow){
        ArrayList<String> headers = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(fileLocation);
            Workbook workbook = new XSSFWorkbook(file);
    
            Sheet sheet = workbook.getSheetAt(0);

            int i = 1;
            for (Row row : sheet) {
                if (i == headerRow) {
                    for (Cell cell : row) {
                        headers.add(cell.getRichStringCellValue().getString());
                    }
                    break;
                }
                i++;
            }

            file.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return headers;

    }
}
