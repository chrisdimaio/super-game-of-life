package io.chrisdima.supergameoflife;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

public class Point implements Serializable {
  @Getter
  @Setter
  double x,y,z;

  public Point(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  @Override
  public String toString(){
    return "[x: " + getX() + ", y: " + getY() + ", z: " + getZ() + "]";
  }
}
