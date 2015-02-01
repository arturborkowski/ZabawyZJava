package gui;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Notatnik extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu menuPlik, menuNarzedzia,menuOpcje, menuPomoc;
	private JMenuItem mOtworz, mZapisz, mWyjscie, mNarz1, mNarz2, mOpcja1, mOProgramie, mpKopiuj, mpWklej, mpDo³acz; 
	private JCheckBoxMenuItem chOpcja2;
	private JTextArea notatnik;
	private JButton bSzukaj, bWybierzKolor;
	private JTextField  tSzukany; 
	private JPopupMenu popup;
	private JComboBox<String> colorCombo;
	private String wybranyTekst;
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Notatnik app = new Notatnik();
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		app.setVisible(true);  
	}

	
	
	
	
	
	
	
	public Notatnik() {

		setSize(600, 600);
		setTitle("Notatnik"); 
		setLayout(null);
		
	
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		menuPlik = new JMenu("Plik");	
		menuBar.add(menuPlik);
		menuPlik.setMnemonic('P');
		
		mOtworz = new JMenuItem("Otwórz", 'O');
		mOtworz.addActionListener(this);
		mZapisz = new JMenuItem("Zapisz", 'Z');
		mZapisz.addActionListener(this);
		mWyjscie = new JMenuItem("Wyjœcie", 'W');
		
		menuPlik.add(mOtworz);
		menuPlik.add(mZapisz);		
		menuPlik.addSeparator();
		menuPlik.add(mWyjscie);
		
		mWyjscie.addActionListener(this);
		mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
		
		
		
		menuNarzedzia = new JMenu("Narzêdzia");
		menuNarzedzia.setMnemonic('N');
		menuBar.add(menuNarzedzia);
		
		mNarz1 = new JMenuItem("Narzêdzie 1");
		mNarz1.setEnabled(false);
		mNarz2 = new JMenuItem("Narzêdzie 2");
		mNarz2.addActionListener(this);
		menuNarzedzia.add(mNarz1);
		menuNarzedzia.add(mNarz2);
		
			menuOpcje = new JMenu("Opcje");
			mOpcja1 = new JMenuItem("Opcja1");
			chOpcja2 = new JCheckBoxMenuItem("Opcja2");
			chOpcja2.addActionListener(this);
			
			menuOpcje.add(mOpcja1);
			menuOpcje.add(chOpcja2);
			
		menuNarzedzia.add(menuOpcje); 
		
			
		menuPomoc = new JMenu("Pomoc");
		menuPomoc.setMnemonic('o');
		menuBar.add(menuPomoc);
		mOProgramie = new JMenuItem("O programie", 'O' );
		mOProgramie.addActionListener(this);
		menuPomoc.add(mOProgramie);
		
		
		// -----------------------------------   //
		
		notatnik = new JTextArea();
		notatnik.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(notatnik);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		scroll.setBounds(50,50,400, 450);
		add(scroll);
		
		
		
		tSzukany = new JTextField();
		tSzukany.addActionListener(this);
		tSzukany.setBounds(50,510,100, 20);
		add(tSzukany);
		
		bSzukaj = new JButton("Szukaj");
		bSzukaj.addActionListener(this);
		bSzukaj.setBounds(150, 510, 100, 20);
		add(bSzukaj);
		
		bWybierzKolor = new JButton("Wybierz kolor");
		bWybierzKolor.addActionListener(this);
		bWybierzKolor.setBounds(260, 510, 150, 20);
		add(bWybierzKolor);
		
		
		popup = new JPopupMenu();
		mpKopiuj = new JMenuItem("Kopiuj");
		mpKopiuj.addActionListener(this);
		
		mpWklej = new JMenuItem("Wklej");
		mpWklej.addActionListener(this);
		
		mpDo³acz = new JMenuItem("Do³¹cz");
		mpDo³acz.addActionListener(this);
		
		popup.add(mpKopiuj);
		popup.add(mpWklej);
		popup.add(mpDo³acz);
		
		notatnik.setComponentPopupMenu(popup); 
		
		
		colorCombo = new JComboBox<String>();
		colorCombo.setBounds(450, 50, 100, 20);
		colorCombo.addItem("Czarny");
		colorCombo.addItem("Czerwony");
		colorCombo.addItem("Zielony");
		colorCombo.addItem("Niebieski");
		colorCombo.addItem("Ró¿owy");
		colorCombo.addActionListener(this);
		add(colorCombo); 
		
	}
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		
		
		if(source == mOtworz) {
			JFileChooser fc = new JFileChooser();
			if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				
				File plik = fc.getSelectedFile();
				//JOptionPane.showMessageDialog(null, "Wybrany plik to "+plik.getAbsolutePath());
				
				try {
					
					Scanner skaner = new Scanner(plik);
					while(skaner.hasNext()) 
						notatnik.append(skaner.nextLine() + "\n");
					
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
		else if(source == mZapisz) {
			JFileChooser fc = new JFileChooser();
			if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				
				File plik = fc.getSelectedFile();
				//JOptionPane.showMessageDialog(null, "Wybrany plik to "+ plik);
				
				try {
					
					PrintWriter pw = new PrintWriter(plik);
					Scanner skaner = new Scanner(notatnik.getText());
					
					while(skaner.hasNext()) 
						pw.println(skaner.nextLine());
					
					pw.close(); 
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
			}
		}
		else if(source == mWyjscie) {  // wyjœcie z aplikacji
			
			String message = "Czy na pewno chcesz opuœciæ program?";
			int odp = JOptionPane.showConfirmDialog(null, message, "Wyjœcie", JOptionPane.YES_NO_OPTION);
			
			if(odp == JOptionPane.YES_OPTION)
				dispose();
			else if (odp == JOptionPane.NO_OPTION)
				JOptionPane.showMessageDialog(null, "Wiedzia³em... :)");
			else if(odp == JOptionPane.CLOSED_OPTION)
				JOptionPane.showMessageDialog(null, "Tak nie robimy", "", JOptionPane.WARNING_MESSAGE);
		}
		
		
		
		if(source == chOpcja2) {
			
			if(chOpcja2.isSelected())     // checkBox opcja2
				mNarz1.setEnabled(true);   
			else 
				mNarz1.setEnabled(false);
		}
		
		
		
		// narzêdzie 2
		if(source == mNarz2) {
			String sMetry = JOptionPane.showInputDialog("Podaj d³ugoœæ w metrach");
			double metry = Double.parseDouble(sMetry);
			double stopy = metry/0.3048;
			String sStopy = String.format("%.2f", stopy);
			
			JOptionPane.showMessageDialog(null, sMetry+ " metrów to "+sStopy+" stóp.");
		}
		
		
		
		// O Programie
		if(source == mOProgramie) {
			String message = "Notatnik v.1.01\nCopyright "+(char) 169+" 2015 Artur Borkowski";
			JOptionPane.showMessageDialog(null, message, "O programie", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		
		
		
		// Szukanie
		if(source == bSzukaj || source == tSzukany) {
			
			String tekst = notatnik.getText().toLowerCase();
			String szukane = tSzukany.getText().toLowerCase();
			String wystapienia = "";
			int licznikWystapien = 0;
			int index;			
			int startIndex = 0;
			
			while((index = tekst.indexOf(szukane, startIndex)) != -1) {
				
				startIndex = index + szukane.length();
				licznikWystapien++;
				wystapienia = wystapienia +" "+index;
			}
			
			if(licznikWystapien != 0) {
				JOptionPane.showMessageDialog(null, "\""+szukane + "\" pojawia siê "+licznikWystapien
						+" razy\nna pozycjach: "+wystapienia);
			}
			else {
				JOptionPane.showMessageDialog(null, "Nie znaleziono podanej frazy.");
			}
		}
		
		
		
		
		// Pop-up menu
		if(source == mpKopiuj) 
			wybranyTekst = notatnik.getSelectedText();
		
		else if(source == mpWklej) 
			notatnik.insert(wybranyTekst, notatnik.getCaretPosition()); 
		
		else if(source == mpDo³acz) 
			notatnik.append("\n" + wybranyTekst);	
		
		
		// combo Box Color
		if(source == colorCombo) {
			String kolor = colorCombo.getSelectedItem().toString();
			
			switch (kolor) {
			case "Czerwony":
				notatnik.setForeground(Color.RED);
				break;
			case "Zielony":
				notatnik.setForeground(Color.GREEN);
				break;
			case "Niebieski":
				notatnik.setForeground(Color.BLUE);
				break;
			case "Ró¿owy":
				notatnik.setForeground(Color.PINK);
				break;
			default:
				notatnik.setForeground(Color.BLACK);
				break;
			}
		}
		
		
		// button wybierz kolor - JColorChooser
		if(source == bWybierzKolor) {
			
			Color wybranyKolor = JColorChooser.showDialog(null, "Wybierz kolor", Color.BLACK);
			notatnik.setForeground(wybranyKolor);
		}
		
		
	}

}
