package colorJump;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ButtonsPanel extends JPanel implements MouseListener {
	private JButton restart;
	private JButton help;
	private JLabel score;
	private JLabel scoreNum;
	private JPanel scorePanel;
	private JLabel logo;
	private GamePanel gamePanel;
	private Font bebasFont;

	public ButtonsPanel(final GamePanel gamePanel) {
		setLayout(new GridLayout(4, 0));
		setOpaque(false);
		Dimension d = new Dimension(200, 650);
		this.setPreferredSize(d);
		this.setMaximumSize(d);
		this.setMinimumSize(d);

		this.gamePanel = gamePanel;

		bebasFont = null;

		try {
			GraphicsEnvironment ge = GraphicsEnvironment
					.getLocalGraphicsEnvironment();

			InputStream in = getClass().getResource("/BEBAS__.TTF")
					.openStream();
			bebasFont = Font.createFont(Font.TRUETYPE_FONT, in).deriveFont(20f);

			ge.registerFont(bebasFont);

		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logo = new JLabel(new ImageIcon(getClass().getResource("/Peg2.png")));

		restart = new JButton("Restart");
		restart.setFont(bebasFont);
		restart.setContentAreaFilled(false);
		restart.addMouseListener(this);
		removeDecor(restart);
		help = new JButton("Help");
		help.setFont(bebasFont);
		help.setContentAreaFilled(false);
		help.addMouseListener(this);
		removeDecor(help);

		scorePanel = new JPanel(new BorderLayout());
		removeDecor(scorePanel);

		scoreNum = new JLabel("0");
		scoreNum.setFont(bebasFont);
		scoreNum.setPreferredSize(new Dimension(75, 50));
		removeDecor(scoreNum);

		score = new JLabel("SCORE: ", SwingConstants.RIGHT);
		score.setFont(bebasFont);
		removeDecor(score);

		scorePanel.add(score, BorderLayout.CENTER);
		scorePanel.add(scoreNum, BorderLayout.EAST);

		add(logo);
		add(scorePanel);
		add(restart);
		add(help);

		/*
		 * restart.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent arg0) {
		 * gamePanel.restart(); setScore(0); gamePanel.resetScore(); } });
		 * 
		 * help.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent arg0) { getHelp();
		 * 
		 * } });
		 */
	}

	public void setScore(int s) {
		scoreNum.setText(String.valueOf(s));
	}

	public void removeDecor(JComponent c) {
		c.setOpaque(false);
		c.setBorder(null);
		c.setFont(bebasFont);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton b = (JButton) e.getSource();
		if (b == restart) {
			gamePanel.restart();
			setScore(0);
			gamePanel.resetScore();
		} else if (b == help) {
			getHelp();
		}
		b.setBorderPainted(false);
		b.setBorder(null);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JButton b = (JButton) e.getSource();
		b.setForeground(Color.GRAY);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		JButton b = (JButton) e.getSource();
		b.setForeground(Color.BLACK);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		JButton b = (JButton) e.getSource();
		b.setContentAreaFilled(false);

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	public void getHelp() {
		HelpDialog help = new HelpDialog();
		help.setLocationRelativeTo(gamePanel.getGameFrame());
	}
}
