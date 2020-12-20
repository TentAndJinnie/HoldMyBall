package logic;

import javafx.scene.paint.Color;
import sharedObject.IRenderable;

public abstract class Entity implements IRenderable{
	private double x;
	private double y;
	private boolean destroyed;
	private int width;
	private int height;
	private Color color;
	
	public Entity(int x,int y) {
		this.x = x;
		this.y = y;
		this.destroyed = false;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y= y;
	}
	public boolean isDestroyed() {
		return destroyed;
	}
	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
}
