import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
/**
 * MapGenerator creates all the bricks for the map
 * storing them in an array with each bricks health
 */
public class MapGenerator {
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	public int numberOfDrops =1;
	public boolean bricksBottom = false;
	
	/** 
	 * The constructor for MapGenerator fills the array with 
	 * bricks with health thats decided by the user and also 
	 * the amount of rows decided by the user.
	 * 
	 * @param row	The amount of rows of bricks decided by the user in Gameplay
	 * @param col	The amount of column of bricks decided by the user in Gameplay
	 * @param brickHealth The amount of health for each brick decided by the user in Gameplay
	 * @return nothing
	 */
	public MapGenerator (int row,int col, int brickHealth) {
		map = new int[row][col];
		for(int i=-0;i<map.length;i++) {
			for(int j = 0;j<map[0].length;j++) {
				map[i][j]=brickHealth; //the one shows the brick has not intercepted the ball
							//can change this for bricks to have more health
			}
		}
		
		brickWidth = 540/7;
		brickHeight = 150/3;
	}
	
	/**
	 * draw draws all the bricks onto the gameFrame,
	 * adding their health to the centre of each brick
	 * so the user can see how many hits each brick has left
	 * 
	 * @param g The  graphics variable for the bricks
	 * @return nothing
	 */
	public void draw(Graphics2D g) {
		for(int i=-0;i<map.length;i++) {
			for(int j = 0;j<map[0].length;j++) {
				//if the brick has health continue
				if(map[i][j] >0) {
						//if the bricks are touching the bottom
						if (i*brickHeight + (numberOfDrops *50) > 924) {
							bricksBottom = true;
						}
						else {
							g.setColor(Color.WHITE);
							g.fillRect(j*brickWidth +80, i*brickHeight +(numberOfDrops * 50), brickWidth, brickHeight);
							///adds the health number to the brick
							g.setColor(Color.red);
							g.drawString(""+map[i][j], 80+(brickWidth*(j+1))-(brickWidth/2)-(3*j), (i+1)*(brickHeight)-(brickHeight/2) +(numberOfDrops*50)+(3*i));
							
							//seperates the bricks
							g.setStroke(new BasicStroke(3));
							g.setColor(Color.black);
							
							g.drawRect(j*brickWidth +80, i*brickHeight +(numberOfDrops * 50), brickWidth, brickHeight);
						}
				}
			}
		}
	}
	
	/**
	 * This is used by gameplay to lower the bricks health when an intersection 
	 * has been made between the brick and the ball
	 * 
	 * @param row 	The current bricks row
	 * @param col	The current bricks column
	 * @return nothing
	 */
	public void setBrickValue(int row, int col) {
		map[row][col] = map[row][col] -1;
	}
	
	/**
	 * This is used by gameplay to get the current bricks health to see if it 
	 * needs to be shown on screen.
	 * If its at 0 it wouldn't need to be
	 * 
	 * @param row 	The current bricks row
	 * @param col	The current bricks column
	 * @return map[row][col] Returns the bricks health
	 */
	public int getBrickValue(int row, int col) {
		return map[row][col];
	}
}
