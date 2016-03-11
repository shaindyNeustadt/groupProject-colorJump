package colorJump;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {
	private Color[] colorArray;
	private Board board;
	private Peg[][] pegs;
	private Peg fromPeg;
	private Peg toPeg;
	private int score;
	private GameFrame gameFrame;

	public GamePanel(GameFrame gameFrame) {
		setLayout(new GridLayout(7, 7, 5, 5));
		this.gameFrame = gameFrame;
		colorArray = new Color[] { null, Color.RED, Color.YELLOW,
				Color.GREEN, Color.BLUE, 
				new Color(255, 0, 127),
				new Color(255, 128, 0) };
		board = new Board();
		pegs = new Peg[7][7];
		//orange 255, 128, 0     
		//purple new Color,(127, 0, 255) 
		for (int i = 0; i < pegs.length; i++) {
			for (int j = 0; j < pegs[0].length; j++) {
				Peg peg = pegs[i][j] = new Peg(
						colorArray[board.getValue(i, j)], i, j);
				add(peg);
				peg.addActionListener(this);
			}
		}
		setDisabled();
	}

	public void setDisabled() {
		for (int i = 0; i < pegs.length; i++) {
			for (int j = 0; j < pegs[0].length; j++) {
				pegs[i][j].setEnabled(isEnabled(i, j));
			}
		}
	}


	public void actionPerformed(ActionEvent event) {
		if (fromPeg == null) {
			fromPeg = (Peg) event.getSource();
			disableAll();
			setOpenSpots(fromPeg.getXLocation(), fromPeg.getYLocation());
		} else {
			toPeg = (Peg) event.getSource();
			toPeg.setColor(fromPeg.getColor());
			int points = board.move(fromPeg.getXLocation(),
					fromPeg.getYLocation(), toPeg.getXLocation(),
					toPeg.getYLocation());
			removeSpots(fromPeg.getXLocation(), fromPeg.getYLocation(),
					toPeg.getXLocation(), toPeg.getYLocation());
			setScore(points);
			fromPeg = null;
			setDisabled();
		}

		gameOver();
	}

	private void gameOver() {
		boolean moreMoves = false;
		for (int i = 0; i < pegs.length; i++) {
			for (int j = 0; j < pegs[0].length; j++) {
				if(pegs[i][j].isEnabled()){
					moreMoves = true;
					break;
				}
			}
		}

		if(!moreMoves){
			GameOver gameOver = new GameOver();
		}

	}

	public void setScore(int points) {
		this.score += points;
		gameFrame.getButtonsPanel().setScore(score);
	}

	public void resetScore(){
		score = 0;
	}
	public boolean isEnabled(int x, int y) {
		/*
		 * check all 4 directions: if peg next to it exist and not same color
		 * then check if one next to that put on stack if exists and same color
		 * as previous then go to next and repeat else if doesn't exist then
		 * possible move else check next direction else if no possible moves in
		 * either direction then disable button
		 */
		Color currColor = pegs[x][y].getColor();
		if (currColor == null) {
			return false;
		}
		return (checkRight(x, y, false) || checkLeft(x, y, false)
				|| checkUp(x, y, false) || checkDown(x, y, false));
	}

	private void setOpenSpots(int x, int y) {
		checkRight(x, y, true);
		checkLeft(x, y, true);
		checkUp(x, y, true);
		checkDown(x, y, true);
	}

	private boolean checkRight(int x, int y, boolean openSpot) {
		Color currColor = pegs[x][y].getColor();
		Color jumpOverColor;
		if (y + 1 < pegs[0].length
				&& currColor != (jumpOverColor = pegs[x][y + 1].getColor())
				&& jumpOverColor != null) {
			while (y + 1 < pegs[0].length
					&& (jumpOverColor == pegs[x][y + 1].getColor() || pegs[x][y + 1]
							.getColor() == null)) {
				y++;
				if (pegs[x][y].getColor() == null) {
					if (openSpot) {
						pegs[x][y].setEnabled(true);
					}
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkLeft(int x, int y, boolean openSpot) {
		Color currColor = pegs[x][y].getColor();
		Color jumpOverColor;
		if (y > 0 && currColor != (jumpOverColor = pegs[x][y - 1].getColor())
				&& jumpOverColor != null) {
			while (y > 0
					&& (jumpOverColor == pegs[x][y - 1].getColor() || pegs[x][y - 1]
							.getColor() == null)) {
				y--;
				if (pegs[x][y].getColor() == null) {
					if (openSpot) {
						pegs[x][y].setEnabled(true);
					}
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkUp(int x, int y, boolean openSpot) {
		Color currColor = pegs[x][y].getColor();
		Color jumpOverColor;
		if (x > 0 && currColor != (jumpOverColor = pegs[x - 1][y].getColor())
				&& jumpOverColor != null) {
			while (x > 0
					&& (jumpOverColor == pegs[x - 1][y].getColor() || pegs[x - 1][y]
							.getColor() == null)) {
				x--;
				if (pegs[x][y].getColor() == null) {
					if (openSpot) {
						pegs[x][y].setEnabled(true);
					}
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkDown(int x, int y, boolean openSpot) {
		Color currColor = pegs[x][y].getColor();
		Color jumpOverColor;
		if (x + 1 < pegs.length
				&& currColor != (jumpOverColor = pegs[x + 1][y].getColor())
				&& jumpOverColor != null) {
			while (x + 1 < pegs.length
					&& (jumpOverColor == pegs[x + 1][y].getColor() || pegs[x + 1][y]
							.getColor() == null)) {
				x++;
				if (pegs[x][y].getColor() == null) {
					if (openSpot) {
						pegs[x][y].setEnabled(true);
					}
					return true;
				}
			}
		}
		return false;
	}

	private void disableAll() {
		for (int i = 0; i < pegs.length; i++) {
			for (int j = 0; j < pegs[0].length; j++) {
				pegs[i][j].setEnabled(false);
			}
		}
	}

	private void removeSpots(int fromX, int fromY, int toX, int toY) {
		// code goes here to set the color to null in the jumped over spots
		if (fromX == toX) {
			// left
			if (fromY > toY) {
				for (int i = toY + 1; i <= fromY; i++) {
					pegs[fromX][i].setColor(null);
				}
			}
			// right
			else {
				for (int i = fromY; i < toY; i++) {
					pegs[fromX][i].setColor(null);
				}
			}
		} else {
			// up
			if (fromX > toX) {
				for (int i = toX + 1; i <= fromX; i++) {
					pegs[i][fromY].setColor(null);
				}
			}
			// down
			else {
				for (int i = fromX; i < toX; i++) {
					pegs[i][fromY].setColor(null);
				}
			}
		}
	}

	public void restart(){
		board.newGame();
		for (int i = 0; i < pegs.length; i++) {
			for (int j = 0; j < pegs[0].length; j++) {
				pegs[i][j].setColor(colorArray[board.getValue(i, j)]);
				//	peg.addActionListener(this);
			}
		}
		setDisabled();
	}
}