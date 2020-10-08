package io.chrisdima.supergameoflife;

import io.chrisdima.supergameoflife.datastores.InMemory;
import io.chrisdima.supergameoflife.distributionstrategies.DefaultStrategy;
import io.chrisdima.supergameoflife.games.DefaultGame;
import io.chrisdima.supergameoflife.instructionsets.StandardInstructionSet;

public class SuperGameOfLife {

  public static void main(String[] args) throws Exception {
    DefaultGame game = new DefaultGame();
    game.setDatastore(new InMemory(new Dimensions(1, 2, 2)));
    game.setDistributionStrategy(new DefaultStrategy());
    game.setInstructionSet(new StandardInstructionSet());
    game.init();
    game.play();
  }
}
