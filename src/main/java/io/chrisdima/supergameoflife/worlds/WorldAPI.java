package io.chrisdima.supergameoflife.worlds;

import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;

public interface WorldAPI {
  void move(Point from, Point to, Thing thing, int cost);
  boolean die(Thing thing);
}
