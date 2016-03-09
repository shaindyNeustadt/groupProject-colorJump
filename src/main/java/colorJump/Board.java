package colorJump;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/*
 * double array - numbers, random generated
 * colors = number
 * 
 * need to keep track of start position and destination position
 * 
 * check all 4 directions:
 * if peg next to it exist and not same color
 * 	then check if one next to that 
 * 				put on stack
 * 				if exists and same color as previous 
 * 					then go to next and repeat
 * 				else if doesn't exist 
 * 					then possible move 
 * else 
 * 	check next direction
 * else 
 * 	if no possible moves in either direction 
 * 		then disable button
 * */

public class Board extends JPanel {
	private Peg[][] pegs;
	private Color[] colorArray;
	private Game game;
	private Peg fromPeg;
	private Peg toPeg; 

	public Board() {
		setLayout(new GridLayout(7, 7, 5, 5));
	colorArray = new Color[]{ null, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK};
	game = new Game();
	
	/*ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			if(fromPeg == null){
				fromPeg = (Peg) event.getSource();
				fromPeg.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
			}
			else{
				toPeg = (Peg) event.getSource();
				game.move(fromPeg.getX(), fromPeg.getY(), toPeg.getX(), toPeg.getY());
				System.out.println("MOVE FROM " + fromPeg.getX() + " " + fromPeg.getY());
				toPeg = fromPeg = null;
			}
			
			//lastPressed.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			//lastPressed = button;
		}
	};
		*/
		pegs = new Peg[7][7];
		for (int i = 0; i < pegs.length; i++) {
			for (int j = 0; j < pegs[0].length; j++) {
				Peg peg = pegs[i][j] = new Peg(colorArray[game.getValue(i, j)], i, j);
				add(peg);
			//	peg.addActionListener(listener);
			}
		}
		//setDisabled();
	}
	
	
	public void setDisabled(){
		for (int i = 0; i < pegs.length; i++) {
			for (int j = 0; j < pegs[0].length; j++) {
		pegs[i][j].setEnabled(game.isEnabled(i, j));
			}
		}
	}

}