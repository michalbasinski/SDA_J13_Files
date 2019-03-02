package pl.sda.json;

import java.io.IOException;

public class JsonWriterException extends RuntimeException {

    public JsonWriterException(String message, IOException e) {
        super(message, e);
    }

}
