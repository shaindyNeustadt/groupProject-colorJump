package colorJump;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.omg.CORBA.portable.InputStream;

public class ButtonsPanel extends JPanel {
	private JButton restart;
	private JButton help;
	private JLabel score;
	private JLabel scoreNum;
	private JPanel scorePanel;
	private JLabel logo;

	public ButtonsPanel(final GamePanel gamePanel) {
		setLayout(new GridLayout(4, 0));
		Dimension d = new Dimension(200, 650);
		this.setPreferredSize(d);
		this.setMaximumSize(d);
		this.setMinimumSize(d);

		Font customfont = null;
		InputStream in = (InputStream) getClass().getResourceAsStream(
				"./BEBAS_.TTF");
		try {
			customfont = Font.createFont(Font.TRUETYPE_FONT, in);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logo = new JLabel(new ImageIcon(getClass().getResource("/Peg2.png")));

		restart = new JButton("Restart");
		restart.setFont(customfont);
		help = new JButton("Help");
		help.setFont(customfont);

		scorePanel = new JPanel(new BorderLayout());

		scoreNum = new JLabel("0");
		scoreNum.setFont(customfont);
		scoreNum.setPreferredSize(new Dimension(75, 50));

		score = new JLabel("SCORE: ", SwingConstants.RIGHT);

		score.setFont(customfont);

		scorePanel.add(score, BorderLayout.CENTER);
		scorePanel.add(scoreNum, BorderLayout.EAST);

		add(logo);
		add(scorePanel);
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
