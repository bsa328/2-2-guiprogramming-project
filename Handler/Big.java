package Handler;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Big extends JPanel {
	JButton btnDeposit;
	JButton btnWithdraw;
	JButton btnBankTransfer;
	JButton btnDisplayBalance;
	JButton btnSmall;
	
	public Big() {
		btnDeposit = new JButton("¿‘   ±›");
		btnWithdraw = new JButton("√‚   ±›");
		btnBankTransfer = new JButton("∞Ë¡¬¿Ã√º");
		btnDisplayBalance = new JButton("¿‹æ◊¡∂»∏");
		btnSmall = new JButton("ø¯∑°¥Î∑Œ");
		
		this.setLayout(null);
		btnDeposit.setBounds(20, 40, 190, 100);
		btnWithdraw.setBounds(20, 160, 190, 100);
		btnBankTransfer.setBounds(490, 40, 190, 100);
		btnDisplayBalance.setBounds(490, 160, 190, 100);
		btnSmall.setBounds(260, 250, 170, 50);
		
		ImagePn tuLogo = new ImagePn(230, 30, 200, 200);
		this.add(tuLogo);
		
		Color color = new Color(107, 213, 231);
		btnDeposit.setBackground(color);
		btnWithdraw.setBackground(color);
		btnBankTransfer.setBackground(color);
		btnDisplayBalance.setBackground(color);
		
		Color col = new Color(156, 207, 252);
		btnSmall.setBackground(col);
		
		Font font = new Font("∞ÌµÒ", Font.BOLD, 37);
		btnDeposit.setFont(font);
		btnWithdraw.setFont(font);
		btnBankTransfer.setFont(font);
		btnDisplayBalance.setFont(font);
		
		Font f = new Font("∞ÌµÒ", Font.BOLD, 23);
		btnSmall.setFont(f);
		
		this.setBounds(450, 140, 700, 400);
		this.setBackground(Color.white);
		this.add(btnDeposit);
		this.add(btnWithdraw);
		this.add(btnBankTransfer);
		this.add(btnDisplayBalance);
		this.add(btnSmall);
	}

}
