package JavaCollections.MainTask;

import JavaCollections.MainTask.Cars.Car;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaxiPark {
    private List<? extends Car> park;

    public int costOfTheTaxiPark() {
        return park.stream().mapToInt(park-> park.getPriceAuto()).sum();
    }

    public TaxiPark sortByFuelConsumption() {
        park.sort((Comparator<Car>) (o1, o2) -> o1.getFuelConsumer() - o2.getFuelConsumer());
        return this;
    }

    public List<? extends Car> SearchForCarsWithTheRequiredSpeed(int firsPartOfRange, int lastPartRange) {
       return park.stream().filter(car -> car.getAverageSpeedAuto() >= firsPartOfRange && car.getAverageSpeedAuto() <= lastPartRange ).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "TaxiPark{" +
                park +
                '}';
    }

    public TaxiPark(List<? extends Car> park) {
        this.park = park;
    }


}
