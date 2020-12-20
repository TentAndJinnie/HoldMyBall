package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class NormalBrick extends Brick{
	
	public NormalBrick(int x, int y) {
		super(x, y);
		setColor(Color.web("D6FFDC"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(getColor());
		gc.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}

	@Override
	public void ability() {
		// TODO Auto-generated method stub
		if(Logic.getWallCount()==0) {
			RenderableHolder.normalBrickBreak.play();
		}
		setDestroyed(true);
	}

}
