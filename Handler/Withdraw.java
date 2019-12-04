package Handler;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Withdraw extends JPanel { // ���
	JLabel lbBank;
	JLabel lbAccountId;
	JLabel lbAccountPwd;
	JLabel lbAmountWithdraw;
	JTextField tfBank;
	JTextField tfAccountId;
	JPasswordField pfAccountPwd;
	JTextField tfAmountWithdraw;
	JButton btnJoin;
	JButton btnBack;

	public Withdraw() {
		lbBank = new JLabel("��       ��");
		lbAccountId = new JLabel("���¹�ȣ");
		lbAccountPwd = new JLabel("��й�ȣ");
		lbAmountWithdraw = new JLabel("��ݱݾ�");
		tfBank = new JTextField();
		tfAccountId = new JTextField();
		pfAccountPwd = new JPasswordField();
		tfAmountWithdraw = new JTextField();
		btnBack = new JButton("�ڷΰ���");
		btnJoin = new JButton("Ȯ   ��");

		this.setLayout(null);
		lbBank.setBounds(80, 30, 200, 50);
		lbAccountId.setBounds(80, 70, 200, 50);
		lbAccountPwd.setBounds(80, 110, 200, 50);
		lbAmountWithdraw.setBounds(80, 150, 200, 50);
		tfBank.setBounds(200, 35, 180, 35);
		tfAccountId.setBounds(200, 75, 180, 35);
		pfAccountPwd.setBounds(200, 115, 180, 35);
		tfAmountWithdraw.setBounds(200, 155, 180, 35);
		btnJoin.setBounds(455, 260, 100, 45);
		btnBack.setBounds(570, 260, 100, 45);

		this.add(lbBank);
		this.add(lbAccountId);
		this.add(lbAccountPwd);
		this.add(lbAmountWithdraw);
		this.add(tfBank);
		this.add(tfAccountId);
		this.add(pfAccountPwd);
		this.add(tfAmountWithdraw);
		this.add(btnJoin);
		this.add(btnBack);
		
		ImagePn tuLogo = new ImagePn(450, 20, 220, 200);
		this.add(tuLogo);
		
		this.setBackground(Color.white);
		Color color = new Color(107, 213, 231);
		btnJoin.setBackground(color);
		btnBack.setBackground(color);

		Font font = new Font("���", Font.BOLD, 23);
		lbBank.setFont(font);
		lbAccountId.setFont(font);
		lbAccountPwd.setFont(font);
		lbAmountWithdraw.setFont(font);
		tfBank.setFont(font);
		tfAccountId.setFont(font);
		pfAccountPwd.setFont(font);
		tfAmountWithdraw.setFont(font);
		
		Font fontt = new Font("���", Font.BOLD, 15);
		btnJoin.setFont(fontt);
		btnBack.setFont(fontt);
	}

}
