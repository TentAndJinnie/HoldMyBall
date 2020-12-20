package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball extends Entity {
	private double xSpeed;
	private double ySpeed;

	public Ball(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub.
		setxSpeed(8);
		setySpeed(7.2);
		setWidth(20);
		setHeight(20);
		setColor(Color.web("E8DAFF"));
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(getColor());
		gc.fillOval(getX(), getY(), getWidth(), getHeight());
	}

	public double getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	public double getySpeed() {
		return ySpeed;
	}

	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}

}
