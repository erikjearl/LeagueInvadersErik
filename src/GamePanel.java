import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font smallFont;
	Rocketship rocket = new Rocketship(250,700,50,50);
	
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	
	public GamePanel() {
	timer = new Timer(1000/60, this);
	titleFont = new Font("Arial",Font.BOLD,48);
	smallFont = new Font("Arial",Font.PLAIN,27);
	}
	
	void startGame() {
		timer.start();
	}
	
	void updateMenuState() {
		
	}
	void updateGameState(){
		rocket.update();
	}
	void updateEndState() {
		
	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 100);
		g.setFont(smallFont);
		g.drawString("Press ENTER to start", 115, 300);
		g.drawString("Press SPACE for instructions", 70, 500);
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);  
		
		rocket.draw(g);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);  
		
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAMEOVER", 100, 200);
		g.setFont(smallFont);
		g.drawString("You killed 0 enemies", 115, 375);
		g.drawString("Press ENTER to restart", 100, 500);
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  
		if(currentState == MENU_STATE){
			updateMenuState();
		}else if(currentState == GAME_STATE){
			updateGameState();
		}else if(currentState == END_STATE){
			updateEndState();
		}
		
		if(up) {
		rocket.y-=rocket.speed;
		}
		if(down) {
		rocket.y+=rocket.speed;
		}
		if(left) {
		rocket.x-=rocket.speed;
		}
		if(right) {
		rocket.x+=rocket.speed;
		}
		
		
		repaint();
		
		repaint();
		
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU_STATE){

			drawMenuState(g);

		  }else if(currentState == GAME_STATE){

			  drawGameState(g);

		  }else if(currentState == END_STATE){

			  drawEndState(g);

		  }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	} 
	
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP ) {
		//rocket.y-=rocket.speed;
			up=true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN ) {
			down=true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT ) {
			left=true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT ) {
			right=true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER ) {
			currentState++;
			if(currentState > END_STATE){
                currentState = MENU_STATE;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP ) {
			//rocket.y-=rocket.speed;
				up=false;
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN ) {
				down=false;
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT ) {
				left=false;
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT ) {
				right=false;
			}
	}
		
}