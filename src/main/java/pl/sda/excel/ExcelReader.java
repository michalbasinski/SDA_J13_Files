package pl.sda.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.sda.Car;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public List<Car> read(String filePath) {
        List<Car> result = new ArrayList<>();

        try {

            FileInputStream fileInputStream =
                    new FileInputStream(new File(filePath));

            Workbook workbook = new XSSFWorkbook(fileInputStream);

            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.rowIterator();

            //zbudowanie listy kolumn
            List<String> headers = new ArrayList<>();
            Row headerRow = rowIterator.next();
            Iterator<Cell> headerRowIterator = headerRow.cellIterator();
            while (headerRowIterator.hasNext()) {
                Cell header = headerRowIterator.next();
                headers.add(header.getStringCellValue());
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Car car = new Car();
                int counter = 0;
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String currentColumn = headers.get(counter);
                    putCurrentValueToNewCar(car, cell.getStringCellValue(), currentColumn);
                    result.add(car);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private void putCurrentValueToNewCar(Car car, String stringCellValue, String currentColumn) {
        if ("brand".equals(currentColumn)) {
            car.setBrand(stringCellValue);
        }
        if ("model".equals(currentColumn)) {
            car.setModel(stringCellValue);
        }
        if ("engineVolume".equals(currentColumn)) {
            car.setEngineVolume(stringCellValue);
        }
        if ("color".equals(currentColumn)) {
            car.setColor(stringCellValue);
        }
    }

}
