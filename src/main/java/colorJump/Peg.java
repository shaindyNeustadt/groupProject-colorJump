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

	public int getMyX() {
		return x;
	}

	public int getMyY() {
		return y;
	}
public void setColor(Color color){
	this.color = color;
	repaint();
}

public Color getColor(){
	return color;
}
	
	
}