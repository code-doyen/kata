package com.comresource.kata;

import javax.swing.JFrame;

public class Main extends JFrame {
	public static void main(String[] args) {
		JFrame window = new JFrame("Game of Life Kata");
	    window.setContentPane(new KataView(6,8));  //rows, cols
		window.setSize(1024,1024);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		//window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
