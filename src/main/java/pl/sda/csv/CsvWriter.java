package pl.sda.csv;

import pl.sda.Car;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

    public void write(List<Car> cars, String filePath) throws IOException {

        //utworzenie obiektów fileWriter i bufferedWriter
        //fileWriter - otwiera strumień do pliku
        //bufferedWriter - wpisuje tekst do pliku
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("brand;model;engineVolume;color\n");
        for (Car car : cars) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(car.getBrand())
                    .append(";")
                    .append(car.getModel())
                    .append(";")
                    .append(car.getEngineVolume())
                    .append(";")
                    .append(car.getColor())
                    .append("\n");

            String lineToWrite = stringBuilder.toString();
            bufferedWriter.write(lineToWrite);
            bufferedWriter.flush();
        }

    }
}
