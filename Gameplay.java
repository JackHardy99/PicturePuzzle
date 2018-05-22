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
