package src.simulation;

import java.util.*;
import src.simulation.animals.*;
import src.simulation.auxiliary.*;
import src.simulation.grid.GrassGrid;


public class Simulation {
	
	private final int WIDTH = 51;
	private final int HEIGHT = 51;
	private int simulationTime;

	private ArrayList<Sheep> sheepArray;
	private ArrayList<Wolf> wolfArray; 
	private GrassGrid grassGrid;

	private MyRandom random;

	public Simulation(int time) {
		random = new MyRandom();
		grassGrid = new GrassGrid(WIDTH, HEIGHT);
		sheepArray = new ArrayList<Sheep>();
		wolfArray = new ArrayList<Wolf>();
		this.simulationTime = time;

		spawnAnimals();
	}

	public void addAnimal(Animal newAnimal) {
		if (newAnimal instanceof Sheep) {
			sheepArray.add((Sheep)newAnimal);
		} else if (newAnimal instanceof Wolf) {
			wolfArray.add((Wolf)newAnimal);
		}
	}

	private void spawnAnimals() {
		int sheepMax = 100;
		int wolfMax = 30;

		//generate all the sheep
		for (int i = 0; i < sheepMax; i++) {
			Sheep newSheep = new Sheep(this);
			newSheep.setPosition(new Position(random.randInt(0, WIDTH+1), random.randInt(0, HEIGHT+1)));
			addAnimal(newSheep);
		}

		//generate all the wolves
		for (int i = 0; i < wolfMax; i++) {
			Wolf newWolf = new Wolf(this);
			newWolf.setPosition(new Position(random.randInt(0, WIDTH+1), random.randInt(0, HEIGHT+1)));
			addAnimal(newWolf);
		}
	}

	public void start() {
		for (int i = 0; i < this.simulationTime; i++) {
			for (Sheep sheep : sheepArray) {
				sheep.logic();
			}

			for (Wolf wolf : wolfArray) {
				wolf.logic();
			}
			
			grassGrid.growGrass();
		}
	}

	public int getWidth() {
		return this.WIDTH;
	}

	public int getHeight() {
		return this.HEIGHT;
	}

	public GrassGrid getGrassGrid() {
		return this.grassGrid;
	}
}