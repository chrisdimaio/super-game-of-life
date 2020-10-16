package io.chrisdima.supergameoflife.strand;

import java.io.Serializable;
import java.util.Arrays;

public class Strand implements Serializable {
  private final Segment[] strand;

  private int index = 0;

  public Strand(Segment[] fromArray){
    strand = Arrays.copyOf(fromArray, fromArray.length);
  }

  public Segment getNextSegment(){
    if(index >= strand.length){
      index = 1;
      return strand[0];
    }
    return strand[index++];
  }

  @Override
  public String toString(){
    return "{ segments: " + strand.length + " }";
  }
}
