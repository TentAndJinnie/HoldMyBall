package logic;

import java.util.ArrayList;
import java.util.Random;

public class GameMap {
	private static ArrayList<Integer> brickType = new ArrayList<Integer>();

	public static void numberGenerate() {
		brickType = new ArrayList<Integer>();
		ArrayList<Integer> slotInteger = new ArrayList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 184; i++) {
			slotInteger.add(i);
		}
		for (int i = 0; i < 184; i++) {
			brickType.add(0);
		}

		for (int i = 0; i < 5; i++) {
			boolean found = false;
			while (!found) {
				int slot = rand.nextInt(184);
				if (slotInteger.indexOf(slot) != -1) {
					slotInteger.set(slot, 176);
					brickType.set(slot, 1);
					found = true;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			boolean found = false;
			while (!found) {
				int slot = rand.nextInt(184);
				if (slotInteger.indexOf(slot) != -1) {
					slotInteger.set(slot, 176);
					brickType.set(slot, 2);
					found = true;
				}
			}
		}

		for (int i = 0; i < 8; i++) {
			boolean found = false;
			while (!found) {
				int slot = rand.nextInt(184);
				if (slotInteger.indexOf(slot) != -1) {
					slotInteger.set(slot, 176);
					brickType.set(slot, 3);
					found = true;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			boolean found = false;
			while (!found) {
				int slot = rand.nextInt(184);
				if (slotInteger.indexOf(slot) != -1) {
					slotInteger.set(slot, 176);
					brickType.set(slot, 4);
					found = true;
				}
			}
		}
		for (int i = 0; i < 20; i++) {
			boolean found = false;
			while (!found) {
				int slot = rand.nextInt(176);
				if (slotInteger.indexOf(slot) != -1) {
					slotInteger.set(slot, 176);
					brickType.set(slot, 5);
					found = true;
				}
			}
		}

	}

	public static void genMap() {
		numberGenerate();
		for (int slot = 0; slot < 184; slot++) {
			Brick brick = generateBrick(slot, brickType.get(slot));
			Logic.addEntity(brick);
		}
	}

	public static Brick generateBrick(int slot, int brickType) {
		switch (brickType) {
		case 0: {
			Brick brick = new NormalBrick(2 + 26 * (slot % 23), 5 + 21 * (slot / 23));
			return brick;
		}
		case 1: {
			Brick brick = new ExtendBrick(2 + 26 * (slot % 23), 5 + 21 * (slot / 23));
			return brick;
		}
		case 2: {
			Brick brick = new ShrinkBrick(2 + 26 * (slot % 23), 5 + 21 * (slot / 23));
			return brick;
		}
		case 3: {
			Brick brick = new MultipleBrick(2 + 26 * (slot % 23), 5 + 21 * (slot / 23));
			return brick;
		}
		case 4: {
			Brick brick = new ShootingBrick(2 + 26 * (slot % 23), 5 + 21 * (slot / 23));
			return brick;
		}
		case 5: {
			Brick brick = new StrongBrick(2 + 26 * (slot % 23), 5 + 21 * (slot / 23));
			return brick;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + slot);
		}

	}

}
