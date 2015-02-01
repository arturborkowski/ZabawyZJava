package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Okienko {

	
public static void main(String[] args) {
		
		Okienko ok = new Okienko();
		ok.animacja(2);
	}


	JFrame ramka;
	int x, y;
	
	public Okienko() {
		
		ramka = new JFrame("Okienko próbne");
		
		ramka.setSize(500, 520);
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramka.setVisible(true);
		
		
		Kolko rPanel = new Kolko();
		
		
		ramka.getContentPane().add(BorderLayout.CENTER,rPanel);
	}
	
	
	public void animacja(int count) {
		
		for(int j = 0; j< count; j++) {
			animacja(count-1);
		}
		
		x = 0;
		y = 0;
		
		for(int i=0; i< 380; i++) {
			
			x++;
			y++;
			ramka.repaint();
			
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		// w lewo
		for(int i=0; i< 380; i++) {
			
			y--;
			ramka.repaint();
			
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// w lewo-dó³
		for(int i=0; i< 380; i++) {
			
			x--;
			y++;
			ramka.repaint();
			
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// w górê
		for(int i=0; i< 380; i++) {
			
			y--;
			ramka.repaint();
			
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	class Kolko extends JPanel {
		
		@Override
		protected void paintComponent(Graphics g) {
			
			g.setColor(Color.blue);
			g.fillOval(x, y, 100, 100);
		}
	}
	

}
