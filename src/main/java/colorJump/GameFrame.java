package colorJump;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class GameFrame extends JFrame{	
	private ButtonsPanel buttonsPanel;
	private GamePanel gamePanel;

	public GameFrame(){
		setTitle("COLOR JUMP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(850, 650);
		setLayout(new BorderLayout());
		gamePanel = new GamePanel();
		buttonsPanel = new ButtonsPanel();

		Container container = getContentPane();
		container.add(gamePanel, BorderLayout.CENTER);
		container.add(buttonsPanel, BorderLayout.EAST);
	}

	public GamePanel getGame(){
		return gamePanel;
	}


	public static void main(String[] args){
		new GameFrame().setVisible(true);
	}
}
