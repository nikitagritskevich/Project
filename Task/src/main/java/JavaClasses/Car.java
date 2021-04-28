package JavaClasses;


/*8. : id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.

Создать массив объектов. Вывести:

a) список автомобилей заданной марки;

b) список автомобилей заданной модели, которые эксплуатируются больше n лет;

c) список автомобилей заданного года выпуска, цена которых больше указанной.*/


public class Car {

    private int id;
    private BrandAuto brandAuto;
    private int modelAuto;
    private int yearOfRelease;
    private String color;
    private double price;
    private int regNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getModelAuto() {
        return modelAuto;
    }

    public void setModelAuto(int modelAuto) {
        this.modelAuto = modelAuto;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
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

    public void setBrandAuto(BrandAuto brandAuto) {
        this.brandAuto = brandAuto;
    }
}
