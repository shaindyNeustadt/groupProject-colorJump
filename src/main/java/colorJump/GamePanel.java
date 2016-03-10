package colorJump;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {
	private Color[] colorArray;
	private Board board;
	private Peg[][] pegs;
	private Peg fromPeg;
	private Peg toPeg;
	private int score;

	public GamePanel() {
		setLayout(new GridLayout(7, 7, 5, 5));

		colorArray = new Color[] { null, Color.RED, Color.ORANGE, Color.YELLOW,
				Color.GREEN, Color.BLUE, Color.PINK };
		board = new Board();
		pegs = new Peg[7][7];

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
				pegs[i][j].setEnabled(board.isEnabled(i, j));
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (fromPeg == null) {
			fromPeg = (Peg) event.getSource();
			fromPeg.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		} else {
			toPeg = (Peg) event.getSource();
			int points = board.move(fromPeg.getXLocation(), fromPeg.getYLocation(),
					toPeg.getXLocation(), toPeg.getYLocation());
			setScore(points);
			System.out.println("MOVE FROM " + fromPeg.getX() + " "
					+ fromPeg.getY());
			toPeg = fromPeg = null;
		}

		// lastPressed.setBorder(BorderFactory.createLineBorder(Color.BLACK,
		// 1));
		// lastPressed = button;

	}

	public void setScore(int points) {
		this.score += points;
	}

	private int getScore() {
		return score;
	}

}
