package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Plane extends Entity{
	private int planeSpeed;

	public Plane(int x, int y,int width) {
		super(x, y);
		setWidth(width);
		setHeight(15);
		setColor(Color.web("9453FF"));
		setPlaneSpeed(0);
	}

	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(getColor());
		
		this.setX(getX()+getPlaneSpeed());
		gc.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public void moveLeft() {
		if(this.getX()<10) {
			setPlaneSpeed(0);
		}
		else {
			setPlaneSpeed(-10);
		}
	}
	
	public void moveRight() {
		if(this.getX()>600-getWidth()-10) {
			setPlaneSpeed(0);
		}
		else {
			setPlaneSpeed(10);
		}
	}


	public int getPlaneSpeed() {
		return planeSpeed;
	}


	public void setPlaneSpeed(int planeSpeed) {
		this.planeSpeed = planeSpeed;
	}


	
}
