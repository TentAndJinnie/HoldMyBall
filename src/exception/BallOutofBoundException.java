package exception;

import logic.Ball;
import logic.Logic;
import main.Main;
import sharedObject.RenderableHolder;

public class BallOutofBoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8540921625212091254L;

	public BallOutofBoundException(int bound) {
		// TODO Auto-generated constructor stub
		Ball ball = Logic.getBall();
		switch (bound) {
		case 1: {
			ball.setX(560);
			ball.setxSpeed(-ball.getxSpeed());
			break;
		}
		case 2: {
			ball.setX(10);
			ball.setxSpeed(-ball.getxSpeed());
			break;
		}

		case 3: {
			Logic.setWallCount(Logic.getWallCount() - 1);
			ball.setY(10);
			ball.setySpeed(-ball.getySpeed());
			break;
		}
		case 4: {
			Main.onGame = false;
			Main.onStart = false;
			Main.onEnd = true;
			RenderableHolder.gameOver.play();
			break;
		}
		default: {
			throw new IllegalArgumentException("Unexpected value: " + bound);
		}
		}
	}
}
