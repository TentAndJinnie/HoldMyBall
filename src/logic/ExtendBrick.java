package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class ExtendBrick extends Brick {
	
	public ExtendBrick(int x, int y) {
		super(x, y);
		setColor(Color.web("FFE785"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(getColor());
		gc.fillRect(getX(), getY(), getWidth(), getHeight());
		gc.drawImage(RenderableHolder.extendPic, getX()+2, getY(), 20, 20);

	}

	@Override
	public void ability() {
		// TODO Auto-generated method stub
		Plane oldPlane = Logic.getPlane();
		Plane newPlane = new Plane((int) oldPlane.getX(), (int) oldPlane.getY(), oldPlane.getWidth() + 20);
		
		Logic.setPlane(newPlane);
		RenderableHolder.getInstance().getEntities().remove(oldPlane);
		RenderableHolder.getInstance().getEntities().add(newPlane);
		
		if (Logic.isLeftClick()) {
			Logic.getPlane().moveLeft();
		} else if (Logic.isRightClick()) {
			Logic.getPlane().moveRight();
		}
		if(Logic.getWallCount()==0) {
			RenderableHolder.extendBrickBreak.play();
		}
		setDestroyed(true);
	}

}
