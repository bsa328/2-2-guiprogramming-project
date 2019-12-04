package Handler;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainView extends JPanel {
	JButton btnAccountCreation;
	JButton btnDeposit;
	JButton btnWithdraw;
	JButton btnBankTransfer;
	JButton btnDisplayBalance;
	JButton btnDeleteAcc;
	JButton btnBig;
	
	public MainView() {
		btnAccountCreation = new JButton("계좌생성");
		btnDeposit = new JButton("입   금");
		btnWithdraw = new JButton("출   금");
		btnBankTransfer = new JButton("계좌이체");
		btnDisplayBalance = new JButton("잔액조회");
		btnDeleteAcc = new JButton("계좌삭제");
		btnBig = new JButton("저시력자용");
		
		ImagePn tuLogo = new ImagePn(230, 30, 200, 200);
		this.add(tuLogo);
		
		this.setLayout(null);
		btnAccountCreation.setBounds(50, 20, 150, 50);
		btnDeposit.setBounds(50, 100, 150, 50);
		btnWithdraw.setBounds(50, 180, 150, 50);
		btnBankTransfer.setBounds(490, 20, 150, 50);
		btnDisplayBalance.setBounds(490, 100, 150, 50);
		btnDeleteAcc.setBounds(490, 180, 150, 50);
		btnBig.setBounds(260, 250, 170, 50);
		
		this.setBackground(Color.white);
		Color color = new Color(107, 213, 231);
		btnAccountCreation.setBackground(color);
		btnDeposit.setBackground(color);
		btnWithdraw.setBackground(color);
		btnBankTransfer.setBackground(color);
		btnDisplayBalance.setBackground(color);
		btnDeleteAcc.setBackground(color);
		
		Color col = new Color(156, 207, 252);
		btnBig.setBackground(col);
		
		this.add(btnAccountCreation);
		this.add(btnDeposit);
		this.add(btnWithdraw);
		this.add(btnBankTransfer);
		this.add(btnDisplayBalance);
		this.add(btnDeleteAcc);
		this.add(btnBig);

		Font font = new Font("고딕", Font.BOLD, 23);
		btnAccountCreation.setFont(font);
		btnDeposit.setFont(font);
		btnWithdraw.setFont(font);
		btnBankTransfer.setFont(font);
		btnDisplayBalance.setFont(font);
		btnDeleteAcc.setFont(font);
		btnBig.setFont(font);
	}
}
