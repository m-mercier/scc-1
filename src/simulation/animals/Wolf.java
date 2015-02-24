package src.simulation.animals;

import src.simulation.*;
import src.simulation.grid.*;

public class Wolf extends Animal {

	private static final int initEnergyCap = 30;
	protected static final int reproduceProb = 5;

	public Wolf(Simulation simulation) {
		super.randomGenerator();
		this.simulation = simulation;
		energy = getRand().randInt(1, initEnergyCap + 1);
	}

    public void eatSheep(){
    	//code to eat sheep
    }

	public void logic() {
		super.logic();
		eatSheep(); //method missing
		super.reproduce(reproduceProb);
	}
}