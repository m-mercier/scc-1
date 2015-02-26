package src.simulation;

import java.io.IOException;
import java.util.*;
import src.simulation.animals.*;
import src.simulation.auxiliary.*;
import src.simulation.grid.GrassGrid;
import src.simulation.log.MyLog;


public class Simulation {
	
	private final int WIDTH = 51;
	private final int HEIGHT = 51;
	private int simulationTime;

	private ArrayList<Sheep> sheepArray;
	private ArrayList<Wolf> wolfArray; 
	private GrassGrid grassGrid;

	private MyRandom random;

	private ArrayList<Animal> animalCleanup;

	public Simulation(int time) {
		random = new MyRandom();
		grassGrid = new GrassGrid(WIDTH, HEIGHT);
		sheepArray = new ArrayList<Sheep>();
		wolfArray = new ArrayList<Wolf>();
		this.simulationTime = time;
		animalCleanup = new ArrayList<Animal>();

		spawnAnimals();

        start();
	}

	public void addAnimal(Animal newAnimal) {
		if (newAnimal instanceof Sheep) {
			sheepArray.add((Sheep)newAnimal);
		} else if (newAnimal instanceof Wolf) {
			wolfArray.add((Wolf)newAnimal);
		}
	}

	public void removeAnimal(Animal animal) {
		animalCleanup.add(animal);
	}

	private void cleanup() {
		for (Animal animal : animalCleanup) {
			if (animal instanceof Sheep) {
				sheepArray.remove((Sheep)animal);
			} else if (animal instanceof Wolf) {
				sheepArray.remove((Wolf)animal);
			}
		}
		animalCleanup.clear();
	}

	public ArrayList<Sheep> getSheepAt(Position position) {
		ArrayList<Sheep> sheepAtPosition = new ArrayList<Sheep>();

		for (Sheep sheep : sheepArray) {
			if (sheep.getPosition().equals(position)) {
				sheepAtPosition.add(sheep);
			}
		}

		return sheepAtPosition;
	}

	private void spawnAnimals() {
		int sheepMax = 100;
		int wolfMax = 30;

		//generate all the sheep
		for (int i = 0; i < sheepMax; i++) {
			Sheep newSheep = new Sheep(this);
			newSheep.setPosition(new Position(random.randInt(0, WIDTH-1), random.randInt(0, HEIGHT-1)));
			addAnimal(newSheep);
		}

		//generate all the wolves
		for (int i = 0; i < wolfMax; i++) {
			Wolf newWolf = new Wolf(this);
			newWolf.setPosition(new Position(random.randInt(0, WIDTH-1), random.randInt(0, HEIGHT-1)));
			addAnimal(newWolf);
		}
	}

	public void start() {

        MyLog log_sheep = new MyLog("sheep.txt");
        MyLog log_wolves = new MyLog("wolves.txt");
        MyLog log_grass = new MyLog("grass.txt");

        loop(log_sheep, log_wolves, log_grass);
        closeLogs(log_sheep, log_wolves, log_grass);

	}

	private void loop(MyLog log_sheep, MyLog log_wolves, MyLog log_grass) {

		for (int i = 0; i < this.simulationTime; i++) {
			for (Sheep sheep : sheepArray) {
				sheep.logic();
			}

			for (Wolf wolf : wolfArray) {
				wolf.logic();
			}
			
			grassGrid.growGrass();
			writeLogs(log_sheep, log_wolves, log_grass);
		}
	}

	private void writeLogs(MyLog log_sheep, MyLog log_wolves, MyLog log_grass) {

		int grassCounter = 0;
		
		try{
            log_sheep.write(String.format("%d\n", sheepArray.size()));
            log_wolves.write(String.format("%d\n", wolfArray.size()));
            for (int j = 0; j < WIDTH; j++){
                for (int k = 0; k < HEIGHT; k++){
                    if (getGrassGrid().getGrass(j,k).isGrown()){
                        grassCounter++;
                    }

                }
            }
            log_grass.write(String.format("%d\n", grassCounter));
        } catch (IOException e){
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
	}

	private void closeLogs(MyLog log_sheep, MyLog log_wolves, MyLog log_grass) {
		try {
            log_sheep.close();
            log_wolves.close();
            log_grass.close();
        } catch (IOException e){
            System.out.println("Error closing log files.");
            e.printStackTrace();
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