package JavaThread.OptionalTask;

import java.util.concurrent.Semaphore;

public class Airport {
  private final Semaphore semaphore = new Semaphore(5,true);
  public Semaphore getSemaphore() {
    return semaphore;
  }
}
