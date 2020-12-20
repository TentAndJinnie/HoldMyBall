package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class StrongBrick extends Brick {
	private int hp = 1;
	
	public StrongBrick(int x, int y) {
		super(x, y);
		setColor(Color.web("AAAAAA"));
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
		if(hp > 0) {
			hp--;
			setColor(Color.web("85D976"));
			if(Logic.getWallCount()==0) {
				RenderableHolder.strongBrickBreak.play();
			}
		}else {
			if(Logic.getWallCount()==0) {
				RenderableHolder.normalBrickBreak.play();
			}
			setDestroyed(true);
		}
	}

}
