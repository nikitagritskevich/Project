package JavaClasses;

/*8. Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.

Создать массив объектов. Вывести:

a) список автомобилей заданной марки;

b) список автомобилей заданной модели, которые эксплуатируются больше n лет;

c) список автомобилей заданного года выпуска, цена которых больше указанной.*/


import java.util.Locale;
import java.util.Scanner;

class ClassAutoPark {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        AutoPark autoPark = new AutoPark();

        autoPark.createPark();

        autoPark.getCar().stream().forEach(System.out::println);
        System.out.println();

        System.out.println("Enter required model Auto :");
        String model = in.next();
        System.out.println("Enter required year  : ");
        int n = in.nextInt();


        BrandAuto brandAuto = BrandAuto.valueOf(model.toUpperCase(Locale.ROOT).trim());
        autoPark.findCar(brandAuto, n);

        System.out.println("Enter required  year of Release : ");
        int yearOfRelease = in.nextInt();
        System.out.println("Enter required price ");
        double price = in.nextDouble();

        autoPark.findYearOfRelease(yearOfRelease, price);


    }
}
