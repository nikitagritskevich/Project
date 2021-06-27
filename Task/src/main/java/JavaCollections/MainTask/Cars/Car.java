package JavaCollections.MainTask.Cars;

import JavaCollections.MainTask.Classification.ClassificationOfPassengerCars;
import JavaCollections.MainTask.Classification.ModelAuto;

abstract public class Car {

    private final int priceAuto; //price in dollars
    private final int averageSpeedAuto;//average speed in kilometers per hour
    private final ClassificationOfPassengerCars classificationOfPassengerCars;
    private final ModelAuto modelAuto;
    private final int fuelConsumer;

    public int getPriceAuto() {
        return priceAuto;
    }

    public int getAverageSpeedAuto() {
        return averageSpeedAuto;
    }

    public int getFuelConsumer() {
        return fuelConsumer;
    }

    public Car(int priceAuto, int averageSpeedAuto, ClassificationOfPassengerCars classificationOfPassengerCars, ModelAuto modelAuto, int fuelConsumer) {
        this.priceAuto = priceAuto;
        this.averageSpeedAuto = averageSpeedAuto;
        this.classificationOfPassengerCars = classificationOfPassengerCars;
        this.modelAuto = modelAuto;
        this.fuelConsumer = fuelConsumer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "priceAuto=" + priceAuto +
                ", averageSpeedAuto=" + averageSpeedAuto +
                ", classificationOfPassengerCars=" + classificationOfPassengerCars +
                ", modelAuto=" + modelAuto +
                ", fuelConsumer=" + fuelConsumer +
                '}';
    }
}
