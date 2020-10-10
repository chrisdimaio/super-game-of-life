package io.chrisdima.supergameoflife.games;

import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.utils.Utils;
import io.chrisdima.supergameoflife.worlds.WorldAPI;
import java.util.Set;
import java.util.TreeSet;

public class DefaultGame extends BaseGame {

  @Override
  public void init(){
    verfiy(this);

    world.setDatastore(datastore);
    world.init();
    System.out.println(world);

    for(int i = 0; i < world.getDimensions().getVolume(); i++)
      world.set(distributionStrategy.createSpot(world.getDimensions()),
          Utils.getRandomThing(world, 1000));
  }

  @Override
  public void play() {

    for (int i = 0; i < 2; i++) {
      Set<Integer> keys = new TreeSet<Integer>(datastore.keys());
      for(Integer key : keys){
        System.out.println(datastore.get(key));
        instructionSet.call((Thing)datastore.get(key), (WorldAPI) world);
      }
      System.out.println(i);
    }
    System.out.println(world);
  }

  private void verfiy(Game game){

  }
}
