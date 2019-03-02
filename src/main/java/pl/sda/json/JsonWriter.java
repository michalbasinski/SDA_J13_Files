package pl.sda.json;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.sda.Car;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter {

    public void write(List<Car> carList, String filePath) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {

            JSONObject jsonObject = new JSONObject();

            JSONArray jsonArray = new JSONArray();

            for (Car car : carList) {
                JSONObject carJson = new JSONObject();
                carJson.put("brand", car.getBrand());
                carJson.put("model", car.getModel());
                carJson.put("engineVolume", Integer.parseInt(car.getEngineVolume()));
                carJson.put("color", car.getColor());
                jsonArray.put(carJson);
            }

            jsonObject.put("cars", jsonArray);

            bufferedWriter.write(jsonObject.toString());
            bufferedWriter.flush();


        } catch (IOException e) {
            throw new JsonWriterException(e.getMessage(), e);
        }

    }
}
