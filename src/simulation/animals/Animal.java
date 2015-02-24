package src.simulation.animals;

import src.simulation.*;
import src.simulation._aux.*;
import src.simulation.grid.*;

public abstract class Animal {

	protected int energy;
	protected Position position;
	private static final int STEP = 1;
	private MyRandom rand;

	protected void randomGenerator() {
		rand = new MyRandom();
	}

    public MyRandom getRand(){
        return rand;
    }
	public void setPosition(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setEnergy(int energyValue) {
		this.energy = energyValue;
	}

	public int getEnergy() {
		return this.energy;
	}

	public void logic() {
		move();
	}

	public void move() {
		int newX;
		int newY;
        int temp;

		newX = ((temp = this.position.getX() + rand.randInt(-STEP, STEP+1)) < GrassGrid.width) ? temp : GrassGrid.width-this.position.getX();
		newY = ((temp = this.position.getY() + rand.randInt(-STEP, STEP+1)) < GrassGrid.height) ? temp : GrassGrid.height-this.position.getY();

		this.setPosition(new Position(newX, newY));
	}

	protected void reproduce(int probability) {
		if (rand.randInt(0, 100) < probability) {
			giveBirth();
		}
	}

	private void giveBirth() {
		if (this instanceof Sheep) {
			Sheep child = new Sheep();
		} else if (this instanceof Wolf) {
			Wolf child = new Wolf();
		} else {
			//default value to prevent errors
			Wolf child = new Wolf();
		}
		child.setPosition(this.getPosition());
		child.setEnergy(this.getEnergy());
		Simulation.addAnimal(child);

	}
}