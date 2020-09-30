package io.chrisdima.supergameoflife;

import io.chrisdima.supergameoflife.datastores.InMemory;
import io.chrisdima.supergameoflife.distributionstrategies.DefaultStrategy;
import io.chrisdima.supergameoflife.instructionsets.StandardInstructionSet;
import io.chrisdima.supergameoflife.utils.Utils;

public class SuperGameOfLife {

  public static void main(String[] args) throws Exception {
    InMemory datastore = new InMemory(100, 100, 100);

    DefaultStrategy strategy = new DefaultStrategy();
    strategy.setDimensions(100, 100, 100);

    for(int i = 0; i < 10000; i++)
      datastore.set(strategy.createPoint(), Utils.getRandomThing());

    StandardInstructionSet instructions = new StandardInstructionSet();
      datastore.things().forEach(t -> {
        String result = instructions.call(t, datastore);
        System.out.println("result: " + result);
      });
  }
}
