package io.chrisdima.supergameoflife.distributionstrategies;

import io.chrisdima.supergameoflife.Point;

public interface Strategy {

  public Point createPoint();
  public void setDimensions(int length, int width, int depth);
}
