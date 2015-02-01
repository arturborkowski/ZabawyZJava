package serializacja;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class KartaQuizowaEdytor {

	private JTextArea pytanie;
	private JTextArea odpowiedz;
	private ArrayList<KartaQuizowa> listaKart;
	private JFrame ramka;

	public static void main(String[] args) {
		KartaQuizowaEdytor edytor = new KartaQuizowaEdytor();
		edytor.doDziela();
	}
	
	
	public void doDziela() {
		// utworzenie graficznego interfejsu u¿ytkownika
		
		ramka = new JFrame("Edytor kart quizowych");
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelGlowny = new JPanel();
		
		Font czcionkaDuza = new Font("SansSerif", Font.BOLD, 24);
		
		pytanie = new JTextArea(6,20);
		pytanie.setLineWrap(true);
		pytanie.setWrapStyleWord(true);
		pytanie.setFont(czcionkaDuza);
		
		JScrollPane przewijaniePyt = new JScrollPane(pytanie);
		przewijaniePyt.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		przewijaniePyt.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		odpowiedz = new JTextArea(6,20);
		odpowiedz.setLineWrap(true);
		odpowiedz.setWrapStyleWord(true);
		odpowiedz.setFont(czcionkaDuza);
		
		JScrollPane przewijanieOdp = new JScrollPane(odpowiedz);
		przewijanieOdp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		przewijanieOdp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton przyciskNastepna = new JButton("Nastêpna karta");
		
		listaKart = new ArrayList<KartaQuizowa>();
		
		JLabel etykietaPyt = new JLabel("Pytanie:");
		JLabel etykietaOdp = new JLabel("OdpowiedŸ:");
		
		
		panelGlowny.add(etykietaPyt);
		panelGlowny.add(przewijaniePyt);
		panelGlowny.add(etykietaOdp);
		panelGlowny.add(przewijanieOdp);
		panelGlowny.add(przyciskNastepna);
		przyciskNastepna.addActionListener(new NastepnaKartaListener());
		
		JMenuBar menu = new JMenuBar();
		JMenu menuPlik = new JMenu("Plik");
		JMenuItem opcjaNowa = new JMenuItem("Nowy");
		JMenuItem opcjaZapisz = new JMenuItem("Zapisz");
		JMenuItem opcjaWyjdz = new JMenuItem("Wyjœcie");
		
		opcjaNowa.addActionListener(new NowyMenuListener());
		opcjaZapisz.addActionListener(new ZapiszMenuListener());
		opcjaWyjdz.addActionListener(new WyjdzMenuListener());
		
		menuPlik.add(opcjaNowa);
		menuPlik.add(opcjaZapisz);
		menuPlik.addSeparator();
		menuPlik.add(opcjaWyjdz);
		
		menu.add(menuPlik);
		
		ramka.setJMenuBar(menu);
		ramka.getContentPane().add(BorderLayout.CENTER, panelGlowny);
		ramka.setSize(500, 600);
		ramka.setVisible(true);
	}
	
	public class NastepnaKartaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			KartaQuizowa karta = new KartaQuizowa(pytanie.getText(), odpowiedz.getText());
			listaKart.add(karta);
			czyscKarte();
		}
		
	}
	
	
	public class NowyMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			listaKart.clear();
			czyscKarte();
		}
		
	}
	
	
	public class ZapiszMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			KartaQuizowa karta = new KartaQuizowa(pytanie.getText(), odpowiedz.getText());
			listaKart.add(karta);
			
			JFileChooser plikDanych = new JFileChooser();
			plikDanych.showSaveDialog(ramka);
			zapiszPlik(plikDanych.getSelectedFile());
		}
		
	}
	
	
	public class WyjdzMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ramka.dispose();			
		}
		
	}
	
	
	public void czyscKarte() {
		pytanie.setText("");
		odpowiedz.setText("");
		pytanie.requestFocus();
	}
	
	
	
	public void zapiszPlik(File plik) {
		
		try {
			BufferedWriter pisarz = new BufferedWriter(new FileWriter(plik));
			
			for(KartaQuizowa karta: listaKart) {
				pisarz.write(karta.getPytanie() + "/");
				pisarz.write(karta.getOdpowiedz() + "\n");
			}
			
			pisarz.close();
			
		} catch (IOException e) {
			System.out.println("Nie mo¿na zapisaæ pliku kart!");
			e.printStackTrace();
		}
	}
	
}
