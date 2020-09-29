package io.chrisdima.supergameoflife.strand;

import lombok.Getter;

@Getter
public class Segment {
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
