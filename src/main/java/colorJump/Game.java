package colorJump;

import java.util.Random;

public class Game {
	private int[][] numbers;
	private Random random;
	private int score;
		
	public Game() {
		newGame();
	}

	public void newGame() {
		numbers = new int[7][7];
		random = new Random();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[0].length; j++) {
				// 6 different colors and 0 = null
				numbers[i][j] = random.nextInt(7);
			}
		}
	}

	public int getValue(int x, int y) {
		return numbers[x][y];
	}

	public void move(int fromX, int fromY, int toX, int toY){
		numbers[toX][toY] = numbers[fromX][fromY];
		numbers[fromX][fromY] = 0;
		
		int dif;
		if(toX == fromX){
			dif = Math.abs(fromY - toY);
		}
		else{
			dif = Math.abs(fromX - toX);
		}
		
		switch(dif){
		case 1:
			score += 10;
			break;
		case 2:
			score += 40;
			break;
		case 3:
			score += 130;
			break;
		case 4:
			score += 400;
			break;
		case 5:
			score += 700;
			break;
		}
	}
	
	private int getScore(){
			return score;
	}
	
	
	public boolean isEnabled(int x, int y) {
		/*
		 * check all 4 directions: if peg next to it exist and not same color
		 * then check if one next to that put on stack if exists and same color
		 * as previous then go to next and repeat else if doesn't exist then
		 * possible move else check next direction else if no possible moves in
		 * either direction then disable button
		 */
		int currColor = numbers[x][y];
		int jumpOverColor;
		int currX = x;
		int currY = y;

		if (currColor == 0) {
			return true;
		}
		// right
		if (y + 1 < numbers[0].length
				&& currColor != (jumpOverColor = numbers[x][y + 1])
				&& jumpOverColor != 0) {
			while (y + 1 < numbers[0].length
					&& (jumpOverColor == numbers[x][y + 1] || numbers[x][y + 1] == 0)) {
				y++;
				if (numbers[x][y] == 0) {
					System.out.println("Right enable " + currX + " : " + currY
							+ " Because of " + x + " : " + y);
					return true;
				}
			}
		}
		// left
		y = currY;
		x = currX;
		if (y > 0 && currColor != (jumpOverColor = numbers[x][y - 1])
				&& jumpOverColor != 0) {
			while (y > 0
					&& (jumpOverColor == numbers[x][y - 1] || numbers[x][y - 1] == 0)) {
				y--;
				if (numbers[x][y] == 0) {
					System.out.println("Left enable " + currX + " : " + currY
							+ " Because of " + x + " : " + y);
					return true;
				}
			}
		}
		// up
		y = currY;
		x = currX;
		if (x > 0 && currColor != (jumpOverColor = numbers[x - 1][y])
				&& jumpOverColor != 0) {
			while (x > 0
					&& (jumpOverColor == numbers[x - 1][y] || numbers[x - 1][y] == 0)) {
				x--;
				if (numbers[x][y] == 0) {
					System.out.println("Up enable " + currX + " : " + currY
							+ " Because of " + x + " : " + y);
					return true;
				}
			}
		}
		// down
		y = currY;
		x = currX;
		if (x + 1 < numbers.length
				&& currColor != (jumpOverColor = numbers[x + 1][y])
				&& jumpOverColor != 0) {
			while (x + 1 < numbers.length
					&& (jumpOverColor == numbers[x + 1][y] || numbers[x + 1][y] == 0)) {
				x++;
				if (numbers[x][y] == 0) {
					System.out.println("Down enable " + currX + " : " + currY
							+ " Because of " + x + " : " + y);
					return true;
				}
			}
		}
		return false;
	}
}
