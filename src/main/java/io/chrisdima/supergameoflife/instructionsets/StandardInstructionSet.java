package io.chrisdima.supergameoflife.instructionsets;

import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.annotations.Instruction;
import io.chrisdima.supergameoflife.datastores.Datastore;
import io.chrisdima.supergameoflife.strand.Segment;
import io.chrisdima.supergameoflife.strand.Strand;
import io.chrisdima.supergameoflife.worlds.World;
import io.chrisdima.supergameoflife.worlds.WorldAPI;

public class StandardInstructionSet extends BaseInstructionSet implements InstructionSet {

  @Override
  public void call(Thing thing, WorldAPI worldAPI){
    if(instructionCount() > 0) {
      Segment nextSegment = thing.getStrand().getNextSegment();
      int payload = nextSegment.getPayload();
      int key = indexingHash(nextSegment.getInstruction());
      invoke(key, thing, worldAPI, payload);
    }
  }

  @Override
  public int indexingHash(int instruction){
    return instruction % instructionCount();
  }

  @Instruction
  public void eat(Thing thing, WorldAPI worldAPI, int payload) {
    Point spot = thing.getLocation();
    spot.setZ(thing.getLocation().getZ() + 1);
    if(worldAPI.isOccupied(spot, thing, 2)) {
      System.out.println("I might eat this: " + spot);
    }
  }

  @Instruction
  public void move(Thing thing, WorldAPI worldAPI, int payload) {
    Point locationA = thing.getLocation();
    Point locationB = new Point(locationA.getX(), locationA.getY(), locationA.getZ() + 1);
    worldAPI.move(locationA, locationB, thing, payload);
  }

  @Instruction
  public void duplicate(Thing parent, WorldAPI worldAPI, int payload) {
    worldAPI.duplicate(parent,
        new Point(
            parent.getLocation().getX(),
            parent.getLocation().getY(),
            parent.getLocation().getZ() + 1));
  }
}
