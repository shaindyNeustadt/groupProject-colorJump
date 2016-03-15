package colorJump;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameFrame extends JFrame {
	private ButtonsPanel buttonsPanel;
	private GamePanel gamePanel;

	public GameFrame() {
		setTitle("PEG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(850, 650);
		setLayout(new BorderLayout());
		gamePanel = new GamePanel(this);
		buttonsPanel = new ButtonsPanel(gamePanel);

		Container container = getContentPane();
		container.add(gamePanel, BorderLayout.CENTER);
		container.add(buttonsPanel, BorderLayout.EAST);
		JOptionPane
		.showMessageDialog(
				null,
				"Jump over balls of another color to empty the grid.\n"
						+ "Score additional points per ball jumped over.\n"
						+ "You may jump over one or more balls of the same color,\n with a ball of another color.\n"
						+ "Bonus: if you remove all balls but one, score is doubled!         \n"
						+ "Right click to clear selection.");
	}

	public GamePanel getGame() {
		return gamePanel;
	}

	public ButtonsPanel getButtonsPanel() {
		return buttonsPanel;
	}

	public static void main(String[] args) {
		new GameFrame().setVisible(true);
	}
}
