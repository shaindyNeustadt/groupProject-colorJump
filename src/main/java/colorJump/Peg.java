package colorJump;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class Peg extends JButton{
	private Color color;
	//private boolean enabled;
	private int x;
	private int y;

	public Peg(Color color, int x, int y){
		this.color = color;
		this.x = x;
		this.y = y;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(color != null){
			g.setColor(color);
			g.fillOval((getWidth() - 70) / 2, (getHeight() - 70) / 2, 70, 70);
		}
	}

	public int getXLocation() {
		return x;
	}

	public int getYLocation() {
		return y;
	}


}