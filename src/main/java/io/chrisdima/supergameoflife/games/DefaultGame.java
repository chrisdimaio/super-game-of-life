package io.chrisdima.supergameoflife.games;

import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.utils.Utils;
import io.chrisdima.supergameoflife.views.TextView;
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
          Utils.getRandomThing(world, 10));
  }

  @Override
  public void play() {
    TextView textView = new TextView(world);
    runner();
    int passes = 0;
    while(running) {
      if(passes % 250 == 0) {
        textView.show();
      }
      Set<Integer> keys = new TreeSet<Integer>(datastore.keys());
      for(Integer key : keys){
        instructionSet.call((Thing)datastore.get(key), (WorldAPI) world);
      }
      passes++;
    }
    datastore.shutdown();
    System.out.println("passes: " + passes);
    System.out.println(world);
  }

  private void verfiy(Game game){

  }
}
