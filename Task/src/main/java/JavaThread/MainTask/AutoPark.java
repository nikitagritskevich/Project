package JavaThread.MainTask;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;


public class AutoPark {

  private final CopyOnWriteArrayList<Car> listCarInPark = new CopyOnWriteArrayList<>();
  private final Semaphore semaphore;

  public AutoPark(int maxSizeQueue) {
    semaphore = new Semaphore(maxSizeQueue);
  }

  public Semaphore getSemaphore() {
    return semaphore;
  }

  public CopyOnWriteArrayList<Car> getCarList() {
    return listCarInPark;
  }


}
