package JavaClasses;

/*8. Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.

Создать массив объектов. Вывести:

a) список автомобилей заданной марки;

b) список автомобилей заданной модели, которые эксплуатируются больше n лет;

c) список автомобилей заданного года выпуска, цена которых больше указанной.*/


import java.util.Locale;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter required model Auto :");
        String model = in.next();
        System.out.println("Enter required year  : ");
        int n = in.nextInt();
        System.out.println("Enter required  year of Release : ");
        int yearOfRelease = in.nextInt();
        System.out.println("Enter required price ");
        double price = in.nextDouble();
        Car Audi_345 = new Car(285344, BrandAuto.AUDI, 345, 2002, "Silver", 20_345, 456);
        Car BMW_123 = new Car(27765, BrandAuto.BMW, 123, 1993, "Black", 1000, 343);
        Car BMW_144 = new Car(33479, BrandAuto.BMW, 144, 2012, "Black", 34_345, 122);
        Car Ford_3 = new Car(12990, BrandAuto.FORD, 3, 1978, "Red", 500, 111);
        Car Audi_333 = new Car(449876, BrandAuto.AUDI, 333, 2003, "Blue", 20_000, 190);
        Car Bugatti_999 = new Car(678344, BrandAuto.BUGATTI, 999, 2002, "Magenta", 45_000, 90);
        Car BMW_202 = new Car(32147, BrandAuto.BMW, 202, 1999, "White", 15_333, 111);
        Car Bugatti_12 = new Car(24544, BrandAuto.BUGATTI, 12, 2021, "White", 20_345, 567);
        Car Audi_567 = new Car(20912, BrandAuto.AUDI, 567, 1888, "Green", 1_000, 12);

        AutoPark autoPark = new AutoPark();

        autoPark.setCarList(Audi_345);

        autoPark.setCarList(BMW_123);

        autoPark.setCarList(BMW_144);

        autoPark.setCarList(Ford_3);

        autoPark.setCarList(Audi_333);

        autoPark.setCarList(Bugatti_999);

        autoPark.setCarList(BMW_202);

        autoPark.setCarList(Bugatti_12);

        autoPark.setCarList(Audi_567);

        autoPark.outputPark();

        autoPark.findCar(model.toUpperCase(Locale.ROOT).trim(), n);

        autoPark.findYearOfRelease(yearOfRelease, price);


    }
}
