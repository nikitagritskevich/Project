package JavaThread.OptionalTask;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Plane extends Thread {

  private Airport airport;
  private int planeNumber;

  public Plane(Airport airport, int planeNumber) {
    this.airport = airport;
    this.planeNumber = planeNumber;
  }

  @Override
  public void run() {
    Semaphore semaphore = airport.getSemaphore();
    try {
      semaphore.acquire();
      System.out.println(
          String.format("The plane number -> %d began to enter the runway ", planeNumber));
      TimeUnit.SECONDS.sleep(3);
      System.out.println(
          String.format("The plane number -> %d picked up speed ", planeNumber));
      TimeUnit.SECONDS.sleep(3);
      System.out.println(
          String.format("The plane number -> %d took off", planeNumber));
      TimeUnit.SECONDS.sleep(3);
      System.out.println("The runway  is free");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      semaphore.release();
    }
  }
}
