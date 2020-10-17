package io.chrisdima.supergameoflife;

import io.chrisdima.supergameoflife.datastores.HazelcastConnector;
import io.chrisdima.supergameoflife.datastores.InMemory;
import io.chrisdima.supergameoflife.distributionstrategies.DefaultStrategy;
import io.chrisdima.supergameoflife.games.DefaultGame;
import io.chrisdima.supergameoflife.instructionsets.StandardInstructionSet;
import io.chrisdima.supergameoflife.worlds.DefaultWorld;

public class SuperGameOfLife {

  public static void main(String[] args) throws Exception {
    DefaultGame game = new DefaultGame();
    game.setWorld(new DefaultWorld());
    game.setDatastore(new HazelcastConnector(new Dimensions(10, 10, 1)));

    game.setDistributionStrategy(new DefaultStrategy());
    game.setInstructionSet(new StandardInstructionSet());
    game.init();
    game.play();
  }
}
