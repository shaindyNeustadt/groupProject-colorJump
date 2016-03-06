package colorJump;

import java.awt.GridLayout;

import javax.swing.JComponent;

public class Board extends JComponent{
Peg[][] pegs;

public Board(){
	
	pegs = new Peg[7][7];
	setLayout(new GridLayout(7,7));
}
}
