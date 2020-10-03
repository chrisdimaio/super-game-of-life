package io.chrisdima.supergameoflife;

import lombok.Getter;

@Getter
public class Dimensions {
  private final int length;
  private final int width;
  private final int depth;
  private final int volume;

  public Dimensions(int length, int width, int depth) {
    this.length = length;
    this.width = width;
    this.depth = depth;
    volume = length * width * depth;
  }
}
