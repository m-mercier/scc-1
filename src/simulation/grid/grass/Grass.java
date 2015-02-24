public class Grass {
	
	private static final int growthCap = 30;
	private int growth;
	
	public Grass() {
		this.growth = 0;
	}

	public int getGrowth(int growth) {
		return this.getGrowth;
	}

	public void setGrwoth() {
		this.growth = growth;
	}

	public void grow() {
		this.growth += (this.growth < 30) ? 1 : 0;
	}
}