package gui;


import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class RownanieGUI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tA, tB, tC, tWynik;
	private JLabel lA, lB, lC;
	private JButton bWyjscie, bRozwiaz;
	private JMenuBar menuBar;
	private JMenu menuPlik, menuNarzedzia,menuOpcje, menuPomoc;
	private JMenuItem mOtworz, mZapisz, mWyjscie, mNarz1, mNarz2, mOpcja1, mOProgramie; 
	private JCheckBoxMenuItem chOpcja2;
	
	
	public RownanieGUI() {

		setSize(400, 400);
		setTitle("Rozwi¹zywanie równania kwadratowego");
		setLayout(null);
		
		lA = new JLabel("a ", JLabel.RIGHT);
		lA.setBounds(10, 50, 30, 20);
		add(lA);
		
		tA = new JTextField();
		tA.setBounds(60, 50, 50, 20);
		add(tA);
		tA.setToolTipText("Wstaw wartoœæ przy x^2");
		
		lB = new JLabel("b ", JLabel.RIGHT);
		lB.setBounds(120, 50, 30, 20);
		add(lB);
		
		tB = new JTextField();
		tB.setBounds(170, 50, 50, 20);
		add(tB);
		tB.setToolTipText("Wstaw wartoœæ przy x");
		
		lC = new JLabel("c ", JLabel.RIGHT);
		lC.setBounds(230, 50, 30, 20);
		add(lC);
		
		tC = new JTextField();
		tC.setBounds(280, 50, 50, 20);
		add(tC);
		tC.setToolTipText("Wstaw wyraz wolny");
		
		bRozwiaz = new JButton("Rozwi¹¿ równanie");
		bRozwiaz.setBounds(50, 100, 150, 40);
		add(bRozwiaz);
		bRozwiaz.addActionListener(this);
		
		bWyjscie = new JButton("Wyjœcie");
		bWyjscie.setBounds(200, 100, 100, 40);
		add(bWyjscie);
		bWyjscie.addActionListener(this);
		
		tWynik = new JTextField();
		tWynik.setBounds(5, 200, 370, 30);
		add(tWynik);
		
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
		
			
			menuBar.add(Box.createHorizontalGlue());
			
		menuPomoc = new JMenu("Pomoc");
		menuPomoc.setMnemonic('o');
		menuBar.add(menuPomoc);
		mOProgramie = new JMenuItem("O programie", 'O' );
		mOProgramie.addActionListener(this);
		menuPomoc.add(mOProgramie);
		
		
		
	}
	
	public static void main(String[] args) {
		
		RownanieGUI app = new RownanieGUI();
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		app.setVisible(true);  
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		
		
		if(source == mOtworz) {
			JFileChooser fc = new JFileChooser();
			if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				
				File plik = fc.getSelectedFile();
				JOptionPane.showMessageDialog(null, "Wybrany plik to "+plik.getAbsolutePath());
			}
		}
		else if(source == mZapisz) {
			JFileChooser fc = new JFileChooser();
			if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				
				File plik = fc.getSelectedFile();
				JOptionPane.showMessageDialog(null, "Wybrany plik to "+ plik);
			}
		}
		else if(source == bWyjscie || source == mWyjscie) {  // wyjœcie z aplikacji
			
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
		
		
		if(source == bRozwiaz) {			// przycisk rozwi¹¿
			
			if (tA.getText().length()*tB.getText().length()*tC.getText().length() != 0) {
				int a = Integer.parseInt(tA.getText());
				int b = Integer.parseInt(tB.getText());
				int c = Integer.parseInt(tC.getText());
				
				RownanieKwadratowe rownanie = new RownanieKwadratowe(a, b, c);
				
				String rozw = rownanie.rozwiaz();
				
				tWynik.setText(rozw);
			}
			else {
				tWynik.setText("Musisz wype³niæ wszystkie pola!");
			}
		}
		
		
		if(source == mNarz2) {
			String sMetry = JOptionPane.showInputDialog("Podaj d³ugoœæ w metrach");
			double metry = Double.parseDouble(sMetry);
			double stopy = metry/0.3048;
			String sStopy = String.format("%.2f", stopy);
			
			JOptionPane.showMessageDialog(null, sMetry+ " metrów to "+sStopy+" stóp.");
		}
		
		
		if(source == mOProgramie) {
			String message = "Program demonstruje u¿ycie JMenuBar i JMenu\noraz oblicza równanie kwadratowe.\nWersja 0.9b";
			JOptionPane.showMessageDialog(null, message, "O programie", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}

}
