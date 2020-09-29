package io.chrisdima.supergameoflife;

import io.chrisdima.supergameoflife.datastores.Datastore;
import io.chrisdima.supergameoflife.datastores.InMemory;
import io.chrisdima.supergameoflife.instructionsets.StandardInstructionSet;
import io.chrisdima.supergameoflife.strand.Segment;
import io.chrisdima.supergameoflife.utils.Utils;

public class SuperGameOfLife {

  public static void main(String[] args){
    Datastore datastore = new InMemory(100, 100, 100);

    datastore.set(new Point(0,0,0), Utils.getRandomThing());
    datastore.set(new Point(0,0,1), Utils.getRandomThing());
    datastore.set(new Point(0,0,2), Utils.getRandomThing());
    datastore.set(new Point(0,0,3), Utils.getRandomThing());
    datastore.set(new Point(0,0,4), Utils.getRandomThing());
    datastore.set(new Point(0,0,5), Utils.getRandomThing());

    StandardInstructionSet instructions = new StandardInstructionSet();
    datastore.things().forEach(t->{
      instructions.call(t, datastore);
    });

  }
}
