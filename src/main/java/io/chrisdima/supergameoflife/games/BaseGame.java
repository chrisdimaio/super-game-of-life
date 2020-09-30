package io.chrisdima.supergameoflife.games;

import io.chrisdima.supergameoflife.datastores.Datastore;
import io.chrisdima.supergameoflife.distributionstrategies.DistributionStrategy;
import io.chrisdima.supergameoflife.instructionsets.InstructionSet;

public abstract class BaseGame implements Game {
  protected Datastore datastore;
  protected DistributionStrategy distributionStrategy;
  protected InstructionSet instructionSet;

  public BaseGame withDataStore(Datastore datastore){
    this.datastore = datastore;
    return this;
  }

  public BaseGame withDistributionStrategy(DistributionStrategy distributionStrategy){
    this.distributionStrategy = distributionStrategy;
    return this;
  }

  public BaseGame withInstructionSet(InstructionSet instructionSet){
    this.instructionSet = instructionSet;
    return this;
  }
}
