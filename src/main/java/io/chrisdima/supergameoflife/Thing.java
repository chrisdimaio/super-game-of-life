package io.chrisdima.supergameoflife;

import io.chrisdima.supergameoflife.strand.Strand;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Thing {
  private final Strand strand;
  private final int energy;

  @Setter
  private Point location;

  public Thing(Strand strand, Point location, int energy){
    this.strand = strand;
    this.location = location;
    this.energy = energy;
  }

  @Override
  public String toString(){
    return "{ strand: " + strand + ", energy: " + energy + " }";
  }
}
