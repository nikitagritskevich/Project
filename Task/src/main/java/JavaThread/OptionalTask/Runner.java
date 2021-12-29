package JavaThread.OptionalTask;

import java.util.concurrent.TimeUnit;

public class Runner {

  public static void main(String[] args) {
    Airport airport = new Airport();
    for (int i = 0; i < 10; i++) {
      try {
        new Thread(new Plane(airport, i + 1)).start();
        TimeUnit.MILLISECONDS.sleep(100);
      }catch (InterruptedException e){
        e.printStackTrace();
      }

    }
  }

}
