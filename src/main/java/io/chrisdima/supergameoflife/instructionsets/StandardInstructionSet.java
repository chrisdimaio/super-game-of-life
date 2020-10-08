package io.chrisdima.supergameoflife.instructionsets;

import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.annotations.Instruction;
import io.chrisdima.supergameoflife.datastores.Datastore;

public class StandardInstructionSet extends BaseInstructionSet implements InstructionSet {

  @Override
  public void call(Thing thing, Datastore datastore){
    if(instructionCount() > 0) {
      int key = indexingHash(thing.getStrand().getNextSegment().getInstruction());
      invoke(key, thing, datastore);
    }
  }

  @Override
  public int indexingHash(int instruction){
    return instruction % instructionCount();
  }

  @Instruction
  public void move(Thing thing, Datastore datastore) {
    Point locationA = thing.getLocation();
    Point locationB = new Point(locationA.getX(), locationA.getY(), locationA.getZ() + 1);
    thing.setLocation(locationB);
    datastore.set(thing.getLocation(), thing);
    datastore.remove(locationA);
  }
}
