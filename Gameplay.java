import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gameplay extends JPanel implements MouseListener, KeyListener, ActionListener{
	private Timer timer;
	private int delay = 8;
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
		
		g.dispose();
	}
	
	public void mouseClicked(MouseEvent e) {

	}
	public void actionPerformed(ActionEvent e) {
		
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
