package io.chrisdima.supergameoflife.datastores;

import io.chrisdima.supergameoflife.Dimensions;
import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;
import java.util.Collection;
import javafx.geometry.Point3D;

public interface Datastore {
  boolean exists(Point point);
  Object get(Point point);
  void set(Point point, Thing thing);
  Collection<Thing> things();
  Dimensions getDimensions();
}
