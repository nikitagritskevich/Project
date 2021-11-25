package JavaCollections.MainTask;

import JavaCollections.MainTask.cars.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaxiPark {
    private final List<? extends Car> park;

    public TaxiPark(List<? extends Car> park) {
        this.park = park;
    }

    public double costOfTheTaxiPark() {
        return park.stream().mapToDouble(park -> park.getPrice()).sum();
    }

    public TaxiPark sortByFuelConsumption() {
        park.sort(Comparator.comparingInt(Car::getFuelConsumption));
        return this;
    }

    public List<? extends Car> searchForCarsWithTheRequiredSpeed(int firsPartOfRange, int lastPartRange) {
        return park.stream()
                .filter(car -> car.getAverageSpeed() >= firsPartOfRange)
                .filter(car -> car.getAverageSpeed() <= lastPartRange)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "TaxiPark{" +
                park +
                '}';
    }
}
