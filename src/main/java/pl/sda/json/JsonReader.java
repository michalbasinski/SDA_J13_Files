package pl.sda.json;

import pl.sda.Car;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    public List<Car> read(String filePath) {
        List<Car> cars = new ArrayList<>();

        // wczytanie zawartości pliku do tablicy bajtów z wykorzystaniem metody z klasy
        // Files
        byte[] rawFile = new byte[0];
        try {
            rawFile = Files.readAllBytes(Paths.get(filePath));

            // skonwertowanie tablicy bajtów na stringa - wymagane jest podanie kodowania
            // (standardowe i najbezpieczniejsze jest UTF-8)
            String fileContents = new String(rawFile, "UTF-8");

        } catch (IOException e) {
            throw new JsonReaderException(e.getMessage(), e);
        }


        return cars;
    }
}
