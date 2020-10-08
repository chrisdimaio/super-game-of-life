package io.chrisdima.supergameoflife;

import io.chrisdima.supergameoflife.strand.Strand;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Thing {
  private final Strand strand;

  @Setter
  private int id;
  @Setter
  private int energy;

  @Setter
  private Point location;

  public Thing(Strand strand, Point location, int id){
    this.strand = strand;
    this.location = location;
    this.id = id;
    this.energy = 0;
  }

  @Override
  public String toString(){
    return "{ strand: " + strand + ", energy: " + energy + ", location: " + location + " }";
  }
}
