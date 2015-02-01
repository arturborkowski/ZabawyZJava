package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PasswordFieldTest extends JFrame implements ActionListener{

	private JTextArea notatnik;
	private JScrollPane scrollPane;
	private JButton bDodajUzytkownika;
	private PanelHasla panelHasla;
	
	
	
	public static void main(String[] args) {
		
		PasswordFieldTest app = new PasswordFieldTest();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
	
	
	public PasswordFieldTest() {

		setTitle("Test pola password");
		setSize(400, 400);
		setLayout(null);
		
		notatnik = new JTextArea();
		notatnik.setWrapStyleWord(true);
		
		scrollPane = new JScrollPane(notatnik);
		scrollPane.setBounds(50, 20, 280, 300);
		add(scrollPane);
		
		bDodajUzytkownika = new JButton("Dodaj u¿ytkownika");
		bDodajUzytkownika.setBounds(115, 325, 150, 20);
		add(bDodajUzytkownika);
		bDodajUzytkownika.addActionListener(this);
		
		/*pHaslo = new JPasswordField();
		pHaslo.setBounds(50, 50, 150, 20);
		pHaslo.addActionListener(this);
		add(pHaslo);*/
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(panelHasla == null)
			panelHasla = new PanelHasla(this);
		
		panelHasla.clean();
		panelHasla.setVisible(true); 
		panelHasla.setFocus(); 
		
		if(panelHasla.isOk()) {
			notatnik.append(panelHasla.getUser()+", "+panelHasla.getPassword()+"\n");
		 }
		
	}

}


	class PanelHasla extends JDialog implements ActionListener {

		private JLabel lUser, lHaslo;
		private JTextField tUser;
		private JPasswordField pHaslo;
		private JButton bOk, bCancel;
		private boolean okData;
		
		public PanelHasla(JFrame owner) {
			super(owner, "Wprowadzanie has³a", true);
			setSize(300, 200);
			setLayout(null);
			
			
			lUser = new JLabel("U¿ytkownik:", JLabel.RIGHT);
			lUser.setBounds(0, 40, 100, 20);
			add(lUser);
			
			tUser = new JTextField();
			tUser.setBounds(120, 40, 100, 20);
			tUser.addActionListener(this);
			add(tUser);
			
			lHaslo = new JLabel("Has³o:", JLabel.RIGHT);
			lHaslo.setBounds(0, 65, 100, 20);
			add(lHaslo);
			
			pHaslo = new JPasswordField();
			pHaslo.setBounds(120, 65, 100, 20);
			pHaslo.addActionListener(this);
			add(pHaslo);
			
			bOk = new JButton("Ok");
			bOk.setBounds(50, 100, 80, 20);
			bOk.addActionListener(this);
			add(bOk);
			
			bCancel = new JButton("Cancel");
			bCancel.setBounds(150, 100, 100, 20);
			bCancel.addActionListener(this);
			add(bCancel);
			
		}
		
		public String getUser() {
			return tUser.getText();
		}
		
		public String getPassword() {
			return new String(pHaslo.getPassword());
		}
	
		
		public boolean isOk() {
			return okData;
		}
		
		public void clean() {
			tUser.setText("");
			pHaslo.setText("");
		}
		
		
		public void setFocus() {
			tUser.requestFocusInWindow();
		}
		
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Object z = e.getSource();
			
			if(z == bOk || z == pHaslo || z == tUser) {
				if(tUser.getText().length()*pHaslo.getText().length() != 0) {
					okData = true;
					setVisible(false);
				}
				else 
					clean();
			}
			else { 
				okData = false;
				setVisible(false);
			}
			
			
		}
	
	}
