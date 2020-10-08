package io.chrisdima.supergameoflife.instructionsets;

import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.worlds.World;

public interface InstructionSet {
  /**
   * Maps an instruction to this InstructionSets instruction map.
   * @param instruction The instruction to map.
   * @return The key into the instruction map.
   */
  int indexingHash(int instruction);

  void call(Thing thing, World world);
}
