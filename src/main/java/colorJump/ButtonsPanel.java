package colorJump;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.omg.CORBA.portable.InputStream;

public class ButtonsPanel extends JPanel implements MouseListener{
	private JButton restart;
	private JButton help;
	private JLabel score;
	private JLabel scoreNum;
	private JPanel scorePanel;
	private JLabel logo;

	public ButtonsPanel(final GamePanel gamePanel) {
		setLayout(new GridLayout(4, 0));
		setBackground(Color.WHITE);
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
		restart.addMouseListener(this);
		removeDecor(restart);
		help = new JButton("Help");
		help.setFont(customfont);
		help.addMouseListener(this);
		removeDecor(help);

		scorePanel = new JPanel(new BorderLayout());
		removeDecor(scorePanel);

		scoreNum = new JLabel("0");
		scoreNum.setFont(customfont);
		scoreNum.setPreferredSize(new Dimension(75, 50));
		removeDecor(scoreNum);

		score = new JLabel("SCORE: ", SwingConstants.RIGHT);
		score.setFont(customfont);
		removeDecor(score);

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

	public void removeDecor(JComponent c) {
		c.setBackground(Color.WHITE);
		c.setBorder(null);
	}

	public void mouseClicked(MouseEvent arg0) {

	}

	public void mouseEntered(MouseEvent e) {
		JButton b = (JButton) e.getSource();
		b.setForeground(Color.GRAY);

	}

	public void mouseExited(MouseEvent e) {
		JButton b = (JButton) e.getSource();
		b.setForeground(Color.BLACK);

	}

	public void mousePressed(MouseEvent arg0) {

	}

	public void mouseReleased(MouseEvent arg0) {

	}
}
