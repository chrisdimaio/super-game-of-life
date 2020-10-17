package io.chrisdima.supergameoflife.worlds;

import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;

public interface WorldAPI {
  void die(Thing thing);
  void duplicate(Thing parent, Point childLocation);
  void move(Point from, Point to, Thing thing, int cost);
  boolean isOccupied(Point spot, Thing thing, int cost);
}
