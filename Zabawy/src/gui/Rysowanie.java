package gui;

import java.awt.*;
import javax.swing.*;

public class Rysowanie extends JPanel {

	
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		Color kolorPocz = new Color(red, green, blue);
		
		 red = (int) (Math.random() * 256);
	     green = (int) (Math.random() * 256);
		 blue = (int) (Math.random() * 256);
		 Color kolorKonca = new Color(red, green, blue);
		
		
		
		Graphics2D g2d = (Graphics2D) g;
		
		GradientPaint gradient = new GradientPaint(70, 70, kolorPocz, 150, 150, kolorKonca);
		
		
		
		
		g2d.setPaint(gradient);
		g2d.fillOval(80, 70, 100, 100);
	}
	
	
}
