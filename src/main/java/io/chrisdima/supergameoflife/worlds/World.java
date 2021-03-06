package io.chrisdima.supergameoflife.worlds;

import io.chrisdima.supergameoflife.Dimensions;
import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.datastores.Datastore;
import io.chrisdima.supergameoflife.strand.Strand;
import java.util.ArrayList;

public interface World {
  void setDatastore(Datastore datastore);
  ArrayList<Thing> getNeighbors(Thing thing);
  void init();
  Dimensions getDimensions();
  void set(Point point, Thing thing);
  Thing get(Point point);
  boolean exists(Point point);
  Thing createThing(Strand strand, Point location, int energy);
}
