package pl.sda;

import pl.sda.csv.CsvWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IOException {
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car();
        car1.setBrand("Lamborghini");
        car1.setModel("Terzo Millenio");
        car1.setEngineVolume("6000");
        car1.setColor("yellow");

        Car car2 = new Car();
        car2.setBrand("Ferrari");
        car2.setModel("488 GTB");
        car2.setEngineVolume("6000");
        car2.setColor("red");

        cars.add(car1);
        cars.add(car2);

        CsvWriter csvWriter = new CsvWriter();
        csvWriter.write(cars, "C://auto.csv");
    }
}
