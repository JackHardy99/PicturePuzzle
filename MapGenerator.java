import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	public int numberOfDrops =1;
	public boolean bricksBottom = false;
	
	
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
	
	public void draw(Graphics2D g) {
		for(int i=-0;i<map.length;i++) {
			for(int j = 0;j<map[0].length;j++) {
				if(map[i][j] >0) {
						if (i*brickHeight + (numberOfDrops *50) > 924) {
							bricksBottom = true;
						}
						else {
							g.setColor(Color.WHITE);
							g.fillRect(j*brickWidth +80, i*brickHeight +(numberOfDrops * 50), brickWidth, brickHeight);
							g.setColor(Color.red);
							g.drawString(""+map[i][j], 80+(brickWidth*(j+1))-(brickWidth/2)-(3*j), (i+1)*(brickHeight)-(brickHeight/2) +(numberOfDrops*50)+(3*i));
						
							g.setStroke(new BasicStroke(3));
							g.setColor(Color.black);
							
							g.drawRect(j*brickWidth +80, i*brickHeight +(numberOfDrops * 50), brickWidth, brickHeight);
						}
				}
			}
		}
	}
	
	public void setBrickValue(int row, int col) {
		map[row][col] = map[row][col] -1;
	}
	public int getBrickValue(int row, int col) {
		return map[row][col];
	}
}

