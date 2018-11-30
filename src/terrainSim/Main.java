package terrainSim;

import java.util.Scanner;
import java.util.Random;

public class Main {

	private static Scanner sc;
	
	public static void main(String[] Args) {

		
		int[][] desert = createDesert(10, 10);

		int px = findPX(desert);
		int py = findPY(desert);
		int gx = findGX(desert);
		int gy = findGY(desert);
		int vd = distance(px, gx);
		int hd = distance(py, gy);
		double dist = pythagoras(vd, hd);

		System.out.println("You wake up in the middle of a vast desert. \n" + "Try 'Look'.");

		look();
		System.out.println(
				"All that can be seen for miles in every direction are dunes of sand. Which way will you head?");
		String direction = direction();

		System.out.println("You walk " + direction
				+ " for about ten meters before noticing a small device strapped to your wrist. It displays the number "
				+ dist + ". \n Try 'North', 'South', 'East', 'West'");

	}

	public static int[][] createDesert(int width, int height) {
		int[][] desert = new int[width][height];
		Random random = new Random();

		int pStartX = random.nextInt(width);
		int pStartY = random.nextInt(height);
		int goalX = random.nextInt(width);
		int goalY = random.nextInt(height);

		desert[pStartX][pStartY] = 1;
		desert[goalX][goalY] = 2;

		return desert;
	}

	public static void look() {

		String input = null;

		sc = new Scanner(System.in);
		while (true) {
		
			input = sc.nextLine();
			if (input.equals("Look")) {
				break;
			} else {
				System.out.println("Try 'Look'.");
			}
		}

	}

	public static int distance(int one, int two) {
		if (one > two) {
			return one - two;
		} else if (two > one) {
			return two - one;
		} else {
			return 0;
		}
	}

	public static int findPX(int[][] desert) {

		int x = 0;
		for (int[] i : desert) {
			x = 0;
			for (int j : i) {
				x++;
				if (j == 1) {
					return x;
				}
			}
		}
		return 0;
	}

	public static int findPY(int[][] desert) {
		int x = 0;
		for (int[] i : desert) {
			x++;
			for (int j : i) {
				if (j == 1) {
					return x;
				}
			}
		}
		return 0;
	}

	public static int findGX(int[][] desert) {

		int x = 0;
		for (int[] i : desert) {
			x = 0;
			for (int j : i) {
				x++;
				if (j == 2) {
					return x;
				}
			}
		}
		return 0;
	}

	public static int findGY(int[][] desert) {
		int x = 0;
		for (int[] i : desert) {
			x++;
			for (int j : i) {
				if (j == 2) {
					return x;
				}
			}
		}
		return 0;
	}

	public static double pythagoras(int a, int b) {
		int asq = a * a;
		int bsq = b * b;
		int csq = asq + bsq;
		double c = Math.sqrt(csq);
		return c;
	}

	public static void move(String direction) {

	}

	public static String direction() {

		String direction = null;

		while (true) {
			direction = sc.nextLine();
			if (direction.equals("North") || direction.equals("South") || direction.equals("East")
					|| direction.equals("West")) {
				sc.close();
				return direction;
			} else { System.out.println("Invalid direction, try again.");
			}
		}
	}
}
