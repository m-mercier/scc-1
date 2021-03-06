package src.simulation.animals;

import java.util.*;
import src.simulation.*;

public class Wolf extends Animal {

  private static final int initEnergyCap = 30;
  private static final int energyOnEat = 6;
  protected static final int reproduceProb = 5;

  public Wolf(Simulation simulation) {
    super.randomGenerator();
    this.simulation = simulation;
    energy = getRand().randInt(1, initEnergyCap + 1);
  }

  public void eatSheep(){
    ArrayList<Sheep> sheepAtPosition = simulation.getSheepAt(this.getPosition());
    if (sheepAtPosition.size() > 0) { // energy should be divided by the number of wolves at a grass block
      Sheep sheepToRemove = sheepAtPosition.get(0);
      this.addEnergy(energyOnEat);
      simulation.getSheepArray().remove(sheepToRemove);
    }
  }

  public void logic() {
    if (this.getEnergy() > 0) {
      eatSheep();
      super.reproduce(reproduceProb);
      super.logic();
    } else {
      simulation.removeAnimal(this);
    }
  }
}
