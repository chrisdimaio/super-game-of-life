package io.chrisdima.supergameoflife.views;

import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.datastores.Datastore;
import io.chrisdima.supergameoflife.worlds.World;
import java.util.stream.IntStream;

/**
 * A two dimensional view of the world.
 * Note: Will ignore z > 0
 */
public class TextView {
  World world;

  public TextView(World world) {
    this.world = world;
  }

  public void show() {
    int length = world.getDimensions().getLength();
    int width = world.getDimensions().getWidth();

    System.out.println("------------------");
    IntStream
        .range(0, length)
        .forEach(x -> {
          IntStream.range(0, width).forEach(y -> {
            Point p = new Point(x, y, 1);
            if(world.exists(p)) {
              System.out.print(" x ");
            } else {
              System.out.print(" . ");
            }
          });
          System.out.println();
        });
    System.out.println("------------------");
    System.out.println();
  }
}
