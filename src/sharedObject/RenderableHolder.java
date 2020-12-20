package sharedObject;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import logic.Entity;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	private ArrayList<Entity> entities;
	public static AudioClip normalBrickBreak;
	public static AudioClip extendBrickBreak;
	public static AudioClip multipleBrickBreak;
	public static AudioClip shootingBrickBreak;
	public static AudioClip shrinkBrickBreak;
	public static AudioClip strongBrickBreak;
	public static AudioClip gameOver;
	public static AudioClip startScene;
	public static Image shrinkPic;
	public static Image extendPic;
	public static Image multiplePic;
	public static Image shootingPic;
	public static Image multiple2Pic;

	public RenderableHolder() {
		entities = new ArrayList<Entity>();
	}

	static {
		loadResource();
	}

	public static void loadResource() {
		normalBrickBreak = new AudioClip(ClassLoader.getSystemResource("NormalBrickBreak.wav").toString());
		extendBrickBreak = new AudioClip(ClassLoader.getSystemResource("ExtendBrickBreak.wav").toString());
		multipleBrickBreak = new AudioClip(ClassLoader.getSystemResource("MultipleBrickBreak.wav").toString());
		shrinkBrickBreak = new AudioClip(ClassLoader.getSystemResource("ShrinkBrickBreak.wav").toString());
		shootingBrickBreak = new AudioClip(ClassLoader.getSystemResource("ShootingBrickBreak.wav").toString());
		strongBrickBreak = new AudioClip(ClassLoader.getSystemResource("StrongBrickBreak.wav").toString());
		gameOver = new AudioClip(ClassLoader.getSystemResource("GameOver.wav").toString());
		startScene = new AudioClip(ClassLoader.getSystemResource("StartScene.wav").toString());
		shrinkPic = new Image(ClassLoader.getSystemResource("shrink.png").toString());
		extendPic = new Image(ClassLoader.getSystemResource("extend.png").toString());
		multiplePic = new Image(ClassLoader.getSystemResource("multiple.png").toString());
		shootingPic = new Image(ClassLoader.getSystemResource("Rocket.png").toString());
		multiple2Pic = new Image(ClassLoader.getSystemResource("multiple2.png").toString());
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed()) {
				entities.remove(i);
			}
		}

	}
}
