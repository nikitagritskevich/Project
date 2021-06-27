package JavaCollections.MainTask.Cars;

import JavaCollections.MainTask.Classification.ClassificationOfPassengerCars;
import JavaCollections.MainTask.Classification.ModelAuto;

public class SpeedAuto extends Car {
    private final int capacityOfPeopleInTheCar;

    public SpeedAuto(int priceAuto, ClassificationOfPassengerCars classificationOfPassengerCars, ModelAuto modelAuto, int fuelConsumer, int capacityOfPeopleInTheCar) {
        super(priceAuto, calculateAverageSpeed(fuelConsumer, capacityOfPeopleInTheCar), classificationOfPassengerCars, modelAuto, fuelConsumer);
        this.capacityOfPeopleInTheCar = capacityOfPeopleInTheCar;
    }

    public static int calculateAverageSpeed(int fuelConsumer, int capacityOfPeopleInTheCar) {
        return (fuelConsumer * 150) / capacityOfPeopleInTheCar;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                " capacityOfPeopleInTheCar=" + capacityOfPeopleInTheCar +
                '}'+ "\n");
    }
}
