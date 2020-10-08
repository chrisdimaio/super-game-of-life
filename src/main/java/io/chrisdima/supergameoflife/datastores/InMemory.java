package io.chrisdima.supergameoflife.datastores;

import io.chrisdima.supergameoflife.Dimensions;
import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import lombok.Getter;

public class InMemory implements Datastore {
  private final HashMap<Integer, Thing> buffer;
  private final Iterator<Thing> iterator;

  @Getter
  private final Dimensions dimensions;

  public InMemory(Dimensions dimensions){
    this.dimensions = dimensions;
    this.buffer = new HashMap<>(dimensions.getLength() * dimensions.getWidth() *
        dimensions.getDepth());
    this.iterator = this.buffer.values().iterator();
  }

  @Override
  public boolean exists(Point point) {
    return buffer.containsKey(flattenAddress(point));
  }

  @Override
  public Object get(Point point) {
    return buffer.get(flattenAddress(point));
  }

  @Override
  public Object get(Integer key) {
    return buffer.get(key);
  }

  @Override
  public void remove(Point point) {
    buffer.remove(flattenAddress(point));
  }

  @Override
  public void set(Point point, Thing thing) {
    thing.setLocation(point);
    buffer.put(flattenAddress(point), thing);
  }

  @Override
  public Set<Integer> keys(){
    return buffer.keySet();
  }

  private int flattenAddress(Point point){
    return point.getXInt() + dimensions.getWidth() * (point.getYInt() +
        dimensions.getDepth() * point.getZInt());
  }

  public void set(Thing thing) throws Exception{
    if(thing.getLocation() == null)
      throw new Exception("thing.location == null");
    set(thing.getLocation(), thing);
  }
}
