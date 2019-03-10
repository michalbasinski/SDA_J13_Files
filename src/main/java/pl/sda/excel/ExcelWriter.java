package pl.sda.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.sda.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ExcelWriter {

    public void write(List<Car> records, String filePath) {
        Workbook workbook = new XSSFWorkbook();

        Sheet cars = workbook.createSheet("cars");

        // tworzenie wiersza nagłówkowego - start
        Row headerRow = cars.createRow(0);
        List<String> headers = Arrays.asList("brand", "model", "engineVolume", "color");

        int cellCount = 0;
        for (String header : headers) {
            Cell cell = headerRow.createCell(cellCount);
            cell.setCellValue(header);
            cellCount++;
        }
        // tworzenie wiersza nagłówkowego - koniec

        // uzupełnianie wierszy z danymi - start
        int rowCount = 1;
        for (Car car : records) {
            Row newRow = cars.createRow(rowCount);

            Cell cell = newRow.createCell(0);
            cell.setCellValue(car.getBrand());

            cell = newRow.createCell(1);
            cell.setCellValue(car.getModel());

            cell = newRow.createCell(2);
            cell.setCellValue(car.getEngineVolume());

            cell = newRow.createCell(3);
            cell.setCellValue(car.getColor());

            rowCount++;

        }
        // uzupełnianie wierszy z danymi - koniec

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
