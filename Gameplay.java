import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gameplay extends JPanel implements MouseListener, KeyListener, ActionListener{
	private boolean play = false, mouseClicked = false, notBottom = true;
	private Timer timer;
	private int delay = 8, ballPosX = 340, ballPosY = 925, mouseClickX = 0, mouseClickY = 0, brickHealth = 1,brickRow =3, brickColumn=7,score;
	private double ballXDir =-3, ballYDir=-6;
	private MapGenerator map;
	
	public Gameplay() {
		map = new MapGenerator(brickRow,brickColumn, brickHealth);
		addMouseListener(this);
		addKeyListener(this);
		timer = new Timer(delay, this);
		timer.start();
		
	}
	public void paint(Graphics g) {
		//background
		g.setColor(Color.black);
		g.fillRect(1, 1, 700, 1000);
		
		//border
		g.setColor(Color.RED);
		g.fillRect(0, 0, 3, 1000);
		g.fillRect(0, 0, 700, 3);
		g.fillRect(697, 0, 3, 1000);
		
		//launcher
		g.setColor(Color.white);
		g.fillRect(340, 950, 20, 50);
		
		//Adds the score to the top left corner
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD, 25));
		g.drawString(""+score, 590, 30);
		
		
		//Bricks
		map.draw((Graphics2D)g);

		//ball
		g.setColor(Color.RED);
		g.fillOval(ballPosX, ballPosY, 20, 20);
		
		g.dispose();
	}
	
	public void ballDirection(){
		double XDir;
		double YDir;
		
		XDir = mouseClickX - ballPosX;
		YDir = mouseClickY - ballPosY;
		
		XDir = XDir/100;
		YDir = YDir/100;
		
		ballXDir = XDir;
		ballYDir = YDir;
	}
	
	public void moveBall() {
		timer.start();
		
			if (play) {
				ballPosX += ballXDir;
				ballPosY += ballYDir;
				//Left Border
				if (ballPosX < 0) {
					ballXDir = -ballXDir;
				}
				//Top Border
				if (ballPosY < 0 ) {
					ballYDir = -ballYDir;
				}
				//Right Border
				if (ballPosX > 695) {
					ballXDir = - ballXDir;
				}
				if (ballPosY>1000) {
					notBottom = false;
						//resets the map and ball
						
				}
				
				//repaint() calls paint again and updates the screen
				repaint();
			}
	}
	public void mouseClicked(MouseEvent e) {
		if (mouseClicked==false) {
			mouseClicked = true;
			mouseClickX = e.getX();
			mouseClickY = e.getY();
			ballDirection();
			play = true;
		}
		
	}
	public void actionPerformed(ActionEvent e) {
		moveBall();
	}
	public void resetBall() {
		ballPosX = 340;
		ballPosY = 925;
		play = false;
		notBottom = true;
		repaint();
		mouseClicked = false;
	}
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}
