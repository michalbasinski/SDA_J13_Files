package pl.sda;

import pl.sda.csv.CsvReader;
import pl.sda.csv.CsvWriter;
import pl.sda.excel.ExcelReader;
import pl.sda.excel.ExcelWriter;
import pl.sda.json.JsonReader;
import pl.sda.json.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IOException {

        ExcelReader reader = new ExcelReader();
        List<Car> read = reader.read("/home/michal/cars.xlsx");

        ExcelWriter writer = new ExcelWriter();
        writer.write(read, "/home/michal/myExcel.xlsx");

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

        JsonReader jsonReader = new JsonReader();
        List<Car> carsFromJson = jsonReader.read("/home/michal/SDA/Java13/Projekty/SDA_J13_Files/src/main/resources/cars.json");
        for (Car car : carsFromJson) {
            System.out.println(car.getBrand() + car.getModel() + car.getEngineVolume() + car.getColor());
        }

        JsonWriter jsonWriter = new JsonWriter();
        jsonWriter.write(cars, "/home/michal/test.json");
    }
}
