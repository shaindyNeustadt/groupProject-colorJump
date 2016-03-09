package colorJump;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Board extends JPanel {
	private Peg[][] pegs;
	private Color[] colorArray;
	private Game game;
	private Peg fromPeg;
	private Peg toPeg;

	public Board() {
		setLayout(new GridLayout(7, 7, 5, 5));
		colorArray = new Color[] { null, Color.RED, Color.ORANGE, Color.YELLOW,
				Color.GREEN, Color.BLUE, Color.PINK };
		game = new Game();

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (fromPeg == null) {
					fromPeg = (Peg) event.getSource();
					fromPeg.setBorder(BorderFactory.createLineBorder(
							Color.BLACK, 3));
				//	setOpenSpots();
				} else {
					toPeg = (Peg) event.getSource();
					game.move(fromPeg.getMyX(), fromPeg.getMyY(),
							toPeg.getMyX(), toPeg.getMyY());
					toPeg.setColor(fromPeg.getColor());
					fromPeg.setColor(null);
					System.out.println("MOVE FROM " + fromPeg.getMyX() + " "
							+ fromPeg.getMyY());
					fromPeg = null;
					setDisabled();
				}
			}
		};

		pegs = new Peg[7][7];
		for (int i = 0; i < pegs.length; i++) {
			for (int j = 0; j < pegs[0].length; j++) {
				Peg peg = pegs[i][j] = new Peg(colorArray[game.getValue(i, j)],
						i, j);
				add(peg);
				peg.addActionListener(listener);
			}
		}
		setDisabled();
	}

	public void setDisabled() {
		for (int i = 0; i < pegs.length; i++) {
			for (int j = 0; j < pegs[0].length; j++) {
				pegs[i][j].setEnabled(game.isEnabled(i, j));
			}
		}
	}
	
	private void setOpenSpots(int x, int y){
	
	}

}