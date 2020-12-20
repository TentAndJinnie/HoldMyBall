package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class ShootingBrick extends Brick{
	public ShootingBrick(int x, int y) {
		super(x, y);
		setColor(Color.web("00FF00"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(getColor());
		gc.fillRect(getX(), getY(), getWidth(), getHeight());
		gc.drawImage(RenderableHolder.shootingPic, getX()+2, getY(), 20, 20);

	}

	@Override
	public void ability() {
		// TODO Auto-generated method stub
		Logic.setWallCount(Logic.getWallCount()+1);
		RenderableHolder.shootingBrickBreak.play();
		setDestroyed(true);
	}
	

}
