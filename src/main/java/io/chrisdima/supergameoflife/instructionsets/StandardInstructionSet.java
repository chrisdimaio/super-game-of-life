package io.chrisdima.supergameoflife.instructionsets;

import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.datastores.Datastore;

public class StandardInstructionSet implements InstructionSet {

  @Override
  public void call(Thing thing, Datastore datastore){
    System.out.println(thing.getStrand().getNextSegment().getInstruction());
  }

  @Override
  public int indexingHash(int instruction){
    return instruction % Byte.MAX_VALUE;
  }
}
