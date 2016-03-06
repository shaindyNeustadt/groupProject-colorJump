package colorJump;

import java.awt.GridLayout;

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
	Peg[][] pegs;

	public Board() {
		setLayout(new GridLayout(7, 7, 5, 5));

		pegs = new Peg[7][7];
		for (int i = 0; i < pegs.length; i++) {
			for (int j = 0; j < pegs[0].length; j++) {
				Peg peg = pegs[i][j] = new Peg();
				add(peg);
			}
		}
	}
}
