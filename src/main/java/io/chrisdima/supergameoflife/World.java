package io.chrisdima.supergameoflife;

import io.chrisdima.supergameoflife.datastores.Datastore;
import java.util.ArrayList;

public interface World {
  public void setDatastore(Datastore datastore);
  public boolean move(Point from, Point to, Thing thing);
  public boolean die(Thing thing);
  public ArrayList<Thing> getNeighbors(Thing thing);
}
