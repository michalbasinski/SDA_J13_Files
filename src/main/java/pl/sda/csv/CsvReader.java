package pl.sda.csv;

import pl.sda.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public List<Car> read(String file) {
        List<Car> cars = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            boolean firstRow = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (firstRow) {
                    firstRow = false;
                } else {
                    String[] cells = line.split(";");
                    Car createdCar = new Car();
                    createdCar.setBrand(cells[0]);
                    createdCar.setModel(cells[1]);
                    createdCar.setEngineVolume(cells[2]);
                    createdCar.setColor(cells[3]);
                    cars.add(createdCar);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cars;
    }

}
