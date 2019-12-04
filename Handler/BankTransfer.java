package Handler;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class BankTransfer extends JPanel { // 계좌이체
	JLabel lbMyBank;
	JLabel lbMyacc;
	JLabel lbAccountPwd;
	JLabel lbAccMoney;
	JLabel lbYouBank;
	JLabel lbYouacc;
	JTextField tfMyBank;
	JTextField tfMyacc;
	JPasswordField pfAccountPwd;
	JTextField tfAccMoney;
	JTextField tfYouBank;
	JTextField tfYouacc;
	JButton btnJoin;
	JButton btnBack;

	public BankTransfer() {
		lbMyBank = new JLabel("내          은행");
		lbMyacc = new JLabel("내   계좌번호");
		lbAccountPwd = new JLabel("내   비밀번호");
		lbYouBank = new JLabel("상대       은행");
		lbYouacc = new JLabel("상대계좌번호");
		lbAccMoney = new JLabel("이체할   금액");
		tfMyBank = new JTextField();
		tfMyacc = new JTextField();
		pfAccountPwd = new JPasswordField();
		tfYouBank = new JTextField();
		tfYouacc = new JTextField();
		tfAccMoney = new JTextField();
		btnBack = new JButton("뒤로가기");
		btnJoin = new JButton("확   인");

		this.setLayout(null);
		lbMyBank.setBounds(50, 20, 200, 50);
		lbMyacc.setBounds(50, 60, 200, 50);
		lbAccountPwd.setBounds(50, 100, 200, 50);
		lbYouBank.setBounds(50, 165, 200, 50);
		lbYouacc.setBounds(50, 205, 200, 50);
		lbAccMoney.setBounds(50, 245, 200, 50);
		tfMyBank.setBounds(210, 25, 180, 35);
		tfMyacc.setBounds(210, 65, 180, 35);
		pfAccountPwd.setBounds(210, 105, 180, 35);
		tfYouBank.setBounds(210, 175, 180, 35);
		tfYouacc.setBounds(210, 215, 180, 35);
		tfAccMoney.setBounds(210, 255, 180, 35);
		btnJoin.setBounds(455, 260, 100, 45);
		btnBack.setBounds(570, 260, 100, 45);
		
		this.add(lbMyBank);
		this.add(lbMyacc);
		this.add(lbAccountPwd);
		this.add(lbAccMoney);
		this.add(lbYouBank);
		this.add(lbYouacc);
		this.add(tfMyBank);
		this.add(tfMyacc);
		this.add(pfAccountPwd);
		this.add(tfAccMoney);
		this.add(tfYouBank);
		this.add(tfYouacc);
		this.add(btnJoin);
		this.add(btnBack);
		
		ImagePn tuLogo = new ImagePn(450, 20, 220, 200);
		this.add(tuLogo);
		
		this.setBackground(Color.white);
		Color color = new Color(107, 213, 231);
		btnJoin.setBackground(color);
		btnBack.setBackground(color);
		
		Font font = new Font("고딕", Font.BOLD, 23);
		lbMyBank.setFont(font);
		lbMyacc.setFont(font);
		lbAccountPwd.setFont(font);
		lbAccMoney.setFont(font);
		lbYouBank.setFont(font);
		lbYouacc.setFont(font);
		tfMyBank.setFont(font);
		tfMyacc.setFont(font);
		pfAccountPwd.setFont(font);
		tfAccMoney.setFont(font);
		tfYouBank.setFont(font);
		tfYouacc.setFont(font);
		
		Font fontt = new Font("고딕", Font.BOLD, 15);
		btnJoin.setFont(fontt);
		btnBack.setFont(fontt);
	}

}
