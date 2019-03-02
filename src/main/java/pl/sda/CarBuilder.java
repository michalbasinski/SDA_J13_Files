package pl.sda;

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
