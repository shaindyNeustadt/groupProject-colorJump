package colorJump;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Peg extends JButton {
	private Color color;
	private int x;
	private int y;

	public Peg(Color color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
		setImage(color);
		// this.setBackground(null);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.setRolloverEnabled(false);
	}

	/*
	 * @Override protected void paintComponent(Graphics g) {
	 * super.paintComponent(g); if(color != null){ g.setColor(color);
	 * g.fillOval((getWidth() - 70) / 2, (getHeight() - 70) / 2, 70, 70); } }
	 */

	public int getXLocation() {
		return x;
	}

	public int getYLocation() {
		return y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		setImage(color);
	}

	public void setImage(Color c) {
		String name = null;
		if (c == Color.BLUE) {
			name = "/blue_peg.png";

		} else if (c == Color.GREEN) {
			name = "/green_peg.png";
		} else if (c == Color.PINK) {
			name = "/pink_peg.png";
		} else if (c == Color.RED) {
			name = "/red_peg.png";
		} else if (c == Color.MAGENTA) {
			name = "/purple_peg.png";
		} else if (c == Color.YELLOW) {
			name = "/yellow_peg.png";
		}

		if (name == null) {
			this.setIcon(null);
			this.setDisabledIcon(null);
		} else {
			this.setIcon(new ImageIcon(getClass().getResource(name)));
			this.setDisabledIcon(new ImageIcon(getClass().getResource(name)));
		}
	}

}