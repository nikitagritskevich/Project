package JavaCollections.MainTask.cars;

import JavaCollections.MainTask.classification.Classification;
import JavaCollections.MainTask.classification.Model;

public class PassengerAuto extends Car {
    private final int capacityOfPeopleInTheCar;

    public PassengerAuto(int priceAuto, int averageSpeedAuto, Classification classification, Model model, int fuelConsumer, int capacityOfPeopleInTheCar) {
        super(priceAuto, averageSpeedAuto, classification, model, fuelConsumer);
        this.capacityOfPeopleInTheCar = capacityOfPeopleInTheCar;
    }

    public int getCapacityOfPeopleInTheCar() {
        return capacityOfPeopleInTheCar;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                " capacityOfPeopleInTheCar=" + capacityOfPeopleInTheCar +
                        '}' + "\n");
    }
}
