package io.chrisdima.supergameoflife;

import io.chrisdima.supergameoflife.datastores.Datastore;
import io.chrisdima.supergameoflife.datastores.InMemory;
import io.chrisdima.supergameoflife.distributionstrategies.DefaultStrategy;
import io.chrisdima.supergameoflife.instructionsets.StandardInstructionSet;
import io.chrisdima.supergameoflife.strand.Segment;
import io.chrisdima.supergameoflife.utils.Utils;

public class SuperGameOfLife {

  public static void main(String[] args) throws Exception {
    InMemory datastore = new InMemory(100, 100, 100);

    DefaultStrategy strategy = new DefaultStrategy();
    strategy.setDimensions(100, 100, 100);
    datastore.set(strategy.createPoint(), Utils.getRandomThing());
    datastore.set(strategy.createPoint(), Utils.getRandomThing());
    datastore.set(strategy.createPoint(), Utils.getRandomThing());
    datastore.set(strategy.createPoint(), Utils.getRandomThing());
    datastore.set(strategy.createPoint(), Utils.getRandomThing());
    datastore.set(strategy.createPoint(), Utils.getRandomThing());

    System.out.println();

    StandardInstructionSet instructions = new StandardInstructionSet();
    datastore.things().forEach(t->{
      instructions.call(t, datastore);
    });

  }
}
