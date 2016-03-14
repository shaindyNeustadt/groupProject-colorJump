package colorJump;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GameOver extends JFrame{
private GamePanel game;
private int scoreNum;
private int bonusNum;
private int totalNum;
private JLabel score;
private JLabel bonus;
private JLabel total;
private JButton ok;

	public GameOver(final GamePanel game){
		setTitle("YOU WON!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 550);
		setLayout(new GridLayout(4,0));
		Container container = getContentPane();
			
		this.game = game;	
		scoreNum = game.getScore();
		bonusNum = game.getBonus();
		totalNum = scoreNum + bonusNum;
		score = new JLabel("Score: " + scoreNum, SwingConstants.CENTER);
		bonus = new JLabel("Bonus: " + bonusNum, SwingConstants.CENTER);
		total = new JLabel("Total: " + totalNum, SwingConstants.CENTER);
				
		ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.restart();
				//setScore(0);
				game.resetScore();
				dispose();
			}
		});
		
		container.add(score);
		container.add(bonus);
		container.add(total);
		container.add(ok);
	}
}