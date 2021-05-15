package JavaCollections.MainTask;

//10. Таксопарк. Определить иерархию легковых автомобилей. Создать таксопарк. Подсчитать стоимость автопарка.
//        Провести сортировку автомобилей парка по расходу топлива.
//        Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.


import JavaCollections.MainTask.Cars.Car;
import JavaCollections.MainTask.Cars.FreightСar;
import JavaCollections.MainTask.Cars.PassengerAuto;
import JavaCollections.MainTask.Cars.SpeedAuto;
import JavaCollections.MainTask.Classification.ClassificationOfPassengerCars;
import JavaCollections.MainTask.Classification.ModelAuto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Runner {
    static List<Car> park = Arrays.asList(
            new PassengerAuto(2000, 75, ClassificationOfPassengerCars.CLASSIFICATION_OF_PASSENGER_CARS_A, ModelAuto.BMW, 65, 4),
            new PassengerAuto(3215, 79, ClassificationOfPassengerCars.CLASSIFICATION_OF_PASSENGER_CARS_B, ModelAuto.AUDI, 54, 3),
            new PassengerAuto(1300, 15, ClassificationOfPassengerCars.CLASSIFICATION_OF_PASSENGER_CARS_B, ModelAuto.LADA, 75, 2),
            new PassengerAuto(7540, 95, ClassificationOfPassengerCars.CLASSIFICATION_OF_PASSENGER_CARS_C, ModelAuto.BMW, 45, 2),
            new FreightСar(25000, 35, ClassificationOfPassengerCars.CLASSIFICATION_OF_PASSENGER_CARS_D, ModelAuto.LADA, 120, 5, 300),
            new FreightСar(45000, 45, ClassificationOfPassengerCars.CLASSIFICATION_OF_PASSENGER_CARS_D, ModelAuto.LADA, 135, 4, 500),
            new FreightСar(90000, 20, ClassificationOfPassengerCars.CLASSIFICATION_OF_PASSENGER_CARS_D, ModelAuto.LADA, 150, 7, 1200),
            new SpeedAuto(120000, ClassificationOfPassengerCars.CLASSIFICATION_OF_PASSENGER_CARS_A, ModelAuto.BMW, 72, 5),
            new SpeedAuto(150301, ClassificationOfPassengerCars.CLASSIFICATION_OF_PASSENGER_CARS_B, ModelAuto.AUDI, 90, 2),
            new SpeedAuto(210999, ClassificationOfPassengerCars.CLASSIFICATION_OF_PASSENGER_CARS_B, ModelAuto.BMW, 130, 2),
            new SpeedAuto(75000, ClassificationOfPassengerCars.CLASSIFICATION_OF_PASSENGER_CARS_A, ModelAuto.AUDI, 58, 4),
            new SpeedAuto(135891, ClassificationOfPassengerCars.CLASSIFICATION_OF_PASSENGER_CARS_C, ModelAuto.BMW, 100, 4)


    );

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        TaxiPark taxiPark = new TaxiPark(park);
        System.out.println("The cost of the entire fleet : " + taxiPark.costOfTheTaxiPark() + " $");
        System.out.println("Sort by fuel consumption  : " + taxiPark.sortByFuelConsumption());
        System.out.println("Enter the required speed intervals = ");
        int firstInterval = in.nextInt();
        int lastInterval = in.nextInt();
        System.out.println("Search for Cars with the required speed : " + taxiPark.SearchForCarsWithTheRequiredSpeed(firstInterval,lastInterval));
    }
}
