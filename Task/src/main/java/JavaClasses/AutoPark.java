package JavaClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AutoPark {

    private List<Car> park = new ArrayList<Car>();


    public List<Car> getCar() {
        return park;
    }

    public void addCar(Car car) {
        this.park.add(car);
    }

    @Override
    public String toString() {
        return "AutoPark : " +
                park +  +
                '}';
    }


    public void findCar(BrandAuto model, int number) {

        park.stream().
                filter(car -> car.getBrandAuto() == model && car.getYearOfRelease() > number).
                forEach(System.out::println);

    }

    public void findYearOfRelease(int yearOfRelease, double price) {
        List<Car> carArrayList = park.stream().filter(car -> car.getYearOfRelease() == yearOfRelease && car.getPrice() > price)
                .collect(Collectors.toList());
        carArrayList.forEach(System.out::println);
        System.out.println();
    }


    public void createPark() {

        addCar(new Car(285344, BrandAuto.AUDI, 345, 2002, "Silver", 20_345, 456));
        addCar(new Car(27765, BrandAuto.BMW, 123, 1993, "Black", 1000, 343));
        addCar(new Car(33479, BrandAuto.BMW, 144, 2012, "Black", 34_345, 122));
        addCar(new Car(12990, BrandAuto.FORD, 3, 1978, "Red", 500, 111));
        addCar(new Car(449876, BrandAuto.AUDI, 333, 2003, "Blue", 20_000, 190));
        addCar(new Car(678344, BrandAuto.BUGATTI, 999, 2002, "Magenta", 45_000, 90));
        addCar(new Car(32147, BrandAuto.BMW, 202, 1999, "White", 15_333, 111));
        addCar(new Car(24544, BrandAuto.BUGATTI, 12, 2021, "White", 20_345, 567));
        addCar(new Car(20912, BrandAuto.AUDI, 567, 1888, "Green", 1_000, 12));

    }

}
