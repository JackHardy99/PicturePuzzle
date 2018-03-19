 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
*The Interface class is the main runnings behind the picture puzzle
*interacting with the leaderboard and scores
*
*/
public class Interface implements ActionListener, KeyListener {	
	//Creates the array for the buttons to be stored in	
	JButton[][] buttons = new JButton[3][4];
	//Creates the Frame for the game
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
	public Interface()  {
		/**
		*This is the constructor class for the game interface, it sets up the game's frame
		*and panel, adding a grid to it then loading each image into an icon and adding each 			*icon to a button.
		*This creates a 3x4 image grid
		*/


		// Sets the frame to the correct settings
		gameFrame.setTitle("Swingin' Simpsons");
		gameFrame.setSize(444,363);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//Creates grid
		GridLayout grid = new GridLayout(3,4);
		imagePanel.setLayout(grid);
		//Adds panel to the frame
		gameFrame.add(imagePanel);
	
		//Loads the images storing the images in an icon then a button, adding it to the panel then adding an action listener to the button
		int i, j, count = 0;
		for (i=0; i<3; i++){
			for(j=0; j <4; j++){
				ImageIcon image = new ImageIcon("bart"+count+".jpg");
				buttons[i][j] = new JButton(image);
				imagePanel.add(buttons[i][j]);
				buttons[i][j].addActionListener(this);
				count++;		//Used for keeping count of the image number, seperate to the loop integers
			}
		}
		gameFrame.setVisible(true);
		//Constructs Leaderboard
		CreateLeaderboard();	
	}

	public void actionPerformed(ActionEvent e)
	{
		/**
		*
		*This is the action class, should any buttons be clicked, this code will define what 
		*happens
		*<p>
		*It takes what button has been clicked, compares this with the last button clicked 			*and if they are adjacent the images are swapped. 
		*It then will increment the score, the amount of clicks.
		*
		*/
			
		ImageIcon blank = new ImageIcon("bart0.jpg");		//Has constant access to the blank button
		Icon temp = new ImageIcon();				//Used to save the current button
	
		if(e.getSource() == buttons[0][0]){
			XValue = 0;
			YValue = 0;
			testX = XValue - lastXValue;				//Gets the difference between Xs and Ys so the distance of the button being clicked can be determined if it's valid
			testY = YValue - lastYValue;
			if((testX == 1 && testY == 0) || (testX == -1 && testY == 0) || (testX == 0 && testY == 1) || (testX == 0 && testY == -1)){
					
						
				temp = buttons[XValue][YValue].getIcon() ;	//Stores the image of the button you click on
				buttons[XValue][YValue].setIcon(blank);		//Sets the button's image that you click on to blank
				buttons[lastXValue][lastYValue].setIcon(temp);	//Sets the image of the button that was blank to the temp image
				lastXValue = 0;					//Saves the X and Y value of the image that has just been clicked on as that will become the last button for the next click
				lastYValue = 0;	
				IncrementScore();				//Adds one to the score
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
		/**
		*This creates the leaderboard where a players's scores can be saved
		*<p>
		*It uses a new window alongside the game's window, adding 2 columns of labels. 
		*The first column is the names column and the second is the scores column.
		*The slot in the right hand column is a text field for the user to enter their name
		*/


		JFrame board = new JFrame();	
		JPanel boardPane = new JPanel();
		
		//Text field for entering the names
		textField.addKeyListener(this);
		//Sets leaderboard to the right settings
		board.setTitle("High Scores");
		board.setSize(400,400);
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Creates the grid for the labels to be added to
		GridLayout boardGrid = new GridLayout(11,2);
		boardPane.setLayout(boardGrid);
		board.add(boardPane);
		board.setContentPane(boardPane);
		
		for (int i=0; i <11; i++){
			if(i<10){
				labels[i] = new JLabel("NONE");	//labels is the left hand column, for names
				boardPane.add(labels[i]);
				labels2[i] = new JLabel("0");	//labels2is the rght hand column for scores
				boardPane.add(labels2[i]);
			}					//Loops through till there's ten rows for score then adds the name entry label and text field
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
		/**
		*This adds one to the score of the user because they've clicked a valid button
		*/
		
		score++;
		labels2[0].setText(String.valueOf(score));	//Converts score from integer to string and updates the leaderboard
	}
	public void keyPressed(KeyEvent e)
	{
		/*
		*
		*
		*
		*/

		if(e.getKeyCode() == KeyEvent.VK_ENTER){	//Only performs something when the enter key is pressed
			String tempName = textField.getText();	
			labels[0].setText(tempName);		// Sets the highest label to the entered name
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e) {}
	
}

