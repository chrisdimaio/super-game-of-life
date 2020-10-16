package io.chrisdima.supergameoflife.games;

import io.chrisdima.supergameoflife.strand.Strand;
import io.chrisdima.supergameoflife.worlds.World;
import io.chrisdima.supergameoflife.datastores.Datastore;
import io.chrisdima.supergameoflife.distributionstrategies.DistributionStrategy;
import io.chrisdima.supergameoflife.instructionsets.InstructionSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseGame implements Game {
  private static final ArrayList<String> ACCEPTABLE_ANSWERS = new ArrayList<>(List.of(
      "yes", "y", "true"
  ));

  protected boolean running;
  protected Datastore datastore;
  protected DistributionStrategy distributionStrategy;
  protected InstructionSet instructionSet;
  protected World world;

  /**
   * Controls the state of running.
   */
  protected void runner(){
    running = true;
    new Thread(() -> {
      System.out.println("Running...");
      Scanner scanner = new Scanner(System.in);
      while(running) {
        System.out.print("Continue running? [y]: ");
        String nextLine = scanner.nextLine().toLowerCase();
        nextLine = nextLine.isEmpty() ? "y" : nextLine;
        running = ACCEPTABLE_ANSWERS.contains(nextLine);
        if(!running) {
          System.out.println("Shutting down...");
        }
      }
    }).start();
  }
}
