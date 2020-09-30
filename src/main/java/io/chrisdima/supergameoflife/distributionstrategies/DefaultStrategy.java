package io.chrisdima.supergameoflife.distributionstrategies;

import io.chrisdima.supergameoflife.Point;

public class DefaultStrategy implements DistributionStrategy {
  private int length, width, depth;
  private int counter = 0;
  private int x, y, z = 0;

  public void setDimensions(int length, int width, int depth){
    this.length = length;
    this.width = width;
    this.depth = depth;
  }

  @Override
  public Point createPoint() {
    switch (counter++ % 3){
      case 0:
        if(x == width - 1)
          this.x = 0;
        return new Point(x++, y, z);
      case 1:
        if(y == length - 1)
          this.y = 0;
        return new Point(x, y++, z);
      default:
        if(z == depth - 1)
          this.z = 0;
        return new Point(x, y, z++);
    }
  }
}
