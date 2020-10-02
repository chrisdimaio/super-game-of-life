package io.chrisdima.supergameoflife.instructionsets;

import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.annotations.Instruction;
import io.chrisdima.supergameoflife.datastores.Datastore;
import java.util.HashMap;
import java.util.Map;

public class StandardInstructionSet extends BaseInstructionSet implements InstructionSet {

  @Override
  public void call(Thing thing, Datastore datastore){
    invoke(indexingHash(thing.getStrand().getNextSegment().getInstruction()));
    invoke(0);
  }

  @Override
  public int indexingHash(int instruction){
    return instruction % instructionCount();
  }

  @Instruction
  public void anInstruction(){
    System.out.println("anInstruction");
  }

  @Instruction
  public void anotherInstruction(){
    System.out.println("anotherInstruction");
  }
}
