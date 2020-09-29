package io.chrisdima.supergameoflife.utils;

import io.chrisdima.supergameoflife.Point;
import io.chrisdima.supergameoflife.Thing;
import io.chrisdima.supergameoflife.datastores.Datastore;
import io.chrisdima.supergameoflife.datastores.InMemory;
import io.chrisdima.supergameoflife.strand.Segment;
import io.chrisdima.supergameoflife.strand.Strand;
import java.util.Random;
import java.util.stream.Stream;

public class Utils {
  static final int MAX_NUMBER_OF_SEGMENTS = 100;

  public static Thing getRandomThing(){
    Random random = new Random();
    return getRandomThing(random.nextInt(MAX_NUMBER_OF_SEGMENTS), random.nextInt());
  }

  public static Thing getRandomThing(int initialEnergy){
    Random random = new Random();
    return getRandomThing(random.nextInt(), initialEnergy);
  }

  public static Thing getRandomThing(int numberOfSegments, int initialEnergy) {
    return getRandomThing(numberOfSegments, null, initialEnergy);
  }

  public static Thing getRandomThing(int numberOfSegments, Point location, int initialEnergy){

    Random random = new Random();;
    Segment[] segments = Stream.generate(
        () -> new Segment(random.nextInt(), random.nextInt()))
        .limit(numberOfSegments)
        .toArray(Segment[]::new);
    return new Thing(new Strand(segments), location, initialEnergy);
  }
}
