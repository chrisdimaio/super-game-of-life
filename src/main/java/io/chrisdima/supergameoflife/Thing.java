package io.chrisdima.supergameoflife;

import io.chrisdima.supergameoflife.strand.Strand;
import java.io.Serializable;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Thing implements Serializable {
  private final Strand strand;

  @Setter
  private UUID id;
  @Setter
  private int energy;

  @Setter
  private Point location;

  @Getter
  @Setter
  private int generation;

  public Thing(Strand strand, Point location, UUID id){
    this.strand = strand;
    this.location = location;
    this.id = id;
    this.energy = 0;
  }

  @Override
  public String toString(){
    return "{ " +
        "strand: " + strand +
        ", energy: " + energy +
        ", location: " + location +
        ", id: " + id +
        " }";
  }
}
