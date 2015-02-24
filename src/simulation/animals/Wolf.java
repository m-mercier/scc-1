package src.simulation.animals;

public class Wolf extends Animal {

	private static final int initEnergyCap = 30;
	protected static final int reproduceProb = 5;

	public Wolf() {
		super.randomGenerator();
		energy = getRand().randInt(1, initEnergyCap+1);
	}

    public void eatSheep(){

    }

	public void logic() {
		super.logic();
		eatSheep(); //method missing
		super.reproduce(reproduceProb);
	}
}