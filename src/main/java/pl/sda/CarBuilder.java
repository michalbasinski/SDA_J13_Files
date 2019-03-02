package pl.sda;

/**
 * Implementacja wzorca projektowego Builder, pozwalającego na bardziej uporządkowane
 * tworzenie nowych obiektów. Charakterystyczną cechą tego wzorca jest zastosowanie metod
 * withABC() zwracających obiekt buildera (this). Wykorzystanie takiego mechanizmu (nazywanego
 * także "fluent api") pozwala na używanie ciągów wywołań pokroju
 * builder.withName("Jan").withLastName("Kowalski").
 * Poniższa implementacja została wykorzystana w klasach CsvReader i JsonReader w celu tworzenia
 * nowych obiektów typu Car.
 */
public class CarBuilder {

    private Car carToBuild;

    public CarBuilder() {
        carToBuild = new Car();
    }

    public CarBuilder withBrand(String brand) {
        carToBuild.setBrand(brand);
        return this;
    }

    public CarBuilder withModel(String model) {
        carToBuild.setModel(model);
        return this;
    }

    public CarBuilder withEngineVolume(String engineVolume) {
        carToBuild.setEngineVolume(engineVolume);
        return this;
    }

    public CarBuilder withColor(String color) {
        carToBuild.setColor(color);
        return this;
    }

    public Car build() {
        return carToBuild;
    }
}
