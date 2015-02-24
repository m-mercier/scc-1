package src.simulation.animals;

public class Sheep extends Animal {

	private static final int initEnergyCap = 7;
	protected static final int reproduceProb = 4;

	public Sheep() {
        super.randomGenerator();
        energy = getRand().randInt(1, initEnergyCap + 1);
    }

    public void eatGrass(){
        this.position
    }

	public void logic() {
		super.logic();
		eatGrass(); //method missing
		super.reproduce(reproduceProb);
	}
}