package colorJump;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Peg extends JButton {
	private int color;
	private int x;
	private int y;
	private String[] colorArray = new String[] { null, "/green_peg.png",
			"/yellow_peg.png", "/purple_peg.png", "/blue_peg.png",
			"/pink_peg.png", "/red_peg.png" };

	public Peg(int color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
		setColor(color);

		this.setBackground(Color.WHITE);
		this.setBorder(null);
		this.setFocusPainted(false);
		this.setRolloverEnabled(false);
	}

	public int getXLocation() {
		return x;
	}

	public int getYLocation() {
		return y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int c) {
		this.color = c;
		String name = colorArray[c];

		if (name == null) {
			this.setIcon(null);
			this.setDisabledIcon(null);
		} else {
			this.setIcon(new ImageIcon(getClass().getResource(name)));
			this.setDisabledIcon(new ImageIcon(getClass().getResource(name)));
		}
	}

}