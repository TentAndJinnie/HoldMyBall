package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class MultipleBrick extends Brick {
	public MultipleBrick(int x, int y) {
		super(x, y);
		setColor(Color.web("4D8A42"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(getColor());
		gc.fillRect(getX(), getY(), getWidth(), getHeight());
		gc.drawImage(RenderableHolder.multiplePic, getX()+2, getY(), 20, 20);

	}

	@Override
	public void ability() {
		// TODO Auto-generated method stub
		Logic.setMultipleTime(Logic.getMultipleTime() + 5);
		if(Logic.getWallCount()==0) {
			RenderableHolder.multipleBrickBreak.play();
		}
		setDestroyed(true);
	}

}
