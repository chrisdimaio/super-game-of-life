package io.chrisdima.supergameoflife.worlds;

import io.chrisdima.supergameoflife.Dimensions;
import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.datastores.Datastore;
import io.chrisdima.supergameoflife.strand.Strand;
import java.util.ArrayList;

import java.util.UUID;

public class DefaultWorld implements World, WorldAPI {
  private static final int FIXED_COST = 1;
  private static final int WORLD_NET_ENERGY = 1000000;
  private static final String WORLD_DATA_ENERGY = "energy";
  private Datastore datastore;

  @Override
  public void init(){
    verify(this);
    datastore.setWorldData(WORLD_DATA_ENERGY, WORLD_NET_ENERGY);
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
    chargeFixedCost(thing);
    accountForEnergy(thing, -1);
    if(inBounds(to)) {
      datastore.move(from, to, thing);
    }
  }

  @Override
  public boolean die(Thing thing) {
    chargeFixedCost(thing);
    return false;
  }

  @Override
  public void duplicate(Thing parent, Point childLocation) {
    Thing child = newThing(parent.getStrand(), childLocation);
    child.setGeneration(parent.getGeneration() + 1);
    datastore.set(childLocation, child);
  }

  @Override
  public ArrayList<Thing> getNeighbors(Thing thing) {
    chargeFixedCost(thing);
    return null;
  }

  @Override
  public String toString() {
    return "{ energy: " + getEnergy() + " }";
  }

  @Override
  public Thing createThing(Strand strand, Point location, int energy) {
    Thing thing = newThing(strand, location);
    accountForEnergy(thing, energy);
    return thing;
  }

  private boolean inBounds(Point point) {
    return
        point.getX() >= 0 && point.getX() <= getDimensions().getWidth() &&
            point.getY() >= 0 && point.getY() <= getDimensions().getLength() &&
            point.getZ() >= 0 && point.getZ() <= getDimensions().getDepth();
  }

  private Thing newThing(Strand strand, Point location) {
    return new Thing(strand, location, UUID.randomUUID());
  }

  private void verify(World world){

  }

  /**
   * A rule of default world is energy conservation. The world has finite energy and no new energy
   * is created or removed. This method enforces this rule.
   * @param thing The thing to who's energy change will be accounted for.
   * @param energyChange A positive or negative energy change.
   */
  private void accountForEnergy(Thing thing, int energyChange) {
    thing.setEnergy(thing.getEnergy() + energyChange);
    setEnergy(getEnergy() - energyChange);
  }

  private void chargeFixedCost(Thing thing) {
    accountForEnergy(thing, FIXED_COST);
  }

  private int getEnergy() {
    return (int)datastore.getWorldData(WORLD_DATA_ENERGY);
  }

  private void setEnergy(int energy) {
    datastore.setWorldData(WORLD_DATA_ENERGY, energy);
  }
}
