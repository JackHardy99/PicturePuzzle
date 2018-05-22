
public class MapGenerator {
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	
	
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
}
