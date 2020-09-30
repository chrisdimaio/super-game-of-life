package io.chrisdima.supergameoflife;

import io.chrisdima.supergameoflife.datastores.Datastore;

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
}
