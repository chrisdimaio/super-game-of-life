package io.chrisdima.supergameoflife;

import io.chrisdima.supergameoflife.datastores.Datastore;
import java.util.ArrayList;

public class DefaultWorld implements World {
  private Datastore datastore;

  @Override
  public void setDatastore(Datastore datastore) {
    this.datastore = datastore;
  }

  @Override
  public boolean move(Point from, Point to, Thing thing) {
    return false;
  }

  @Override
  public boolean die(Thing thing) {
    return false;
  }

  @Override
  public ArrayList<Thing> getNeighbors(Thing thing) {
    return null;
  }
}
