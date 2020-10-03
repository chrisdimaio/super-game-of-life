package io.chrisdima.supergameoflife.games;

import io.chrisdima.supergameoflife.datastores.Datastore;
import io.chrisdima.supergameoflife.distributionstrategies.DistributionStrategy;
import io.chrisdima.supergameoflife.instructionsets.InstructionSet;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseGame implements Game {
  protected Datastore datastore;
  protected DistributionStrategy distributionStrategy;
  protected InstructionSet instructionSet;
}
