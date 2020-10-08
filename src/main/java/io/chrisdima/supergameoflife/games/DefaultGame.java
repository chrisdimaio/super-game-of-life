package io.chrisdima.supergameoflife.games;

import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.utils.Utils;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DefaultGame extends BaseGame {

  @Override
  public void init(){
    for(int i = 0; i < datastore.getDimensions().getVolume(); i++)
      datastore.set(distributionStrategy.createSpot(datastore.getDimensions()),
          Utils.getRandomThing());
  }

  @Override
  public void play() {
    for (int i = 0; i < 20; i++) {
      Set<Integer> keys = new TreeSet<Integer>(datastore.keys());
      for(Integer key : keys){
        System.out.println(datastore.get(key));
        instructionSet.call((Thing)datastore.get(key), datastore);
      }
      System.out.println("----");
    }
  }
}
