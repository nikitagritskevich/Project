package JavaClasses;

import java.util.ArrayList;
import java.util.List;


public class AutoPark {

    private final List<Car> park = new ArrayList<>();


    public List<Car> getCar() {
        return park;
    }

    public void addCar(Car car) {
        this.park.add(car);
    }

    @Override
    public String toString() {
        return "AutoPark : " +
                park;
    }


    public void findCar(Brand model, int number) {

        park.stream()
                .filter(car -> car.getBrandAuto() == model)
                .filter(car -> car.getYearOfRelease() > number)
                .forEach(System.out::println);

    }

    public void findYearOfRelease(int yearOfRelease, double price) {
        park.stream()
                .filter(car -> car.getYearOfRelease() == yearOfRelease)
                .filter(car -> car.getPrice() > price)
                .forEach(System.out::println);

    }


    public void createPark() {

        addCar(new Car(285344, Brand.AUDI, 345, 2002, "Silver", 20_345, 456));
        addCar(new Car(27765, Brand.BMW, 123, 1993, "Black", 1000, 343));
        addCar(new Car(33479, Brand.BMW, 144, 2012, "Black", 34_345, 122));
        addCar(new Car(12990, Brand.FORD, 3, 1978, "Red", 500, 111));
        addCar(new Car(449876, Brand.AUDI, 333, 2003, "Blue", 20_000, 190));
        addCar(new Car(678344, Brand.BUGATTI, 999, 2002, "Magenta", 45_000, 90));
        addCar(new Car(32147, Brand.BMW, 202, 1999, "White", 15_333, 111));
        addCar(new Car(24544, Brand.BUGATTI, 12, 2021, "White", 20_345, 567));
        addCar(new Car(20912, Brand.AUDI, 567, 1888, "Green", 1_000, 12));

    }

}
