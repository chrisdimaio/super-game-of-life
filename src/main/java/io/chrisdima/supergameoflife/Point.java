package io.chrisdima.supergameoflife;

import javafx.geometry.Point3D;

public class Point extends Point3D {

  public Point(double x, double y, double z) {
    super(x, y, z);
  }

  @Override
  public String toString(){
    return "[x: " + getX() + ", y: " + getY() + ", z: " + getZ() + "]";
  }
}
