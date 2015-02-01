package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CelsiusToFahrenheit extends JFrame implements ChangeListener{

	
	private JLabel lCelsius, lFahrenheit;
	private JSlider sCelsius, sFahrenheit;
	private int tempCelsius, tempFahrenheit;
	
	
	
	public CelsiusToFahrenheit() {
		setSize(500, 300);
		setLayout(null);
		setTitle("Przeliczanie stopni Celsjusza na Fahrenheita");
		
		sCelsius = new JSlider(0, 100, 0);
		sCelsius.setBounds(50, 50, 300, 50);
		sCelsius.setMajorTickSpacing(20);
		sCelsius.setMinorTickSpacing(5);
		sCelsius.setPaintTicks(true);
		sCelsius.setPaintLabels(true);
		sCelsius.addChangeListener(this);
		add(sCelsius);
		
		sFahrenheit = new JSlider(30, 212, 30);
		sFahrenheit.setBounds(50, 170, 300, 50);
		sFahrenheit.setMajorTickSpacing(20);
		sFahrenheit.setMinorTickSpacing(5);
		sFahrenheit.setPaintTicks(true);
		sFahrenheit.setPaintLabels(true);
		sFahrenheit.addChangeListener(this);
		add(sFahrenheit);
		
		
		lCelsius = new JLabel("Stopnie celsjusza:");
		lCelsius.setBounds(50, 0, 150, 50);
		add(lCelsius);
		
		lFahrenheit = new JLabel("Stopnie fahrenheita:");
		lFahrenheit.setBounds(50, 120, 150, 50);
		add(lFahrenheit);
		
	}

	public static void main(String[] args) {

		CelsiusToFahrenheit app = new CelsiusToFahrenheit();
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		app.setVisible(true);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		Object s = e.getSource();
		
		if(s == sCelsius) {
			tempCelsius = sCelsius.getValue();
			lCelsius.setText("Stopnie Celsjusza: "+tempCelsius);
			tempFahrenheit = (int) Math.round(32 + (9.0/5.0)*tempCelsius);
			lFahrenheit.setText("Stopnie Fahrenheita: "+String.valueOf(tempFahrenheit));
			sFahrenheit.setValue(tempFahrenheit);
		}
		else {
			tempFahrenheit = sFahrenheit.getValue();
			lFahrenheit.setText("Stopnie Fahrenheita: "+tempFahrenheit);
			tempCelsius = (int) Math.round((5.0*(tempFahrenheit-32))/9.0);
			lCelsius.setText("Stopnie Celsjusza: "+String.valueOf(tempCelsius));
			sCelsius.setValue(tempCelsius);
		}
		
	}



}
