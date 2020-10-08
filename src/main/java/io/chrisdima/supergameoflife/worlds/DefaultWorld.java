package io.chrisdima.supergameoflife.worlds;

import io.chrisdima.supergameoflife.Dimensions;
import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.datastores.Datastore;
import io.chrisdima.supergameoflife.strand.Strand;
import java.util.ArrayList;

public class DefaultWorld implements World {
  private static final String WORLD_DATA_ENERGY = "energy";
  private Datastore datastore;

  @Override
  public void init(){
    verify(this);
    datastore.setWorldData(WORLD_DATA_ENERGY, 100000);
//    System.out.println("World initial energy: " + datastore.getWorldData(WORLD_DATA_ENERGY));
  }

  @Override
  public Dimensions getDimensions() {
    return datastore.getDimensions();
  }

  @Override
  public void set(Point point, Thing thing) {
    datastore.set(point, thing);
  }

  @Override
  public void setDatastore(Datastore datastore) {
    this.datastore = datastore;
  }

  @Override
  public void move(Point from, Point to, Thing thing, int cost) {
    accountForEnergy(thing, -cost);
    datastore.move(from, to, thing);
  }

  @Override
  public boolean die(Thing thing) {
    return false;
  }

  @Override
  public ArrayList<Thing> getNeighbors(Thing thing) {
    return null;
  }

  @Override
  public String toString() {
    return "{ energy: " + getEnergy() + " }";
  }

  @Override
  public Thing createThing(Strand strand, Point location, int energy, int id) {
    Thing thing = new Thing(strand, location, id);
    accountForEnergy(thing, energy);
    return thing;
  }

  private void verify(World world){

  }

  /**
   * A rule of default world is energy conservation. The world has finite energy and no new energy
   * is created or removed. This method enforces this rule.
   * @param thing The thing to who's energy change will be accounted for.
   * @param energyChange A positive or negative energy change.
   */
  private void accountForEnergy(Thing thing, int energyChange){
    thing.setEnergy(thing.getEnergy() + energyChange);
    setEnergy(getEnergy() - energyChange);
  }

  private int getEnergy() {
    return (int)datastore.getWorldData(WORLD_DATA_ENERGY);
  }

  private void setEnergy(int energy) {
    datastore.setWorldData(WORLD_DATA_ENERGY, energy);
  }
}
