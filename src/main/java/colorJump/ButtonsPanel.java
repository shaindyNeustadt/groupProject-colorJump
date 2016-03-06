package colorJump;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel{
private JButton restart;
private JButton help;
private JLabel score;
private JLabel scoreNum;


public ButtonsPanel(){
	setLayout(new GridLayout(0,4));
	restart = new JButton("Restart");
	help = new JButton("Help");
	score = new JLabel("SCORE:");
	scoreNum = new JLabel("0");
	
	add(score);
	add(scoreNum);
	add(restart);
	add(help);
	
}
}
