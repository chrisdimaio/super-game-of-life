package io.chrisdima.supergameoflife.instructionsets;

import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.annotations.Instruction;
import io.chrisdima.supergameoflife.datastores.Datastore;
import io.chrisdima.supergameoflife.strand.Segment;
import io.chrisdima.supergameoflife.strand.Strand;
import io.chrisdima.supergameoflife.worlds.World;

public class StandardInstructionSet extends BaseInstructionSet implements InstructionSet {

  @Override
  public void call(Thing thing, World world){
    if(instructionCount() > 0) {
      Segment nextSegment = thing.getStrand().getNextSegment();
      int payload = nextSegment.getPayload();
      int key = indexingHash(nextSegment.getInstruction());
      invoke(key, thing, world, payload);
    }
  }

  @Override
  public int indexingHash(int instruction){
    return instruction % instructionCount();
  }

  @Instruction
  public void move(Thing thing, World world, int payload) {
    Point locationA = thing.getLocation();
    Point locationB = new Point(locationA.getX(), locationA.getY(), locationA.getZ() + 1);
    world.move(locationA, locationB, thing, payload);
  }
}
