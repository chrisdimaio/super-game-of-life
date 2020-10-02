package io.chrisdima.supergameoflife.games;

import io.chrisdima.supergameoflife.utils.Utils;

public class DefaultGame extends BaseGame {

  @Override
  public void init(){
    for(int i = 0; i < 1000; i++)
      datastore.set(distributionStrategy.createPoint(), Utils.getRandomThing());
  }

  @Override
  public void play() {
    datastore.things().forEach(t -> {
      instructionSet.call(t, datastore);
    });
  }
}
