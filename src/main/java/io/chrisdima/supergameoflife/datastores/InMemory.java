package io.chrisdima.supergameoflife.datastores;

import io.chrisdima.supergameoflife.Dimensions;
import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;
import java.util.Collection;
import java.util.HashMap;
import lombok.Getter;

public class InMemory implements Datastore {
  private final HashMap<Integer, Thing> space;

  @Getter
  private final Dimensions dimensions;

  public InMemory(Dimensions dimensions){
    this.dimensions = dimensions;
    this.space = new HashMap<>(dimensions.getLength() * dimensions.getWidth() *
        dimensions.getDepth());
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
    return point.getXInt() + dimensions.getWidth() * (point.getYInt() +
        dimensions.getDepth() * point.getZInt());
  }
}
