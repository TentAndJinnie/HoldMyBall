package drawing;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class StartScene extends Scene {
	
	public StartScene(VBox vbox) {
		
		super(vbox,Main.WIDTH,Main.HEIGHT);
		
		String image_path = ClassLoader.getSystemResource("HMB.PNG").toString();
		ImageView imageView = new ImageView(new Image(image_path));
		imageView.setFitHeight(250);
		imageView.setFitWidth(250);
		
		Button btnExit = new Button("EXIT");
		btnExit.setPrefWidth(180);
		btnExit.setPrefHeight(40);
		btnExit.setStyle(
				"-fx-text-fill: #003333; -fx-font-weight: bold; -fx-font-family: \"Swiss 721 Black Condensed BT\"; -fx-background-color: #03EAB3;-fx-font-size:30;  ");
		btnExit.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Main.onGame = false;
				Main.onStart = false;
				Main.onEnd = false;
			}
		});

		btnExit.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				btnExit.setStyle(
						"-fx-text-fill: #D30316; -fx-font-weight: bold; -fx-font-family: \"Swiss 721 Black Condensed BT\"; -fx-background-color: #A2EAE1;-fx-font-size:30; ");
			}
		});
		btnExit.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				btnExit.setStyle(
						"-fx-text-fill: #003333; -fx-font-weight: bold; -fx-font-family: \"Swiss 721 Black Condensed BT\"; -fx-background-color: #03EAB3;-fx-font-size:30; ");
			}
		});

		Button btnPlay = new Button("PLAY");
		btnPlay.setPrefWidth(180);
		btnPlay.setPrefHeight(40);
		btnPlay.setStyle(
				"-fx-text-fill: #003333; -fx-font-weight: bold; -fx-font-family: \"Swiss 721 Black Condensed BT\"; -fx-background-color: #03EAB3;-fx-font-size:30; ");
		btnPlay.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Main.onStart = false;
				Main.onGame = true;
				Main.onEnd = false;
			}
		});
		btnPlay.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				btnPlay.setStyle(
						"-fx-text-fill: #D30316; -fx-font-weight: bold; -fx-font-family: \"Swiss 721 Black Condensed BT\"; -fx-background-color: #A2EAE1;-fx-font-size:30; ");
			}
		});
		btnPlay.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				btnPlay.setStyle(
						"-fx-text-fill: #003333; -fx-font-weight: bold; -fx-font-family: \"Swiss 721 Black Condensed BT\"; -fx-background-color: #03EAB3;-fx-font-size:30;");
			}
		});
		
		HBox Buttons = new HBox(btnPlay, btnExit);		
		HBox.setMargin(btnPlay, new Insets(5, 50, 0, 20));
		HBox.setMargin(btnExit, new Insets(5, 0, 0, 0));
		
		vbox.getChildren().addAll(imageView, Buttons);
		
		vbox.setPadding(new Insets(80));
		vbox.setFillWidth(true);
		vbox.setSpacing(70);
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #003333");
		
		
	}

}