package com.comresource.kata;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class KataView extends JPanel implements MouseListener, ActionListener, KeyListener, ChangeListener{
	
	Font font = new Font("Serif", Font.ITALIC, 20);
	private static final long serialVersionUID = 1L;
	volatile boolean frozen;
	//create an instance of Canvas 'the view
	Canvas canvas;
	//create an instance of JTextfield
	JTextField currentGeneration, rows, cols;
	//create an instance of JLabel
	JLabel genLabel, gridLabel, xLabel, sliderLabel;
	//create an instance of JButton
	JButton actionButton;
	//create an instance of Board to store initial life entities
	Board lifeBoard;
	//create an instance of Board to store initial life's offspring entities
	Board offspringBoard;
	//counter for the current generation of life
	private int lifeCycle = 0;
	//Set up animation parameters.
    static final int FPS_MIN = 0;
    static final int FPS_MAX = 30;
    static final int FPS_INIT = 15;    //initial frames per second
    int delay;
    Timer timer;
    //hold current Jbutton Action
    private String action;
 
	public KataView(int row, int col) {
		delay = 1000 / FPS_INIT;
		//Initializes currently not simulating
		frozen = true;
		//Initializes Jbutton with text with an action
		action = "Set Grid";
		//Instantiates an instance of the Board class 'Model'
		lifeBoard = new Board(row, col);
		//Instantiates an instance of the Board class 'Model'
		offspringBoard = new Board(row, col); 
		//Set up a timer that calls this object's action handler.
        timer = new Timer(delay, this);
        //We pause animation twice per cycle by restarting the timer
        timer.setInitialDelay(delay * 7);
        //Reduces likelihood a busy application may not be able to keep up with Timer event generation
        timer.setCoalesce(true);
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	draw(); //creates the components that will be add to the instance of JPanel
            }
        }); 
	}
	
	private void newView(Integer row, Integer col) {
		//Update Jbutton with text with an action
		lifeBoard = null;
		offspringBoard = null;
		//Instantiates a new instance of the Board class 'Model'
		lifeBoard = new Board(row, col);
		//Instantiates a new instance of the Board class 'Model'
		offspringBoard = new Board(row, col); 
	}
	
	//updates variances in simulation
	private void update(){
		lifeCycle++;
		//evaluate grid life 
		for(int r = 0; r < lifeBoard.getRows(); r++) {
			for(int c = 0; c < lifeBoard.getCols(); c++) {
				if(lifeBoard.underPopulation(r, c)) {
					offspringBoard.setValue(r, c, lifeBoard.DEAD);
				}
				if(lifeBoard.overCrowding(r, c)) {
					offspringBoard.setValue(r, c, lifeBoard.DEAD);
				}
				if(lifeBoard.nextGeneration(r, c)) {
					offspringBoard.setValue(r, c, lifeBoard.ALIVE);
				}
				if(lifeBoard.reincarnateCell(r, c)) {
					offspringBoard.setValue(r, c, lifeBoard.ALIVE);
				}
			}
		}
		lifeBoard.cloneGrid(offspringBoard);
		timer.restart();
		genLabel.setText(" Lifecycle: "+lifeCycle);
		sliderLabel.setText((1000/delay)+" Frames per second ");
	}
	
	private void draw(){
		//create new border layout
		this.setLayout(new BorderLayout());
		
		//instantiate userPanel of type JPanel
		JPanel userPanel = new JPanel();
		userPanel.setLayout(new FlowLayout());
		
		//create JTextFields
		rows = new JTextField(lifeBoard.getRows().toString(),2);
		cols = new JTextField(lifeBoard.getCols().toString(),2);
		rows.setFont(font);
		cols.setFont(font);
		cols.setEditable(true);
		rows.setEditable(true);
		rows.setToolTipText("Enter the number of rows you wish to be in the grid. (greater than 3, less than 99)");
		cols.setToolTipText("Enter the number of columns you wish to be in the grid. (greater than 3, less than 99)");
		
		//create JButton
		actionButton = new JButton(action);
		actionButton.setFont(font);
		
		//Create the slider.
		
        JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, FPS_INIT);
        //Turn on labels at major tick marks.
        framesPerSecond.setMajorTickSpacing(10);
        framesPerSecond.setMinorTickSpacing(1);
        framesPerSecond.setPaintTicks(true);
        framesPerSecond.setPaintLabels(true);
        //framesPerSecond.setBorder(BorderFactory.createEmptyBorder(15,10,15,10));
        framesPerSecond.setFont(font);
        
		//create labels
        genLabel = new JLabel(" Lifecycle: "+lifeCycle);
		gridLabel = new JLabel("Grid Size: ");
		gridLabel.setFont(font);
		xLabel = new JLabel("RxC");
		xLabel.setFont(font);
		sliderLabel = new JLabel("Frames per second ");
		genLabel.setFont(font);
		sliderLabel.setFont(font);
		
		//add components to user panel
		userPanel.add(sliderLabel);
		userPanel.add(framesPerSecond);
		userPanel.add(gridLabel);
		userPanel.add(rows);
		userPanel.add(xLabel);
		userPanel.add(cols);
		userPanel.add(actionButton);
		userPanel.add(genLabel);
		
		//instantiate canvas
		canvas = new Canvas();
		canvas.setBackground(new Color(73, 121, 204));
		
		//add key listeners
		rows.addKeyListener(this);
		cols.addKeyListener(this);
		
		//add button action listeners
		actionButton.addActionListener(this);
		
		//add mouse listeners
		canvas.addMouseListener(this);
		
		//add slider change listeners
		framesPerSecond.addChangeListener(this);
		
		//attach components to view
		add(canvas, BorderLayout.CENTER);
		add(userPanel, BorderLayout.SOUTH);
	}
	
	private void start(){
		//Start (or restart) animating.
        timer.start();
        frozen = false;
	}
	
	public void pause() {
		//Stop the animating thread.
        timer.stop();
        frozen = true;
	}  
	
	private class Canvas extends JPanel{ 
		//constructs a visual representation of the life simulation board
		private static final long serialVersionUID = 1L;
		int wid, hgt, rows, cols;
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			wid = getWidth();
			hgt = getHeight();
			rows = lifeBoard.getRows();
			cols = lifeBoard.getCols();
			
			for(int r = 0; r < rows; r++){
				for(int c = 0; c < cols; c++){
					g.setColor(Color.WHITE);
					g.drawRect((c*wid/cols)+2, (r*hgt/rows)+2, (wid/cols)-4, (hgt/rows)-4);
					if(lifeBoard.isAlive(r, c)) {
						g.setColor(new Color(255, 200, 0));
						g.fillOval((c*wid/cols)+4, (r*hgt/rows)+4, (wid/cols)-8, (hgt/rows)-8);
					}		
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() != null) {
			if(e.getActionCommand().equals("Set Grid")) {
				if(rows.getText().isEmpty() || cols.getText().isEmpty()) {
					JOptionPane.showMessageDialog(canvas, "The column or width fields must contain numeric values!", 
							"Error: Invalid Input", JOptionPane.ERROR_MESSAGE);
				}
				else if(Integer.valueOf(rows.getText()) < 3 || Integer.valueOf(cols.getText()) < 3) {
					JOptionPane.showMessageDialog(canvas, "The column or width fields must at least 3!", 
							"Error: Invalid Input", JOptionPane.ERROR_MESSAGE);
				}
				else {
					newView(Integer.valueOf(rows.getText()), Integer.valueOf(cols.getText()));
				}
			}
			else if(e.getActionCommand().equals("Begin Simulation")) {
				action="Pause Simulation";
				start();
			}
			else if(e.getActionCommand().equals("Pause Simulation")) {
				action="Begin Simulation";
				pause(); 
			}else System.out.println("No action to perform");
		}
		actionButton.setText(action);
		if(!frozen && action.equals("Pause Simulation"))
			update();
		canvas.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//returns the mouse x/y-coordinate clicked and stores it to the x/y variable
		int x = e.getX(); 
		int y = e.getY();
		int lifeCount = 0;
		// prints x/y-coordinate to console
		System.out.println("Mouse coord: {"+x+","+y+"}"); 
		//trims the mouse click down to a column integer value and stores it in the variable column
		int col = x / ((canvas.wid/lifeBoard.getCols())+2); 
		int row = y / ((canvas.hgt/lifeBoard.getRows())+2);
		System.out.println("Grid: ["+row+", "+col+"]");
		if(frozen) {
			if(lifeBoard.isAlive(row, col))
				lifeBoard.setValue(row, col, lifeBoard.DEAD);
			else
				lifeBoard.setValue(row, col, lifeBoard.ALIVE);
			for(int i = 0; i < lifeBoard.getRows(); i++) {
				for(int j = 0; j < lifeBoard.getCols(); j++) {
					if(lifeBoard.isAlive(i, j))
						lifeCount++;
				}
			}
			if(lifeCount >= 3){
				action = "Begin Simulation";
				gridLabel.setVisible(false);
				rows.setVisible(false);
				xLabel.setVisible(false);
				cols.setVisible(false);
			}
			else {
				action = "Set Grid";
				gridLabel.setVisible(true);
				rows.setVisible(true);
				xLabel.setVisible(true);
				cols.setVisible(true);
			}
			
			actionButton.setText(action);
			canvas.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (rows.getText().length() >= 2 && rows.isFocusOwner()) // limit text-field to 3 characters
            e.consume();
		if (cols.getText().length() >= 2 && cols.isFocusOwner()) // limit text-field to 3 characters
            e.consume();
		char c = e.getKeyChar();
	      if (!((c >= '0') && (c <= '9') ||
	         (c == KeyEvent.VK_BACK_SPACE) ||
	         (c == KeyEvent.VK_DELETE))) {
	        getToolkit().beep();
	        e.consume();
	        JOptionPane.showMessageDialog(canvas, "The column and width fields may only contain numeric values!", 
	        								"Error: Invalid Input", JOptionPane.ERROR_MESSAGE);
	      }

		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// Listen to the slider.
		JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            int fps = (int)source.getValue();
            if (fps == 0) {
                if (!frozen) pause();
            } else {
                delay = 1000 / fps;
                timer.setDelay(delay);
                timer.setInitialDelay(delay * 10);
                if (frozen) start();
            }
        }
		
	}
	
}