import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gameplay extends JPanel implements MouseListener, KeyListener, ActionListener{
	private boolean play = false;
	private Timer timer;
	private int delay = 8, ballPosX = 340, ballPosY = 925;
	private double ballXDir =-3, ballYDir=-6;
	
	public Gameplay() {
		
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

		//ball
		g.setColor(Color.RED);
		g.fillOval(ballPosX, ballPosY, 20, 20);
		
		g.dispose();
	}
	
	public void moveBall() {
		timer.start();
		
			
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
				
				//repaint() calls paint again and updates the screen
				repaint();
				
		
	}
	public void mouseClicked(MouseEvent e) {
		play = true;
	}
	public void actionPerformed(ActionEvent e) {
		moveBall();
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
