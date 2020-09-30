package io.chrisdima.supergameoflife.instructionsets;

import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.datastores.Datastore;
import java.util.HashMap;
import java.util.Map;

public class StandardInstructionSet implements InstructionSet {

  @Override
  public String call(Thing thing, Datastore datastore){
    switch(indexingHash(thing.getStrand().getNextSegment().getInstruction())){
      case 0:
        return thing.getId() + ": 0";
      case 1:
        return thing.getId() + ": 1";
      case 2:
        return thing.getId() + ": 2";
      case 3:
        return thing.getId() + ": 3";
      case 4:
        return thing.getId() + ": 4";
      default:
        return thing.getId() + ": 5";
    }
  }

  @Override
  public int indexingHash(int instruction){
    return instruction % 5;
  }
}
