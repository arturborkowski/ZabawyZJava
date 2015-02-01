import java.awt.Toolkit;
import java.awt.Dimension;

import javax.swing.*;


public class Swing extends JFrame {


	
	public Swing() {
		
		this.setSize(400, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Mariolka jest super!");
		
		JPanel thePanel = new JPanel();
	
		JLabel label1 = new JLabel("Powiedz mi coœ");
		
		thePanel.add(label1);
		label1.setText("Nowy tekst");
		label1.setToolTipText("Nic nie robi :P");
		
		JButton button = new JButton("Send");
		button.setToolTipText("To jest guzik.");
		
		thePanel.add(button);
		
		
		
		this.add(thePanel);
		this.setVisible(true);
	}
	
	JButton button = new JButton("Push");

}
