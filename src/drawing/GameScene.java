package drawing;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.Entity;
import logic.Logic;
import main.Main;
import sharedObject.RenderableHolder;

public class GameScene extends Scene {

	public GraphicsContext gc;

	public GameScene(StackPane stackPane) {
		// TODO Auto-generated constructor stub
		
		super(stackPane, Main.WIDTH, Main.HEIGHT);
		
		Canvas canvas = new Canvas(Main.WIDTH, Main.HEIGHT);
		gc = canvas.getGraphicsContext2D();
		stackPane.setBackground(new Background(new BackgroundFill(Color.web("003333"), null, null)));
		stackPane.getChildren().add(canvas);
		setKey();

	}

	public void setKey() {

		this.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.LEFT && Main.onGame) {
				Logic.getPlane().moveLeft();
				Logic.setLeftClick(true);
				Logic.setRightClick(false);
			} else if (e.getCode() == KeyCode.RIGHT && Main.onGame) {
				Logic.getPlane().moveRight();
				Logic.setLeftClick(false);
				Logic.setRightClick(true);
			} else if (e.getCode() == KeyCode.SPACE && !(Main.onGame)) {
				Main.onStart = false;
				Main.onGame = true;
				Main.onEnd = false;
				Logic.resetLogic();
			} else if (e.getCode() == KeyCode.ESCAPE && !(Main.onGame)) {
				Main.onStart = false;
				Main.onGame = false;
				Main.onEnd = false;
			}
		});

	}

	public void paintComponent() {
		// TODO Auto-generated method stub

		if (Main.onGame) {
			gc.clearRect(0, 0, 600, 650);
			for (Entity entity : RenderableHolder.getInstance().getEntities()) {
				entity.draw(gc);
			}
			Font theFont = Font.font("Swiss 721 Black Condensed BT", FontWeight.BOLD, 30);
			gc.setFont(theFont);
			gc.setFill(Color.LIGHTGREY);
			gc.fillText("Highscore: " + String.valueOf(Logic.getHighScore()), 10, 640);
			if(Logic.getMultipleTime()>0) {
				gc.drawImage(RenderableHolder.multiple2Pic, 370, 610,40,40);
			}
			gc.fillText("Score: " + String.valueOf(Logic.getScore()), 420, 640);
			if(Logic.getWallCount()>0) {
				Logic.getBall().setColor(Color.web("EE4555"));
			}else if(Logic.getWallCount()==0) {
				Logic.getBall().setColor(Color.web("E8DAFF"));
			}
		} else if (Main.onEnd) {
			Font theFont = Font.font("Swiss 721 Black Condensed BT", FontWeight.BOLD, 40);
			gc.setFont(theFont);

			gc.setLineWidth(2);
			gc.setFill(Color.ALICEBLUE);
			if (Logic.isWin()) {
				gc.fillText("Win!", 260, 300);
			} else {
				gc.fillText("Game Over", 200, 300);
			}
			int score = Logic.getScore();
			if(score<10) {
				gc.fillText(String.valueOf(score), 290, 350);
			}else if(score<100) {
				gc.fillText(String.valueOf(score), 280, 350);
			}else if(score<1000) {
				gc.fillText(String.valueOf(score), 270, 350);
			}else {
				gc.fillText(String.valueOf(score), 260, 350);
			}
			
			theFont = Font.font("Swiss 721 Black Condensed BT", FontWeight.BOLD, 20);
			gc.setFont(theFont);
			gc.fillText("Press SPACE to play again.", 185, 400);
			gc.fillText("Press ESC to exit.", 225, 430);
		}
	}

}
