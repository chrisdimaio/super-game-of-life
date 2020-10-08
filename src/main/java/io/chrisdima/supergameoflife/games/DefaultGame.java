package io.chrisdima.supergameoflife.games;

import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.utils.Utils;

public class DefaultGame extends BaseGame {

  @Override
  public void init(){
    for(int i = 0; i < datastore.getDimensions().getVolume(); i++)
      datastore.set(distributionStrategy.createSpot(datastore.getDimensions()),
          Utils.getRandomThing());
  }

  @Override
  public void play() {
    datastore.things().forEach(t -> {
      instructionSet.call(t, datastore);
    });
  }
}
