package main;

import drawing.GameScene;
import drawing.StartScene;
import exception.BallOutofBoundException;
import exception.PlaneMoveFailedException;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.Logic;
import sharedObject.RenderableHolder;



public class Main extends Application {
	public static final int WIDTH = 600;
	public static final int HEIGHT = 650;
	public static boolean onStart = true;
	public static boolean onGame = false;
	public static boolean onEnd = false;
	private StartScene startScene;
	private GameScene gameScene;

	@Override
	public void start(Stage primaryStage) throws PlaneMoveFailedException,BallOutofBoundException {

		// TODO Auto-generated method stub
		VBox startVBox = new VBox();
		startScene = new StartScene(startVBox);
		StackPane gameStackPane = new StackPane();
		gameScene = new GameScene(gameStackPane);

		primaryStage.setResizable(false);
		primaryStage.setTitle("Hold My Ball starts!");
		primaryStage.show();
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				
				if(onStart) {
					Logic.setCurrentScene(startScene);
					if(!RenderableHolder.startScene.isPlaying()) {
						RenderableHolder.startScene.play();
					}
					
				}
				if(onGame) {
					RenderableHolder.startScene.stop();
					RenderableHolder.gameOver.stop();
					Logic.setCurrentScene(gameScene);
	
					gameScene.paintComponent();
					try {
						Logic.logicUpdate();
					} catch (PlaneMoveFailedException e) {
						// Do nothing
					} catch (BallOutofBoundException e) {
						// Do nothing
					}
					RenderableHolder.getInstance().update();
				}
				if(onEnd) {
					gameScene.paintComponent();
				}
				primaryStage.setScene(Logic.getCurrentScene());
				if(!onGame & !onStart & !onEnd) {
					primaryStage.close();
				}
			}
		};
		animation.start();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
