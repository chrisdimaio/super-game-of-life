package io.chrisdima.supergameoflife;

import io.chrisdima.supergameoflife.strand.Strand;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Thing {
  private final Strand strand;
  private final int energy;

  @Setter
  private int id;
  private Point location;

  public Thing(Strand strand, Point location, int energy, int id){
    this.strand = strand;
    this.location = location;
    this.energy = energy;
    this.id = id;
  }

  @Override
  public String toString(){
    return "{ strand: " + strand + ", energy: " + energy + " }";
  }
}
