import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gameplay {
	private Timer timer;
	private int delay = 8;
	public Gameplay() {
		
		timer = new Timer(delay, this);
		timer.start();
		
	}
}
