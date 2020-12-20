package logic;

import java.util.Random;

import exception.BallOutofBoundException;
import exception.PlaneMoveFailedException;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import main.Main;
import sharedObject.RenderableHolder;

public class Logic {

	private static Scene currentScene;
	private static boolean isWin = false;
	private static Ball ball;
	private static Plane plane;
	private static int score;
	private static int highScore;
	private static boolean leftClick = false;
	private static boolean rightClick = false;
	private static int multipleTime;
	private static int wallCount;
	private static int brickBreak;

	public Logic() {
		resetLogic();
	}

	static {
		new Logic();
	}

	public static boolean checkIntersect(Entity entity1, Entity entity2) {
		Rectangle2D ballRect = new Rectangle2D(entity1.getX(), entity1.getY(), entity1.getWidth(), entity1.getHeight());
		Rectangle2D brickRect = new Rectangle2D(entity2.getX(), entity2.getY(), entity2.getWidth(), entity2.getHeight());
		if (ballRect.intersects(brickRect)) {
			if (wallCount == 0) {
				ball.setySpeed(-ball.getySpeed());
			}
			return true;
		}
		return false;
	}

	public static void logicUpdate() throws PlaneMoveFailedException,BallOutofBoundException {
		Rectangle2D ballRect = new Rectangle2D(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
		Rectangle2D planeRect = new Rectangle2D(plane.getX(), plane.getY(), plane.getWidth(), 1);
		Rectangle2D planeLeft = new Rectangle2D(plane.getX(), plane.getY() + 1, 1, plane.getHeight() - 1);
		Rectangle2D planeRight = new Rectangle2D(plane.getX() + plane.getWidth() - 1, plane.getY() + 1, 1, plane.getHeight() - 1);

		if (ballRect.intersects(planeRect)) {
			Random rand = new Random();
			if (ball.getxSpeed() > 0) {
				ball.setxSpeed(rand.nextInt(4) + rand.nextDouble() + 5);

			} else {
				ball.setxSpeed(-(rand.nextInt(4) + rand.nextDouble() + 5));
			}
			ball.setySpeed(-(rand.nextInt(4) + rand.nextDouble() + 5));

		} else if (ballRect.intersects(planeLeft)) {
			Random rand = new Random();
			ball.setxSpeed(-(rand.nextInt(4) + rand.nextDouble() + 5));
			ball.setySpeed(-(rand.nextInt(4) + rand.nextDouble() + 5));

		} else if (ballRect.intersects(planeRight)) {
			Random rand = new Random();
			ball.setxSpeed(rand.nextInt(4) + rand.nextDouble() + 5);
			ball.setySpeed(-(rand.nextInt(4) + rand.nextDouble() + 5));
		}
		if (ball.getX() > 570) {
			throw new BallOutofBoundException(1);
		}
		if (ball.getX() < 0) {
			throw new BallOutofBoundException(2);
		}
		if (ball.getY() < 0) {
			throw new BallOutofBoundException(3);
		}
		if (ball.getY() > 650) {
			throw new BallOutofBoundException(4);
		}
		if (brickBreak == 184) {
			RenderableHolder.gameOver.play();
			setWin(true);
			Main.onGame = false;
			Main.onStart = false;
			Main.onEnd = true;
		}
		if (getWallCount() < 0) {
			setWallCount(0);
		}
		ball.setX(ball.getX() + ball.getxSpeed());
		ball.setY(ball.getY() + ball.getySpeed());
		if (plane.getX() < 0 ||plane.getX() > 600 - plane.getWidth()) {
			throw new PlaneMoveFailedException();
		}
		

		for (Entity entity : RenderableHolder.getInstance().getEntities()) {
			if (entity instanceof Brick) {
				if (checkIntersect(ball, entity)) {
					((Brick) entity).ability();
					if (entity.isDestroyed()) {
						if(multipleTime > 0) {
							multipleTime--;
							score += 10;
						}
						score += 10;
						brickBreak++;
					}
					if (highScore < score) {
						setHighScore(score);
					}
					break;

				}
			}
		}

	}

	public static void addEntity(Entity entity) {
		RenderableHolder.getInstance().getEntities().add(entity);
	}

	public static void resetLogic() {
		RenderableHolder.getInstance().getEntities().clear();
		score = 0;
		multipleTime = 0;
		wallCount = 0;
		brickBreak = 0;
		ball = new Ball(20, 300);
		addEntity(ball);
		plane = new Plane(225, 550, 125);
		addEntity(plane);
		setWin(false);
		setLeftClick(false);
		setRightClick(false);
		GameMap.genMap();
	}

	public static Plane getPlane() {
		return Logic.plane;
	}

	public static void setPlane(Plane plane) {
		Logic.plane = plane;
	}

	public static Ball getBall() {
		return Logic.ball;
	}

	public static int getScore() {
		return score;
	}

	public static void setScore(int score) {
		Logic.score = score;
	}

	public static int getHighScore() {
		return highScore;
	}

	public static void setHighScore(int highScore) {
		Logic.highScore = highScore;
	}

	public static boolean isWin() {
		return isWin;
	}

	public static void setWin(boolean isWin) {
		Logic.isWin = isWin;
	}

	public static int getMultipleTime() {
		return multipleTime;
	}

	public static void setMultipleTime(int multipleTime) {
		Logic.multipleTime = multipleTime;
	}

	public static int getWallCount() {
		return wallCount;
	}

	public static void setWallCount(int wallCount) {
		Logic.wallCount = wallCount;
	}
	public static boolean isLeftClick() {
		return leftClick;
	}

	public static void setLeftClick(boolean leftClick) {
		Logic.leftClick = leftClick;
	}

	public static boolean isRightClick() {
		return rightClick;
	}

	public static void setRightClick(boolean rightClick) {
		Logic.rightClick = rightClick;
	}

	public static Scene getCurrentScene() {
		return currentScene;
	}

	public static void setCurrentScene(Scene currentScene) {
		Logic.currentScene = currentScene;
	}


}
