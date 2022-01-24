package JavaCollections.MainTask;

//10. Таксопарк. Определить иерархию легковых автомобилей. Создать таксопарк. Подсчитать стоимость автопарка.
//        Провести сортировку автомобилей парка по расходу топлива.
//        Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.


import JavaCollections.MainTask.cars.Car;
import JavaCollections.MainTask.cars.FreightCar;
import JavaCollections.MainTask.cars.PassengerAuto;
import JavaCollections.MainTask.cars.SpeedAuto;
import JavaCollections.MainTask.classification.Classification;
import JavaCollections.MainTask.classification.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Runner {
    static List<Car> park = Arrays.asList(
            new PassengerAuto(2000, 75, Classification.A, Model.BMW, 65, 4),
            new PassengerAuto(3215, 79, Classification.B, Model.AUDI, 54, 3),
            new PassengerAuto(1300, 15, Classification.B, Model.LADA, 75, 2),
            new PassengerAuto(7540, 95, Classification.C, Model.BMW, 45, 2),
            new FreightCar(25000, 35, Classification.D, Model.LADA, 120, 5, 300),
            new FreightCar(45000, 45, Classification.D, Model.LADA, 135, 4, 500),
            new FreightCar(90000, 20, Classification.D, Model.LADA, 150, 7, 1200),
            new SpeedAuto(120000, Classification.A, Model.BMW, 72, 5),
            new SpeedAuto(150301, Classification.B, Model.AUDI, 90, 2),
            new SpeedAuto(210999, Classification.B, Model.BMW, 130, 2),
            new SpeedAuto(75000, Classification.A, Model.AUDI, 58, 4),
            new SpeedAuto(135891, Classification.C, Model.BMW, 100, 4)


    );

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            TaxiPark taxiPark = new TaxiPark(park);
            System.out.println("The cost of the entire fleet : " + taxiPark.costOfTheTaxiPark() + " $");
            System.out.println("Sort by fuel consumption  : \n" + taxiPark.sortByFuelConsumption());
            System.out.println("Enter the required speed intervals = ");
            int firstInterval = in.nextInt();
            int lastInterval = in.nextInt();
            System.out.println("Search for Cars with the required speed : \n" + taxiPark.searchForCarsWithTheRequiredSpeed(firstInterval, lastInterval));
        }

    }
}
