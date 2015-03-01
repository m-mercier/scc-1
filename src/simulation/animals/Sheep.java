package src.simulation.animals;

import java.util.*;
import src.simulation.*;
import src.simulation.grid.*;

public class Sheep extends Animal {

  private static final int initEnergyCap = 7;
  private static final int energyOnEat = 4;
  protected static final int reproduceProb = 10;

  public Sheep(Simulation simulation) {
    super.randomGenerator();
    this.simulation = simulation;
    energy = getRand().randInt(1, initEnergyCap + 1);
  }

  public void eatGrass(){
    //eat the grass at this spot
    int x = this.getPosition().getX();
    int y = this.getPosition().getY();
    GrassGrid grid = simulation.getGrassGrid();

    if (grid.getGrass(x, y).isGrown()) {
      ArrayList<Sheep> sheepAtPosition = simulation.getSheepAt(this.getPosition());
      int energyBonus = energyOnEat/sheepAtPosition.size();

      grid.getGrass(x, y).setGrowth(0);
      for (Sheep sheep : sheepAtPosition) {
        sheep.addEnergy(energyBonus);
      }
    }
  }

  public void logic() {
    if (this.getEnergy() > 0) {
      super.logic();
      eatGrass();
      super.reproduce(reproduceProb);
    } else {
      simulation.removeAnimal(this);
    }
  }
}
