package colorJump;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ButtonsPanel extends JPanel {
	private JButton restart;
	private JButton help;
	private JLabel score;
	private JLabel scoreNum;
	private GamePanel gamePanel;

	public ButtonsPanel(final GamePanel gamePanel) {
		setLayout(new GridLayout(4, 0));
		Dimension d = new Dimension(200, 650);
		this.setPreferredSize(d);
		this.setMaximumSize(d);
		this.setMinimumSize(d);

		this.gamePanel = gamePanel;
		Font customFont = new Font("Serif", Font.BOLD, 50);

		restart = new JButton("Restart");
		restart.setFont(customFont);
		help = new JButton("Help");
		help.setFont(customFont);
		score = new JLabel("SCORE:", SwingConstants.CENTER);
		score.setFont(customFont);
		scoreNum = new JLabel("0", SwingConstants.CENTER);
		scoreNum.setFont(customFont);

		add(score);
		add(scoreNum);
		add(restart);
		add(help);

		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gamePanel.restart();
				setScore(0);
				gamePanel.resetScore();
			}
		});

		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(
								null,
								"Jump over balls of another color to empty the grid.\n"
										+ "Score additional points per ball jumped over.\n"
										+ "You may jump over one or more balls of the same color,\n with a ball of another color.\n"
										+ "Bonus: if you remove all balls but one, score is doubled!         \n"
										+ "Right click to clear selection.");
			}
		});
	}

	public void setScore(int s) {
		scoreNum.setText(String.valueOf(s));
	}
}
