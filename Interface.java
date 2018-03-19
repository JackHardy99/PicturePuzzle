public class GUI implements ActionListener {
	JButton[][] buttons = new JButton[3][4];
	JFrame gameFrame = new JFrame();		
	JPanel imagePanel = new JPanel();
	JFrame board = new JFrame();	
	JPanel boardPane = new JPanel();
		
	private int XValue = 0, YValue = 0, lastXValue = 0, lastYValue = 0, testX, testY;
	

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
		
		board.setTitle("High Scores");
		board.setSize(400,400);
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board.add(boardPane);
		board.setContentPane(boardPane);
	
		board.setVisible(true);
		GridLayout boardGrid = new GridLayout(11,2);
		JLabel[] labels = new JLabel[20];
		for (i =0; i <20; i++){
		
				labels[i] = new JLabel("NONE");
				boardPane.add(labels[i]);
			
		}

	}
