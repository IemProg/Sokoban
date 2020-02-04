public class Coup {
    /*
    pour stocker le couple représentant un coup
     */
	private Direction direction;
	private Position position;
	
	public Coup(Position position, Direction direction) {
		this.position=position;
		this.direction=direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Coup [direction=" + direction + ", position=" + position + "]";
	}
	
	
	
}
