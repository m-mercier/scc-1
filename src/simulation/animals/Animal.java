package src.simulation.animals;

import src.simulation.*;
import src.simulation.auxiliary.*;
import src.simulation.grid.*;

public abstract class Animal {

	protected int energy;
	protected Position position;
	private final int STEP = 1;
	private MyRandom rand;
	protected Simulation simulation;

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

	public void addEnergy(int energyBonus) {
		this.setEnergy(this.getEnergy() + energyBonus);
	}

	public void setEnergy(int energyValue) {
		this.energy = energyValue;
	}

	public int getEnergy() {
		return this.energy;
	}

	public void logic() {
		if (energy > 0) {
			move();
		} else {
			simulation.removeAnimal(this);
		}
	}

	private void move() {
		int newX;
		int newY;
        int temp;

		//newX = ((temp = this.position.getX() + rand.randInt(-STEP, STEP+1)) < simulation.getWidth()) ? temp : (simulation.getWidth()-1)-this.position.getX();

        temp = this.position.getX() + rand.randInt(-STEP, STEP + 1);

        if (temp > (simulation.getWidth() - 1) || temp < 0){
            newX = (simulation.getWidth() - 1) - this.position.getX();
        }
        else{
            newX = temp;
        }

		//newY = ((temp = this.position.getY() + rand.randInt(-STEP, STEP+1)) < simulation.getHeight()) ? temp : (simulation.getHeight()-1)-this.position.getY();

        temp = this.position.getY() + rand.randInt(-STEP, STEP + 1);

        if (temp > (simulation.getHeight() - 1) || temp < 0){
            newY = (simulation.getHeight() - 1) - this.position.getY();
        }
        else{
            newY = temp;
        }

		this.setPosition(new Position(newX, newY));
		this.addEnergy(-1);
	}

	protected void reproduce(int probability) {
		if (rand.randInt(0, 100) < probability) {
			giveBirth();
		}
	}

	private void giveBirth() {
		Animal child;
		if (this instanceof Sheep) {
			child = new Sheep(simulation);
		} else if (this instanceof Wolf) {
			child = new Wolf(simulation);
		} else {
			//default value to prevent errors
			child = new Wolf(simulation);
		}
		child.setPosition(this.getPosition());
		child.setEnergy(this.getEnergy()/2);
		simulation.addAnimal(child);

	}
}