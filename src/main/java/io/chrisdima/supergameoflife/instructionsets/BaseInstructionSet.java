package io.chrisdima.supergameoflife.instructionsets;

import io.chrisdima.supergameoflife.annotations.Instruction;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public abstract class BaseInstructionSet {
  private int keyCounter = 0;

  private final HashMap<Integer, Method> instructionMap = new HashMap<>();

  public BaseInstructionSet() {
    collectInstructions();
  }

  private void collectInstructions(){
    for (Method method : this.getClass().getDeclaredMethods()) {
      if(method.isAnnotationPresent(Instruction.class)){
        Instruction annotation = method.getAnnotation(Instruction.class);
        instructionMap.put(annotation.key() >= 0 ? annotation.key() : keyCounter++, method);
      }
    }
  }

  protected int instructionCount(){
    return instructionMap.size();
  }

  protected void invoke(int key){
    if(instructionMap.containsKey(key)) {
      try {
        instructionMap
            .get(key)
            .invoke(this, (Object[]) null);
        System.out.println(instructionMap.get(key).getName());
      } catch (IllegalAccessException | InvocationTargetException e) {
        e.printStackTrace();
      }
    }
  }
}
