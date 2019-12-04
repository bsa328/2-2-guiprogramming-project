package Handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class ATMframe extends JFrame {
	JMenu menu;
	JMenuBar menuBar;
	JMenuItem Item;
	InfoPn info;

	public ATMframe() {
		Controller controller = new Controller();
		Big big = new Big();
		menuBar = new JMenuBar();
		menu = new JMenu("메뉴");
		menuBar.add(menu);
		Item = new JMenuItem("정보");
		menu.add(Item);
		Item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "              컴퓨터공학과 17110076 배수아\n" + "              컴퓨터공학과 17110105 최오연" , "만든이", JOptionPane.PLAIN_MESSAGE);
			}
		});
		this.setJMenuBar(menuBar);
		this.setTitle("ATM");
		this.add(controller);
		this.setBounds(430, 170, 700, 380);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (Exception e) {
		}
		new ATMframe();
	}

}
