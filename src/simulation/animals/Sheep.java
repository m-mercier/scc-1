package src.simulation.animals;

import src.simulation.*;
import src.simulation.grid.*;

public class Sheep extends Animal {

	private static final int initEnergyCap = 7;
	protected static final int reproduceProb = 4;

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
        	grid.getGrass(x, y).setGrowth(0);
        }
    }

	public void logic() {
		super.logic();
		eatGrass(); //method missing
		super.reproduce(reproduceProb);
	}
}