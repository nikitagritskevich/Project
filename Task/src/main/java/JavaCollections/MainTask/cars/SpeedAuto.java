package JavaCollections.MainTask.cars;

import JavaCollections.MainTask.classification.Classification;
import JavaCollections.MainTask.classification.Model;

public class SpeedAuto extends Car {
    private final int capacityOfPeopleInTheCar;

    public SpeedAuto(int priceAuto, Classification classification, Model model, int fuelConsumer, int capacityOfPeopleInTheCar) {
        super(priceAuto, calculateAverageSpeed(fuelConsumer, capacityOfPeopleInTheCar), classification, model, fuelConsumer);
        this.capacityOfPeopleInTheCar = capacityOfPeopleInTheCar;
    }

    private static int calculateAverageSpeed(int fuelConsumer, int capacityOfPeopleInTheCar) {
        return (fuelConsumer * 150) / capacityOfPeopleInTheCar;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                " capacityOfPeopleInTheCar=" + capacityOfPeopleInTheCar +
                        '}' + "\n");
    }
}
