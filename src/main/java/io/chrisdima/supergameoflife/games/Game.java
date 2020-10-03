package io.chrisdima.supergameoflife.games;

import io.chrisdima.supergameoflife.datastores.Datastore;
import io.chrisdima.supergameoflife.distributionstrategies.DistributionStrategy;
import io.chrisdima.supergameoflife.instructionsets.InstructionSet;

public interface Game {
  public void init();
  public void play();
}
