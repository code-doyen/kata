package com.comresource.kata;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KataView extends JPanel implements MouseListener, ActionListener, Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	volatile boolean simulating;
	//create an instance of Canvas 'the view
	Canvas canvas;
	//create an instance of JTextfield
	JTextField currentGeneration, rows, cols;
	//create an instance of Board to store initial life entities
	Board lifeBoard;
	//create an instance of Board to store initial life's offspring entities
	Board offspringBoard;
	//counter for the current generation of life
	private int lifeCycle = 0;
	//controls the speed of simulation
	private long speed = 0;
	//the game thread
    private Thread lifeThread = null;
 
	public KataView(int row, int col) {
		//Initializes currently not simulating
		simulating = false;
		//Instantiates an instance of the Board class 'Model'
		lifeBoard = new Board(row, col);
		//Instantiates an instance of the Board class 'Model'
		offspringBoard = new Board(row, col); 
		draw(); //creates the components that will be add to the instance of JPanel
		update(); // updates the games current state 'Controller'
	}
	
	//updates variances in simulation
	private void update(){
		lifeCycle++;
		//speed = slider value;
	}
	private void draw(){
		//create new border layout
		this.setLayout(new BorderLayout());
		//instantiate userPanel of type JPanel
		JPanel userPanel = new JPanel();
		userPanel.setLayout(new FlowLayout());
		
		//create JTextFields
		rows = new JTextField(3);
		cols = new JTextField(3);
		rows.setEditable(true);
		cols.setEditable(true);
		//create JButtons
		JButton actionButton = new JButton("Begin Simulation\"Set Grid\"");
		
		//add components to user panel
		userPanel.add(new JLabel("Grid Size:"));
		userPanel.add(rows);
		userPanel.add(new JLabel("x"));
		userPanel.add(cols);				
		userPanel.add(actionButton);
				
		canvas = new Canvas();
		canvas.setBackground(new Color(73, 121, 204));
		//canvas.addMouseListener(this);
		add(canvas, BorderLayout.CENTER);
		add(userPanel, BorderLayout.SOUTH);
	}
	private void control(){
		try {
            lifeThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	public void pause() {
        //when the simulating is paused
        //setting the variable to false
		simulating = false;
        try {
            //stopping the thread
            lifeThread.join();
        } catch (InterruptedException e) {
        }
    }

    public void resume() {
        //when the simulating is resumed
        //starting the thread again
        simulating = true;
        lifeThread = new Thread(this);
        lifeThread.start();
    }
	
	@Override
	public void run() {
		while (simulating) {
            //to update the frame
            update();

            //to draw the frame
            draw();

            //to control
            control();
        }
	}
	//private boolean getSimulating() {return simulating;}
	//private void setSimulating(boolean state) {simulating = !state;}
	private class Canvas extends JPanel{ //constructs a visual representation of the player game board
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int wid, hgt, rows, cols;
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			wid = getWidth();
			hgt = getHeight();
			rows = lifeBoard.getRows();
			cols = lifeBoard.getCols();
			System.out.println(rows);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
}
