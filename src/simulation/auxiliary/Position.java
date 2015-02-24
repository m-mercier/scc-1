package src.simulation.auxiliary;

public class Position {

	private int xCoord;
	private int yCoord;

	public Position(int xCoord, int yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	public void setX(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getX() {
		return this.xCoord;
	}

	public void setY() {
		this.yCoord = yCoord;
	}

	public int getY() {
		return this.yCoord;
	}

	public static Position Add(Position... positions) {
		int tempX = 0;
		int tempY = 0;

		for (Position position : positions) {
			tempX += position.getX();
			tempY += position.getY();
		}
		return (new Position(tempX, tempY));
	}
}