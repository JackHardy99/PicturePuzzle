 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener, KeyListener {
	JButton[][] buttons = new JButton[3][4];
	JFrame gameFrame = new JFrame();		
	JPanel imagePanel = new JPanel();
	//Labels for the left hand column
	JLabel[] labels = new JLabel[11];
	//Labels for the right hand column
	JLabel[] labels2 = new JLabel [10];
	//Text field for the user entered name
	JTextField textField = new JTextField(20);
	
		
	private int XValue = 0, YValue = 0, lastXValue = 0, lastYValue = 0, testX, testY, score = 0;
	
	

	//Constructor method
	public GUI()  {

		//Creates a new Puzzle Frame

		//Creates panel
	
		gameFrame.setTitle("Swingin' Simpsons");
		gameFrame.setSize(444,363);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//Creates grid
		GridLayout grid = new GridLayout(3,4);
		imagePanel.setLayout(grid);
		
		gameFrame.add(imagePanel);
	
		//Loads the images storing the images in an icon then a button, adding it to the panel then adding an action listener to the button
		int i, j, count = 0;
		for (i=0; i<3; i++){
			for(j=0; j <4; j++){
				ImageIcon image = new ImageIcon("bart"+count+".jpg");
				buttons[i][j] = new JButton(image);
				imagePanel.add(buttons[i][j]);
				buttons[i][j].addActionListener(this);
				count++;
			}
		}
		
	
		gameFrame.setVisible(true);
		//Constructs Leaderboard
		CreateLeaderboard();
		
	}

	public void actionPerformed(ActionEvent e)
	{
			
			ImageIcon blank = new ImageIcon("bart0.jpg");
			Icon temp = new ImageIcon();
	
			if(e.getSource() == buttons[0][0]){
				XValue = 0;
				YValue = 0;
				testX = XValue - lastXValue;
				testY = YValue - lastYValue;
				if((testX == 1 && testY == 0) || (testX == -1 && testY == 0) || (testX == 0 && testY == 1) || (testX == 0 && testY == -1)){
					
						
						temp = buttons[XValue][YValue].getIcon() ;	//Stores the image of the button you click on
						buttons[XValue][YValue].setIcon(blank);		//Sets the button's image that you click on to blank
						buttons[lastXValue][lastYValue].setIcon(temp);	//Sets the image of the button that was blank to the temp image
			
						lastXValue = 0;
						lastYValue = 0;
						IncrementScore();
					
				}
				
			}
				
			else if (e.getSource() == buttons[0][1]){
				XValue = 0;
				YValue = 1;
				testX = XValue - lastXValue;
				testY = YValue - lastYValue;	

				if((testX == 1 && testY == 0) || (testX == -1 && testY == 0) || (testX == 0 && testY == 1) || (testX == 0 && testY == -1)){
						temp = buttons[XValue][YValue].getIcon() ;						
						buttons[XValue][YValue].setIcon(blank);
						buttons[lastXValue][lastYValue].setIcon(temp);
						lastXValue = 0;
						lastYValue = 1;
						IncrementScore();
					
				}
				
			}			
			
			else if (e.getSource() == buttons[0][2]){
				XValue = 0;
				YValue = 2;
				testX = XValue - lastXValue;
				testY = YValue - lastYValue;
				
				if((testX == 1 && testY == 0) || (testX == -1 && testY == 0) || (testX == 0 && testY == 1) || (testX == 0 && testY == -1)){
			
						temp = buttons[XValue][YValue].getIcon() ;
						buttons[XValue][YValue].setIcon(blank);
						buttons[lastXValue][lastYValue].setIcon(temp);
			
						lastXValue = 0;
						lastYValue = 2;
						IncrementScore();
					
				}

			}
			else if (e.getSource() == buttons[0][3]){
				XValue = 0;
				YValue = 3;
				testX = XValue - lastXValue;
				testY = YValue - lastYValue;		
				
				if((testX == 1 && testY == 0) || (testX == -1 && testY == 0) || (testX == 0 && testY == 1) || (testX == 0 && testY == -1)){
						temp = buttons[XValue][YValue].getIcon() ;
						buttons[XValue][YValue].setIcon(blank);
						buttons[lastXValue][lastYValue].setIcon(temp);
	
						lastXValue = 0;
						lastYValue = 3;
						IncrementScore();
					

				}
				
			}

			else if(e.getSource() == buttons[1][0]){
				XValue = 1;
				YValue = 0;
				testX = XValue - lastXValue;
				testY = YValue - lastYValue;
			
				if((testX == 1 && testY == 0) || (testX == -1 && testY == 0) || (testX == 0 && testY == 1) || (testX == 0 && testY == -1)){
				
						temp = buttons[XValue][YValue].getIcon();
						buttons[XValue][YValue].setIcon(blank);
						buttons[lastXValue][lastYValue].setIcon(temp);

						lastXValue = 1;
						lastYValue = 0;
						IncrementScore();
					

				}
				
			}

			else if(e.getSource() == buttons[1][1]){
				XValue = 1;
				YValue = 1;
				testX = XValue - lastXValue;
				testY = YValue - lastYValue;
				
				if((testX == 1 && testY == 0) || (testX == -1 && testY == 0) || (testX == 0 && testY == 1) || (testX == 0 && testY == -1)){

						temp = buttons[XValue][YValue].getIcon() ;
						buttons[XValue][YValue].setIcon(blank);
						buttons[lastXValue][lastYValue].setIcon(temp);

						lastXValue = 1;
						lastYValue = 1;
						IncrementScore();
					
				}
				
			}
				

			else if(e.getSource() == buttons[1][2]){
				XValue = 1;
				YValue = 2;
				testX = XValue - lastXValue;
				testY = YValue - lastYValue;
				

				if((testX == 1 && testY == 0) || (testX == -1 && testY == 0) || (testX == 0 && testY == 1) || (testX == 0 && testY == -1)){
						temp = buttons[XValue][YValue].getIcon() ;
						buttons[XValue][YValue].setIcon(blank);
						buttons[lastXValue][lastYValue].setIcon(temp);
	
						lastXValue = 1;
						lastYValue = 2;
						IncrementScore();
					

				}
				
			}	

			else if(e.getSource() == buttons[1][3]){
				XValue = 1;
				YValue = 3;
				testX = XValue - lastXValue;
				testY = YValue - lastYValue;
				if((testX == 1 && testY == 0) || (testX == -1 && testY == 0) || (testX == 0 && testY == 1) || (testX == 0 && testY == -1)){
						temp = buttons[XValue][YValue].getIcon() ;
						buttons[XValue][YValue].setIcon(blank);
						buttons[lastXValue][lastYValue].setIcon(temp);

						lastXValue = 1;
						lastYValue = 3;
						IncrementScore();
					
				}
			
			}
				
			else if(e.getSource() == buttons[2][0]){
				XValue = 2;
				YValue = 0;
				testX = XValue - lastXValue;
				testY = YValue - lastYValue;
				
				if((testX == 1 && testY == 0) || (testX == -1 && testY == 0) || (testX == 0 && testY == 1) || (testX == 0 && testY == -1)){
						temp = buttons[XValue][YValue].getIcon() ;
						buttons[XValue][YValue].setIcon(blank);
						buttons[lastXValue][lastYValue].setIcon(temp);

						lastXValue = 2;
						lastYValue = 0;	
						IncrementScore();
					
				}
				
			}
				
			else if(e.getSource() == buttons[2][1]){
				XValue = 2;
				YValue = 1;
				testX = XValue - lastXValue;
				testY = YValue - lastYValue;
				
				if((testX == 1 && testY == 0) || (testX == -1 && testY == 0) || (testX == 0 && testY == 1) || (testX == 0 && testY == -1)){	
						temp = buttons[XValue][YValue].getIcon() ;
						buttons[XValue][YValue].setIcon(blank);
						buttons[lastXValue][lastYValue].setIcon(temp);

						lastXValue = 2;
						lastYValue = 1;
						IncrementScore();
					

				}
			
			}
	
			else if(e.getSource() == buttons[2][2]){
				XValue = 2;
				YValue = 2;
				testX = XValue - lastXValue;
				testY = YValue - lastYValue;

				if((testX == 1 && testY == 0) || (testX == -1 && testY == 0) || (testX == 0 && testY == 1) || (testX == 0 && testY == -1)){
						temp = buttons[XValue][YValue].getIcon() ;
						buttons[XValue][YValue].setIcon(blank);
						buttons[lastXValue][lastYValue].setIcon(temp);

						lastXValue = 2;
						lastYValue = 2;
						IncrementScore();
					
				}
	
			}

		
			else if(e.getSource() == buttons[2][3]){
				XValue = 2;
				YValue = 3;
				testX = XValue - lastXValue;
				testY = YValue - lastYValue;
				
				if((testX == 1 && testY == 0) || (testX == -1 && testY == 0) || (testX == 0 && testY == 1) || (testX == 0 && testY == -1)){
						temp = buttons[XValue][YValue].getIcon() ;
						buttons[XValue][YValue].setIcon(blank);
						buttons[lastXValue][lastYValue].setIcon(temp);

						lastXValue = 2;
						lastYValue = 3;
						IncrementScore();
					

				}
		
			}
			
	}
	public void CreateLeaderboard() 
	{
		JFrame board = new JFrame();	
		JPanel boardPane = new JPanel();
		
		//Text field for entering the names
		textField.addKeyListener(this);
	
		board.setTitle("High Scores");
		board.setSize(400,400);
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout boardGrid = new GridLayout(11,2);
		boardPane.setLayout(boardGrid);
		board.add(boardPane);
		board.setContentPane(boardPane);
		

		for (int i=0; i <11; i++){
			if(i<10){
				labels[i] = new JLabel("NONE");
				boardPane.add(labels[i]);
				labels2[i] = new JLabel("0");
				boardPane.add(labels2[i]);
			}
			else{
				labels[i] = new JLabel("Your Name: ");
				boardPane.add(labels[i]);
				boardPane.add(textField);
			}
			
					
			
		}
		
		board.setVisible(true);
	}
	public void IncrementScore()
	{
		score++;
		labels2[0].setText(String.valueOf(score));
	}
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			System.out.println("Enter");
			labels[0].setText(String.valueOf(textField));
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e) {}
	
}

