package io.chrisdima.supergameoflife.instructionsets;

import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.annotations.Instruction;
import io.chrisdima.supergameoflife.datastores.Datastore;

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
  public void anInstruction(){}

  @Instruction
  public void anotherInstruction(){}

  @Instruction
  public void doSomething(){}

  @Instruction
  public void somethingElse(){}
}
