package pl.sda.json;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.sda.Car;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {

    /**
     * Metoda wczytująca plik JSON do reprezentacji javowej (lista obiektów Car)
     * Schemat działania:
     * 1. wczytanie zawartości pliku do tablicy bajtów z wykorzystaniem metody z klasy Files
     * 2. skonwertowanie tablicy bajtów na stringa - wymagane jest podanie kodowania (standardowe i najbezpieczniejsze jest UTF-8)
     * 3.
     * @param filePath ścieżka do pliku
     * @return
     */
    public List<Car> read(String filePath) {
        List<Car> cars = new ArrayList<>();

        try {
            byte[] rawFile = Files.readAllBytes(Paths.get(filePath));
            String fileContents = new String(rawFile, "UTF-8");

            JSONObject json = new JSONObject(fileContents);

            JSONArray carsArray = json.getJSONArray("cars");



        } catch (IOException e) {
            throw new JsonReaderException(e.getMessage(), e);
        }


        return cars;
    }
}
