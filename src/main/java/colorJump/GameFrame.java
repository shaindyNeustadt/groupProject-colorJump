package colorJump;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
private Board board;	
private ButtonsPanel buttonsPanel;

	public GameFrame(){
	setTitle("COLOR JUMP");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(650, 650);
	setLayout(new BorderLayout());
	board = new Board();
	buttonsPanel = new ButtonsPanel();
	
	Container container = getContentPane();
	container.add(board, BorderLayout.CENTER);
	container.add(buttonsPanel, BorderLayout.EAST);
	}
}
