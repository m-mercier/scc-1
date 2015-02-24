package src.simulation.grid;

import src.simulation.auxiliary.*;
import src.simulation.grid.grass.*;

public class GrassGrid {
	
	private int width;
	private int height;

	private MyRandom rand;
	private Grass[][] grassGrid;

	public GrassGrid(int width, int height) {
		this.width = width;
		this.height = height;
		rand = new MyRandom();
		grassGrid = new Grass[width][height];

		populateGrid();
	}

	private void populateGrid() {

		int grassGenProb = 50;

		//generate all the grass
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Grass newGrass = new Grass();
				if (rand.randInt(0, 100) < grassGenProb) {
					newGrass.setGrowth(30);
				} else {
					newGrass.setGrowth(rand.randInt(1, Grass.growthCap+1));
				}
				grassGrid[x][y] = newGrass;
			}
		}
	}

	public void growGrass() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				grassGrid[x][y].grow();
			}
		}
	}

	public Grass getGrass(int x, int y) {
		return grassGrid[x][y];
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
}