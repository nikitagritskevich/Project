package JavaClasses;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class AutoPark {

    private ArrayList<Car> carList = new ArrayList<Car>();

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public void setCarList(Car car) {
        this.carList.add(car);
    }

    @Override
    public String toString() {
        return "AutoPark : " +
                 carList +"\n"+
                '}';
    }
    public void outputPark(){
        carList.forEach(System.out::println);
        System.out.println();
    }

    public void findCar(String model, int n){
        switch (model){
            case "AUDI":
            {
                ArrayList<Car> typeBrandAuto = (ArrayList<Car>) carList.stream().
                        filter(car -> car.getBrandAuto() == BrandAuto.AUDI && car.getYearOfRelease() > n).
                        collect(Collectors.toList());
                typeBrandAuto.forEach(System.out::println);
                break;
            }
            case "BMW":
            {
                ArrayList<Car> typeBrandAuto = (ArrayList<Car>) carList.stream().
                        filter(car -> car.getBrandAuto() == BrandAuto.BMW && car.getYearOfRelease() > n).
                        collect(Collectors.toList());
                typeBrandAuto.forEach(System.out::println);
                break;
            }
            case "FORD":
            {
                ArrayList<Car> typeBrandAuto = (ArrayList<Car>) carList.stream().
                        filter(car -> car.getBrandAuto() == BrandAuto.FORD && car.getYearOfRelease() > n).
                        collect(Collectors.toList());
                typeBrandAuto.forEach(System.out::println);
                break;
            }
            case "BUGATTI":
            {
                ArrayList<Car> typeBrandAuto = (ArrayList<Car>) carList.stream().
                        filter(car -> car.getBrandAuto() == BrandAuto.BUGATTI).
                        collect(Collectors.toList());
                typeBrandAuto.forEach(System.out::println);
                break;
            }
            default:{
                System.out.println("There are no such models");
            }



        }

        System.out.println();
    }

    public void findYearOfRelease (int yearOfRelease , double price ){
        ArrayList<Car> carArrayList = (ArrayList<Car>) carList.stream().filter(car -> car.getYearOfRelease() == yearOfRelease  && car.getPrice() > price).collect(Collectors.toList());
        carArrayList.forEach(System.out::println);
        System.out.println();
    }

}
