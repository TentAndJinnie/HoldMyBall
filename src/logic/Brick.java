package logic;

public abstract class Brick extends Entity{

	public Brick(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		setWidth(25);
		setHeight(20);
	}
	
	public abstract void ability();
}
