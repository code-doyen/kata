package com.comresource.kata;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame("Game of Life Kata");
	    window.setContentPane(new KataView(3,3));  
		window.setSize(1024,1024);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
