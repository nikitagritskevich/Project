package JavaClasses;


/*8. : id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.

Создать массив объектов. Вывести:

a) список автомобилей заданной марки;

b) список автомобилей заданной модели, которые эксплуатируются больше n лет;

c) список автомобилей заданного года выпуска, цена которых больше указанной.*/


public class Car {

    private final int id;
    private final BrandAuto brandAuto;
    private final int modelAuto;
    private final int yearOfRelease;
    private final String color;
    private final double price;
    private final int regNumber;



    public int getYearOfRelease() {
        return yearOfRelease;
    }


    public double getPrice() {
        return price;
    }


    public Car(int id, BrandAuto brandAuto, int modelAuto, int yearOfRelease, String color, double price, int regNumber) {
        this.id = id;
        this.brandAuto = brandAuto;
        this.modelAuto = modelAuto;
        this.yearOfRelease = yearOfRelease;
        this.color = color;
        this.price = price;
        this.regNumber = regNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brandAuto=" + brandAuto +
                ", modelAuto=" + modelAuto +
                ", yearOfRelease=" + yearOfRelease +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", regNumber=" + regNumber +
                '}';
    }

    public BrandAuto getBrandAuto() {
        return brandAuto;
    }
}
