import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * <h1>Welcome to Brick Busters.</h1>
 * <p>
 * This is a game where the aim is to remove all the blocks off screen
 * by hitting it with the ball. It is played by using the mouse to aim 
 * and clicking to fire the ball in the chosen direction.
 * 
 * 
 * @author JackHardy
 *@version 1.0
 *@since 2018-05-20
 */

public class MainGame {

	/**
	 * This is the main method instantiates the Gameplay class where the 
	 * game is played. 
	 * It is also used to sort out the settings for the JFrame and adding 
	 * Gameplay to the Frame.
	 * 
	 * @param args Unused
	 * @return nothing
	 */
	public static void main(String[] args)  {
		
		JFrame gameFrame = new JFrame();
		
		Gameplay gameplay = new Gameplay();
		
		gameFrame.setSize(700,1000);
		gameFrame.setTitle("Brick Busters");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.add(gameplay);
		gameFrame.setVisible(true);
		
	}
	
	
	

	

}
