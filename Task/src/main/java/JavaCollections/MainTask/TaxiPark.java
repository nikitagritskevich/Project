package JavaCollections.MainTask;

import JavaCollections.MainTask.Cars.Car;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaxiPark {
    private List<? extends Car> park;

    public int costOfTheTaxiPark() {
        int costOfPriceTaxiPark = 0;
        for (Car car : park) {
            costOfPriceTaxiPark += car.getPriceAuto();
        }
        return costOfPriceTaxiPark;
    }

    public TaxiPark sortByFuelConsumption() {
        Collections.sort(park, new Comparator<Car>() {
                    public int compare(Car o1, Car o2) {
                        return o1.getFuelConsumer() - o2.getFuelConsumer();

                    }
                }
        );
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
