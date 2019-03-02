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
     * Metoda wczytująca plik JSON do reprezentacji javowej (lista obiektów Car). W razie błędu
     * zostanie wyrzucony wyjątek JsonReaderException
     * Schemat działania:
     * 1. wczytanie zawartości pliku do tablicy bajtów z wykorzystaniem metody z klasy Files
     * 2. skonwertowanie tablicy bajtów na stringa - wymagane jest podanie kodowania (standardowe i najbezpieczniejsze jest UTF-8)
     * 3. utworzenie obiektu typu JsonObject na bazie wczytanego stringa
     * 4. wyciągnięcie z "dużego obiektu" tablicy znajdującej się pod kluczem "cars"
     * 5. przetworzenie tablicy (carsArray) w pętli i zbudowanie obiektów
     * 6. uzupełnienie listy cars o obiekty typu Car
     * 7. zwrócenie wyniku
     * @param filePath ścieżka do pliku
     * @return lista obiektów klasy Car zbudowanych na bazie pliku json
     */
    public List<Car> read(String filePath) {
        List<Car> cars = new ArrayList<>();

        try {
            byte[] rawFile = Files.readAllBytes(Paths.get(filePath));
            String fileContents = new String(rawFile, "UTF-8");

            JSONObject json = new JSONObject(fileContents);

            JSONArray carsArray = json.getJSONArray("cars");

            for (Object carObject : carsArray) {
                // istotne jest dodanie toString - inaczej nie zadziała new JSONObject()
                JSONObject carJson = new JSONObject(carObject.toString());

                // pobieranie wartości z jsona reprezentujacego pojedyńczy samochód
                String brand = carJson.getString("brand");
                String model = carJson.getString("model");
                String engineVolume = String.valueOf(carJson.getInt("engineVolume"));
                String color = carJson.getString("color");

                Car car = new Car();
                car.setBrand(brand);
                car.setModel(model);
                car.setEngineVolume(engineVolume);
                car.setColor(color);

                cars.add(car);
            }



        } catch (IOException e) {
            throw new JsonReaderException(e.getMessage(), e);
        }


        return cars;
    }
}
