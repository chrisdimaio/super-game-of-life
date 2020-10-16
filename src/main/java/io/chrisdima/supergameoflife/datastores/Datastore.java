package io.chrisdima.supergameoflife.datastores;

import io.chrisdima.supergameoflife.Dimensions;
import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;
import java.util.Map;
import java.util.Set;

public interface Datastore {
  boolean exists(Point point);
  Object get(Point point);
  Object get(Integer key);
  void set(Point point, Thing thing);
  Set<Integer> keys();
  Dimensions getDimensions();
  void remove(Point point);
  Object getWorldData(Object key);
  void setWorldData(Object key, Object value);
  public void move(Point from, Point to, Thing thing);
  public void shutdown();
}
