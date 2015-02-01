package midiApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.sound.midi.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MuzaTester1 {

	static JFrame ramka = new JFrame("Moje pierwsze muzyczne wideo");
	static MojPanelGraf panel;
	
	public static void main(String[] args) {
		
		MuzaTester1 muza = new MuzaTester1();
		muza.doRoboty();
		
	}  // koniec metody main
	
	
	
	public void konfiguracjaGUI() {
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new MojPanelGraf();
		ramka.setContentPane(panel);
		ramka.setBounds(30, 30, 300, 300);
		ramka.setVisible(true);
	} //koniec metody
	
	
	
	public void doRoboty() {
		
		konfiguracjaGUI();
		
		try {
			Sequencer sekwenser = MidiSystem.getSequencer();
			sekwenser.open();
			
			int[] zdarzeniaObslugiwane = {127};
			sekwenser.addControllerEventListener(panel, zdarzeniaObslugiwane);
			
			Sequence sekw = new Sequence(Sequence.PPQ, 4);
			Track sciezka = sekw.createTrack();
			
			int r = 0;
			
			for(int i = 5; i < 61; i+=2) {
				
				r = (int)((Math.random()*50)+1);
				sciezka.add(tworzZdarzenie(144, 1, r, 100, i));
				sciezka.add(tworzZdarzenie(176, 1, 127, 0, i));
				sciezka.add(tworzZdarzenie(128, 1, r, 100, i + 2));
			}  // koniec pêtli
			
			
			sekwenser.setSequence(sekw);
			sekwenser.setTempoInBPM(180);
			sekwenser.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // koniec metody doRoboty()
	
	
	public static MidiEvent tworzZdarzenie(int plc, int kanal, int jeden, int dwa, int takt) {
		MidiEvent zdarzenie = null;
		
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(plc, kanal, jeden, dwa);
			zdarzenie = new MidiEvent(a, takt);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		
		return zdarzenie;
	}


	class MojPanelGraf extends JPanel implements ControllerEventListener {

		boolean komunikat = false;
		
		@Override
		public void controlChange(ShortMessage event) {
			komunikat = true;
			panel.repaint();			
		}
		
		public void paintComponent(Graphics g) {
			if(komunikat) {
				
				Graphics2D g2d = (Graphics2D) g;
				
				int red = (int)(Math.random() * 256);
				int green = (int)(Math.random() * 256);
				int blue = (int)(Math.random() * 256);
				
				g.setColor(new Color(red, green, blue));
				
				int wys = (int) ((Math.random() * 120) + 10);
				int szer = (int) ((Math.random() * 120) + 10);
				
				int x =  (int) ((Math.random() * 40) + 10);
				int y =  (int) ((Math.random() * 40) + 10);
				
				g.fillRect(x, y, wys, szer);
				komunikat = false;
			} // koniec if
		} // koniec metody PaintComponent()
	} // koniec metody MojPanelGraf	
} // koniec klasy


