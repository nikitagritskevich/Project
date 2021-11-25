package JavaCollections.MainTask.cars;

import JavaCollections.MainTask.classification.Classification;
import JavaCollections.MainTask.classification.Model;

public class FreightСar extends Car {
    private final int capacityOfPeopleInTheCar;
    private final int loadCapacity; // in tons

    public FreightСar(int priceAuto, int averageSpeedAuto, Classification classification, Model model, int fuelConsumer, int capacityOfPeopleInTheCar, int loadCapacity) {
        super(priceAuto, averageSpeedAuto, classification, model, fuelConsumer);
        this.capacityOfPeopleInTheCar = capacityOfPeopleInTheCar;
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", capacityOfPeopleInTheCar=" + capacityOfPeopleInTheCar +
                        ", loadCapacity=" + loadCapacity + '}' + "\n");
    }
}
