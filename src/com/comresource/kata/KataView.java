package com.comresource.kata;

public class KataView {
	volatile boolean simulating;
	public KataView() {
		simulating = false; 
	}
	
	private void update(){
		
	}
	private void draw(){
		
	}
	private void control(){
		
	}
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
	public boolean getSimulating() {return simulating;}
	public void setSimulating(boolean state) {simulating = state;}
	
}
