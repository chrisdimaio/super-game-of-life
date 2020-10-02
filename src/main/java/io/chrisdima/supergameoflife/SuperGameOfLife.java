package io.chrisdima.supergameoflife;

import io.chrisdima.supergameoflife.datastores.InMemory;
import io.chrisdima.supergameoflife.distributionstrategies.DefaultStrategy;
import io.chrisdima.supergameoflife.games.DefaultGame;
import io.chrisdima.supergameoflife.instructionsets.StandardInstructionSet;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.shape.Box;

public class SuperGameOfLife {

  public static void main(String[] args) throws Exception {
    DefaultStrategy strategy = new DefaultStrategy();
    strategy.setDimensions(100, 100, 100);
    DefaultGame game = new DefaultGame();
        game.withDataStore(new InMemory(100, 100, 100))
        .withDistributionStrategy(strategy)
        .withInstructionSet(new StandardInstructionSet());
    game.init();
    game.play();
  }
}
