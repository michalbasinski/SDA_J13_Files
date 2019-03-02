package pl.sda;

import pl.sda.csv.CsvReader;
import pl.sda.csv.CsvWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IOException {
//        List<Car> cars = new ArrayList<>();
//
//        Car car1 = new Car();
//        car1.setBrand("Lamborghini");
//        car1.setModel("Terzo Millenio");
//        car1.setEngineVolume("6000");
//        car1.setColor("yellow");
//
//        Car car2 = new Car();
//        car2.setBrand("Ferrari");
//        car2.setModel("488 GTB");
//        car2.setEngineVolume("6000");
//        car2.setColor("red");
//
//        cars.add(car1);
//        cars.add(car2);
//
//        CsvWriter csvWriter = new CsvWriter();
//        csvWriter.write(cars, "C://auto.csv");

        CsvReader csvReader = new CsvReader();
        List<Car> cars = csvReader.read("/home/michal/SDA/Java13/Projekty/SDA_J13_Files/src/main/resources/cars.csv");
        for (Car car : cars) {
            System.out.println(car.getBrand() + car.getModel() + car.getEngineVolume() + car.getColor());
        }
    }
}
