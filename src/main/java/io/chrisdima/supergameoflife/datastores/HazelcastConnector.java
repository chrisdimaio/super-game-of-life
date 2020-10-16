package io.chrisdima.supergameoflife.datastores;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import io.chrisdima.supergameoflife.Dimensions;
import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;
import java.util.Map;
import java.util.Set;
import lombok.Getter;

public class HazelcastConnector implements Datastore {
  HazelcastInstance hazelcast = Hazelcast.newHazelcastInstance();

  private final Map<Integer, Thing> buffer;
  private final Map<Object, Object> worldData;

  @Getter
  private final Dimensions dimensions;

  public HazelcastConnector(Dimensions dimensions){
    this.dimensions = dimensions;
    this.buffer = hazelcast.getMap("buffer");
    this.worldData = hazelcast.getMap("worldData");
  }

  @Override
  public void move(Point from, Point to, Thing thing) {
    this.set(to, thing);
    this.remove(from);
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
  public Object getWorldData(Object key) {
    return worldData.get(key);
  }

  @Override
  public void setWorldData(Object key, Object value) {
    worldData.put(key, value);
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

  @Override
  public void shutdown() {
    hazelcast.getLifecycleService().shutdown();
  }

  private int flattenAddress(Point point){
    return (int)point.getX() + dimensions.getWidth() * ((int)point.getY() +
        dimensions.getDepth() * (int)point.getZ());
  }

  public void set(Thing thing) throws Exception{
    if(thing.getLocation() == null)
      throw new Exception("thing.location == null");
    set(thing.getLocation(), thing);
  }
}
