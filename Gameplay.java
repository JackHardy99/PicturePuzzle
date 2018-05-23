import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 * Gameplay controls the main aspects of the game.
 * It creates the UI, updates it when an action is performed
 * via the mouse and controls all of the ball functions.
 *
 */
public class Gameplay extends JPanel implements MouseListener, KeyListener, ActionListener{
	private boolean play = false, notBottom = true,  mouseClicked = false;
	private int score = 0, totalBricks = 21, wait = 8, mouseClickX = 0, mouseClickY = 0, brickHealth = 1,brickRow =3, brickColumn=7;
	private Timer timer;
	private int ballPosX = 340, ballPosY = 925, newBricks = 0;
	private double ballXDir, ballYDir;
	private MapGenerator map;
	
	/**
	 * <h1> Gameplay </h1>
	 * <p>
	 * This method is used to instantiate the class adding mouse listeners
	 * to the Gameplay. It also instantiates the Map Generator which adds the
	 * blocks to the Frame for the ball to hit.
	 * Finally a  timer is started to keep the ball moving once clicked.
	 * 
	 * @param nothing
	 * @return nothings
	 */
	public Gameplay() {
		difficulty();
		map = new MapGenerator(brickRow,brickColumn, brickHealth);
		addMouseListener(this);
		addKeyListener(this);
		timer = new Timer(wait, this);
		timer.start();
		
	}
	/**
	 * <h2> Paint </h2>
	 * <p>
	 * This method is used to draw the background and borders of the game, 
	 * along with the ball and launcher.
	 * It also calls draw from the map generator to draw the bricks
	 * onto the frame.
	 * @param g Graphics parameter used for settings of the design
	 * @return Nothing
	 */
	public void paint(Graphics g) {
		
		//Sets the basic background
		g.setColor(Color.black);
		g.fillRect(1, 1, 700, 1000);
		
		//Adds the score to the top left corner
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD, 25));
		g.drawString(""+score, 590, 30);
		
		//drawing Map via the MapGenerator Method
		map.draw((Graphics2D)g);
		if (map.bricksBottom == true) {
			//if the Bricks hit the bottom of the gamescreen the game is lost
			loseState();
		}
		
		//Draws the game borders except the open bottom border
		g.setColor(Color.RED);
		g.fillRect(0, 0, 3, 1000);
		g.fillRect(0, 0, 700, 3);
		g.fillRect(697, 0, 3, 1000);
		
		//The launcher at the bottom that fires the ball
		g.setColor(Color.white);
		g.fillRect(340, 950, 20, 50);

		//Draws the ball
		g.setColor(Color.RED);
		g.fillOval(ballPosX, ballPosY, 20, 20);
		
		g.dispose();
	}
	
	/**
	 * <h2> Ball Direction </h2>
	 * <p>
	 * This method is used to determine which direction the ball will fire in.
	 * It uses the coordinates of where the mouse is clicked and removing
	 * the ball's starting position, the x and y angles can be determined.
	 * 
	 * @param nothing
	 * @return nothing
	 * 
	 */
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
	
	/**
	 * <h2> MouseClicked </h2>
	 * <p>
	 * An overriding method of MouseListener's implemented method mouseClicked.
	 * This checks that the mouse has not been clicked before and if it hasn't
	 * the coordinates of the mouse click will be gotten and the ball will be allowed to move
	 * 
	 * @param e Stores what the mouse has done
	 * @return Nothing
	 * 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (mouseClicked==false) {
			mouseClicked = true;
			//Sets the x and y variables to that of the mouse click.
			mouseClickX = e.getX();
			mouseClickY = e.getY();
			ballDirection();
			play = true;
		}

	}
	/**
	 * <h2> Move Ball </h2>
	 * <p>
	 * This method is the main method for moving the ball.
	 * It checks the coordinates of the ball do not intersect with any bricks
	 * that have health left. If the ball intersects with a brick, the bricks
	 * health is lowered/
	 * It uses the balls coordinates a second rectangle so this rectangle can 
	 * be compared against the brick rectangles. And if the ball hits the 
	 * rectangles it also bounces off these rectangles.
	 *<p>
	 * Finally, the ball will then be moved be adding the direction the ball 
	 * was moving in, to its last coordinates. 
	 * If the ball is off the bottom of the screen a new ball is created and 
	 * the bricks move down
	 * 
	 * @param nothing
	 * @return nothing
	 */
	
	public void moveBall() {
		timer.start();
		if(play && notBottom) {
			//map.maplength is the variable in Gameplay and the map.map[0] is in the generator
			for(int i =0; i<map.map.length; i++ ) {
				for (int j =0; j<map.map[0].length; j++) {
					
					//If the brick has health then continue
					if(map.map[i][j]>0) {
						int brickX = j*map.brickWidth + 80;
						int brickY = i* map.brickHeight + (map.numberOfDrops * 50);
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						
						Rectangle brickRectangle = new Rectangle(brickX, brickY, brickWidth, brickHeight); //Temporarily stores the current brick's properties
						Rectangle ballRectangle = new Rectangle(ballPosX, ballPosY,20,20); //Temporarily stores the ball's properties
						
						
						if(ballRectangle.intersects(brickRectangle)) {		//If the ball touches the brick
							map.setBrickValue(i,j); 				//Lowers the bricks health
							if(map.getBrickValue(i, j) == 0) {
								totalBricks--;					//Removes the brick if it has no health remaining
							}
							
							score +=5;
							//If the ball is hitting the sides of the brick
							if((ballPosX+19) <= brickRectangle.x || (ballPosX +1 ) >= (brickRectangle.x +brickRectangle.width)) {
								ballXDir = -ballXDir;
							}
							else {
								ballYDir = -ballYDir;
							}
						
							
						}
					}
				}
			}
				//Adds the balls direction to the last ball coordinates
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
				//If the ball is off the bottom of the screen
				if (ballPosY>1000) {
					notBottom = false;
						//resets the map and ball
						resetBall();
						map.numberOfDrops++;
				}
				if (totalBricks == 0) {
					winState();
				}
				//repaint() calls paint again and updates the screen
				repaint();
				
		}
	}
	/**
	 * <h2> ActionPerformed </h2>
	 * <p>
	 * If an action is performed the ball will be moved
	 * but only is the mouse has been clicked
	 * 		-See moveBall
	 * 
	 * @param nothing
	 * @return nothing
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		moveBall();
	}
	/**
	 * <h2> Win State </h2>
	 * <p>
	 * If that level is deemed to have been won, the user 
	 * is asked if they want to play the next level.
	 * Selecting no or cancel will close the program and
	 * selecting yes will create the next level with another
	 * row of bricks.
	 * 
	 * @param nothing
	 * @return nothing
	 */
	public void winState() {
		//Put in win dialog box
		JDialog.setDefaultLookAndFeelDecorated(true);
		int res =JOptionPane.showConfirmDialog(null,"Do you want to play the next level?", "Confirm Dialog Box", JOptionPane.YES_NO_OPTION);
			if (res == JOptionPane.NO_OPTION|| res == JOptionPane.CLOSED_OPTION) {
				System.exit(0);
				
			}
			else {
				if (res == JOptionPane.YES_OPTION) {
					//Adds another row of bricks to the next level
					newBricks++;
					resetGame();
				}
			}
	}
	/**
	 * <h2> Lose State </h2>
	 * <p>
	 * If that level is deemed to have been lose, the user 
	 * is asked if they want to play again.
	 * Selecting no or cancel will close the program and
	 * selecting yes will create the first level.
	 * 
	 * @param nothing
	 * @return nothing
	 */
	
	public void loseState() {
		JDialog.setDefaultLookAndFeelDecorated(true);
		int lose = JOptionPane.showConfirmDialog(null,"LOSER: Do you want to play again?", "Confirm Dialog Box", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE );
		if (lose == JOptionPane.NO_OPTION|| lose == JOptionPane.CLOSED_OPTION) {
			System.exit(0);
		}
		else {
			if (lose == JOptionPane.YES_OPTION) {
				resetGame();
			}
		}
	}
	
	/**
	 * <h2> Difficulty </h2>
	 * <p>
	 * This method appears before the gameFrame appears so that 
	 * the user can choose their difficulty of game.
	 * It uses an input dialog box where the user types in their 
	 * difficulty and the game is ran accordingly
	 * 
	 * @param nothing
	 * @return nothing
	 */
	
	public void difficulty() {
		boolean choicesPicked = false;
		//Loops until a correct choice has been made
		do {
			//Outputs a box where the user can enter their difficulty
			String difficultyChoice = JOptionPane.showInputDialog("What Difficulty would you like to play on: Easy, Medium, Hard or Custom");
			/*
			 * Each if statement is made for a different choice the user can make.
			 * The variables are set differently depending on this choice.
			 * If the user picks custom they can then enter the brick health and 
			 * amount of rows.
			 * This will loop till a correct difficulty and/or variables have been
			 * entered correctly
			 */
			
			if (difficultyChoice.equals("Easy")|| difficultyChoice.equals("easy")) {
				brickHealth = 1;
				brickRow = 3;
				totalBricks = brickRow *7;
				choicesPicked = true;

			}
			else if(difficultyChoice.equals("Medium")|| difficultyChoice.equals("medium")) {
				brickHealth = 2;
				brickRow = 4;
				newBricks = 1;
				totalBricks = brickRow *7;
				choicesPicked = true;

			}
			else if(difficultyChoice.equals("Hard")|| difficultyChoice.equals("hard")) {
				brickHealth = 3;
				brickRow = 5;
				newBricks = 2;
				totalBricks = brickRow *7;
				choicesPicked = true;

			}
			else if(difficultyChoice.equals("Custom")|| difficultyChoice.equals("custom")) {
				
					String health = JOptionPane.showInputDialog("What Health will the Bricks have? Max 10");
					if(Integer.valueOf(health)<11 && Integer.valueOf(health)>0) {
						brickHealth = Integer.valueOf(health);
						choicesPicked = true;
					}
					String row = JOptionPane.showInputDialog("How many Rows? Max 7");
					if(Integer.valueOf(row)<8 && Integer.valueOf(row)>0) {
						brickRow = Integer.valueOf(row);
						newBricks = Integer.valueOf(row) - 3;
						totalBricks = brickRow *7;
						choicesPicked = true;
					}
			}
		}while(choicesPicked == false);
		JOptionPane.showMessageDialog(null, "RULES: 1. Click the mouse to aim and fire the ball. 2. Hitting the side of the ball immediately gets rid of the brick. 3. Clear the bricks to get to the next level");
		
	}
	/**
	 * <h2> ResetBall </h2>
	 * <p>
	 * This method is called when the ball has gone off the bottom of
	 * the screen meaning that click has ended.
	 * A new ball is loaded at the bottom of the screen ready to be
	 * fired
	 * 
	 * @param nothing
	 * @return nothing
	 */
	public void resetBall() {
		ballPosX = 340;
		ballPosY = 925;
		play = false;
		notBottom = true;
		repaint();
		mouseClicked = false;
	}
	
	/**
	 * <h2> ResetGame </h2>
	 * <p>
	 * This method is called when either all the bricks have been cleared
	 * or the bricks have hit the bottom of the screen.
	 * If the user chooses to a new gamescreen is then loaded
	 * 
	 * @param nothing
	 * @return nothing
	 */
	public void resetGame() {	
		resetBall();
		totalBricks = 21 + (newBricks*7);
		score = 0;
		map = new MapGenerator(3 + newBricks,7, brickHealth);
		
    }
	

	@Override
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
