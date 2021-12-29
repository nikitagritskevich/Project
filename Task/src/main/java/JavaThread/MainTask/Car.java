package JavaThread.MainTask;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {

  private final int numberCar;
  private final List<AutoPark> autoParks;

  public Car(int numberCar, List<AutoPark> autoParks) {
    this.numberCar = numberCar;
    this.autoParks = autoParks;
  }


  @Override
  public void run() {
    boolean isAllPlaceFree = false;
    for (int i = 0; i < autoParks.size(); i++) {
      Semaphore semaphore = autoParks.get(i).getSemaphore();
      try {
        if (semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)) {
          isAllPlaceFree = bookingAutoParkPlace(i);
          TimeUnit.MILLISECONDS.sleep(new Random().nextInt(4000));
          System.out.println("I'm go away");
          System.out.println(
              String.format("The car number-> %d left  Auto park number %d ", numberCar, i));
          autoParks.get(i).getCarList().remove(this);
          semaphore.release();
          break;
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    if (!isAllPlaceFree) {
      System.out.println("All auto park place is busy");
    }
  }

  private boolean bookingAutoParkPlace(int index) {
    System.out.println(
        String.format("The Car with index -> %d booking the place in park with -> %d index",
            numberCar, index));
    return autoParks.get(index).getCarList().add(this);

  }
}

