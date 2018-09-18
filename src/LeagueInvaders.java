import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {

JFrame frame;
final static int width = 500;
final static int height = 800;
GamePanel panel;

	public static void main (String[] args) {
		LeagueInvaders l = new LeagueInvaders();
		l.setup();
	}
	
	public LeagueInvaders() {
		frame = new JFrame();
		panel = new GamePanel();
	}
	
	void setup() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		
		frame.getContentPane().setPreferredSize(new Dimension(width, height));

		frame.pack();

		panel.startGame();
		
		frame.addKeyListener(panel);
	}
	
	
}
