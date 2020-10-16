package io.chrisdima.supergameoflife.strand;

import java.io.Serializable;
import lombok.Getter;

@Getter
public class Segment implements Serializable {
  final int instruction;
  final int payload;

  public Segment(int instruction, int payload){
    this.instruction = instruction;
    this.payload = payload;
  }

  @Override
  public String toString(){
    return "{ instruction: " + instruction + ", payload: " + payload + " }";
  }
}
