package io.chrisdima.supergameoflife.distributionstrategies;

import io.chrisdima.supergameoflife.Dimensions;
import io.chrisdima.supergameoflife.Point;

public interface DistributionStrategy {

  public Point createPoint();
  public void setDimensions(Dimensions dimensions);
}
