package io.chrisdima.supergameoflife.distributionstrategies;

import io.chrisdima.supergameoflife.Dimensions;
import io.chrisdima.supergameoflife.Point;

public class DefaultStrategy implements DistributionStrategy {
  private Dimensions dimensions;
  private int counter = 0;
  private int x, y, z = 0;

  @Override
  public Point createSpot(Dimensions dimensions) {
    switch (counter++ % 3){
      case 0:
        if(x == dimensions.getWidth() - 1)
          this.x = 0;
        return new Point(x++, y, z);
      case 1:
        if(y == dimensions.getLength() - 1)
          this.y = 0;
        return new Point(x, y++, z);
      default:
        if(z == dimensions.getDepth() - 1)
          this.z = 0;
        return new Point(x, y, z++);
    }
  }
}
