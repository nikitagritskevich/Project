package JavaCollections.MainTask.cars;

import JavaCollections.MainTask.classification.Classification;
import JavaCollections.MainTask.classification.Model;

abstract public class Car {
    private final double price; //price in dollars
    private final int averageSpeed;//average speed in kilometers per hour
    private final Classification classification;
    private final Model model;
    private final int fuelConsumption;

    public double getPrice() {
        return price;
    }

    public int getAverageSpeed() {
        return averageSpeed;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public Car(int price, int averageSpeed, Classification classification, Model model, int fuelConsumption) {
        this.price = price;
        this.averageSpeed = averageSpeed;
        this.classification = classification;
        this.model = model;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", averageSpeed=" + averageSpeed +
                ", classification=" + classification +
                ", model=" + model +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }
}
