package JavaCollections.MainTask.Cars;

import JavaCollections.MainTask.Classification.ClassificationOfPassengerCars;
import JavaCollections.MainTask.Classification.ModelAuto;

public class PassengerAuto extends Car{
    private final int capacityOfPeopleInTheCar;

    public PassengerAuto(int priceAuto, int averageSpeedAuto, ClassificationOfPassengerCars classificationOfPassengerCars, ModelAuto modelAuto, int fuelConsumer, int capacityOfPeopleInTheCar) {
        super(priceAuto, averageSpeedAuto, classificationOfPassengerCars, modelAuto, fuelConsumer);
        this.capacityOfPeopleInTheCar = capacityOfPeopleInTheCar;
    }

    public int getCapacityOfPeopleInTheCar() {
        return capacityOfPeopleInTheCar;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                " capacityOfPeopleInTheCar=" + capacityOfPeopleInTheCar +
                '}'+ "\n");
    }
}
