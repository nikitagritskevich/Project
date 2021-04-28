package JavaClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AutoPark {

    private List<Car> carList = new ArrayList<Car>();


    public List<Car> getCar() {
        return carList;
    }

    public void addCar(List<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Car car) {
        this.carList.add(car);
    }

    @Override
    public String toString() {
        return "AutoPark : " +
                carList + "\n" +
                '}';
    }


    public void findCar(BrandAuto model, int n) {

        carList.stream().
                filter(car -> car.getBrandAuto() == model && car.getYearOfRelease() > n).
                forEach(System.out::println);

    }

    public void findYearOfRelease(int yearOfRelease, double price) {
        List<Car> carArrayList = carList.stream().filter(car -> car.getYearOfRelease() == yearOfRelease && car.getPrice() > price).collect(Collectors.toList());
        carArrayList.forEach(System.out::println);
        System.out.println();
    }

    public void createPark() {
        Car Audi_345 = new Car(285344, BrandAuto.AUDI, 345, 2002, "Silver", 20_345, 456);
        Car BMW_123 = new Car(27765, BrandAuto.BMW, 123, 1993, "Black", 1000, 343);
        Car BMW_144 = new Car(33479, BrandAuto.BMW, 144, 2012, "Black", 34_345, 122);
        Car Ford_3 = new Car(12990, BrandAuto.FORD, 3, 1978, "Red", 500, 111);
        Car Audi_333 = new Car(449876, BrandAuto.AUDI, 333, 2003, "Blue", 20_000, 190);
        Car Bugatti_999 = new Car(678344, BrandAuto.BUGATTI, 999, 2002, "Magenta", 45_000, 90);
        Car BMW_202 = new Car(32147, BrandAuto.BMW, 202, 1999, "White", 15_333, 111);
        Car Bugatti_12 = new Car(24544, BrandAuto.BUGATTI, 12, 2021, "White", 20_345, 567);
        Car Audi_567 = new Car(20912, BrandAuto.AUDI, 567, 1888, "Green", 1_000, 12);

        this.addCar(Audi_345);

        this.addCar(BMW_123);

        this.addCar(BMW_144);

        this.addCar(Ford_3);

        this.addCar(Audi_333);

        this.addCar(Bugatti_999);

        this.addCar(BMW_202);

        this.addCar(Bugatti_12);

        this.addCar(Audi_567);
    }
}
