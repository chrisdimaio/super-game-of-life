package io.chrisdima.supergameoflife;

import javafx.geometry.Point3D;

public class Point extends Point3D {

  public Point(double x, double y, double z) {
    super(x, y, z);
  }

  public int getXInt(){
    return (int) this.getX();
  }

  public int getYInt(){
    return (int) this.getY();
  }

  public int getZInt(){
    return (int) this.getZ();
  }
}
