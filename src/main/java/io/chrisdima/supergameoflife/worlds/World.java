package io.chrisdima.supergameoflife.worlds;

import io.chrisdima.supergameoflife.Dimensions;
import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.datastores.Datastore;
import io.chrisdima.supergameoflife.strand.Strand;
import java.util.ArrayList;

public interface World {
  public void setDatastore(Datastore datastore);
  public void move(Point from, Point to, Thing thing, int cost);
  public boolean die(Thing thing);
  public ArrayList<Thing> getNeighbors(Thing thing);
  public void init();
  public Dimensions getDimensions();
  void set(Point point, Thing thing);
  public Thing createThing(Strand strand, Point location, int energy, int id);
}
