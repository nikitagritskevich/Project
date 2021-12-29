package JavaThread.MainTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Runner {

  public static void main(String[] args) {
    List<AutoPark> autoParks = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      autoParks.add(new AutoPark(2));
    }

    for (int i = 0; i < 15; i++) {
      new Car(i, autoParks).start();
      try {
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

}
