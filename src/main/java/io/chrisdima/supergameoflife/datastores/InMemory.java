package io.chrisdima.supergameoflife.datastores;

import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;
import java.util.Collection;
import java.util.HashMap;

public class InMemory implements Datastore {
  private final HashMap<Integer, Thing> space;
  private final int width, depth;

  public InMemory(int length, int width, int depth){
    this.width = width;
    this.depth = depth;
    this.space = new HashMap<>(length * width * depth);
  }

  @Override
  public boolean exists(Point point) {
    return space.containsKey(flatAddress(point));
  }

  @Override
  public Object get(Point point) {
    return space.get(flatAddress(point));
  }

  public void set(Thing thing) throws Exception{
    if(thing.getLocation() == null)
      throw new Exception("thing.location == null");
    set(thing.getLocation(), thing);
  }

  @Override
  public void set(Point point, Thing thing) {
    space.put(flatAddress(point), thing);
  }

  @Override
  public Collection<Thing> things(){
    return space.values();
  }

  private int flatAddress(Point point){
    return point.getXInt() + this.width * (point.getYInt() + this.depth * point.getZInt());
  }
}
