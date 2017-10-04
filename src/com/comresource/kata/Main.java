package com.comresource.kata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main extends JFrame {
	public static void main(String[] args) {
		JFrame window = new JFrame("Game of Life Kata");
	    window.setContentPane(new KataView(6,8));  //rows, cols
		window.setSize(1024,1024);		
		try {
			window.setIconImage(ImageIO.read(new FileInputStream("img/cell.png")));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		//window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
