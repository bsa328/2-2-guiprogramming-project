package Handler;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DeleteAcc extends JPanel { // 계좌 삭제
	JLabel lbBank;
	JLabel lbAccountId;
	JLabel lbAccountPwd;
	JTextField tfBank;
	JTextField tfAccountId;
	JPasswordField pfAccountPwd;
	JButton btnJoin;
	JButton btnBack;

	public DeleteAcc() {
		lbBank = new JLabel("은       행");
		lbAccountId = new JLabel("계좌번호");
		lbAccountPwd = new JLabel("비밀번호");
		tfBank = new JTextField();
		tfAccountId = new JTextField();
		pfAccountPwd = new JPasswordField();
		btnBack = new JButton("뒤로가기");
		btnJoin = new JButton("확   인");
		
		this.setLayout(null);
		lbBank.setBounds(80, 30, 200, 50);
		lbAccountId.setBounds(80, 70, 200, 50);
		lbAccountPwd.setBounds(80, 110, 200, 50);
		tfBank.setBounds(200, 35, 180, 35);
		tfAccountId.setBounds(200, 75, 180, 35);
		pfAccountPwd.setBounds(200, 115, 180, 35);
		btnJoin.setBounds(455, 260, 100, 45);
		btnBack.setBounds(570, 260, 100, 45);
		
		this.add(lbBank);
		this.add(lbAccountId);
		this.add(lbAccountPwd);
		this.add(tfBank);
		this.add(tfAccountId);
		this.add(pfAccountPwd);
		this.add(btnJoin);
		this.add(btnBack);
		
		ImagePn tuLogo = new ImagePn(450, 20, 220, 200);
		this.add(tuLogo);
		
		this.setBackground(Color.white);
		Color color = new Color(107, 213, 231);
		btnJoin.setBackground(color);
		btnBack.setBackground(color);

		Font font = new Font("고딕", Font.BOLD, 23);
		lbBank.setFont(font);
		lbAccountId.setFont(font);
		lbAccountPwd.setFont(font);
		tfBank.setFont(font);
		tfAccountId.setFont(font);
		pfAccountPwd.setFont(font);
		
		Font fontt = new Font("고딕", Font.BOLD, 15);
		btnJoin.setFont(fontt);
		btnBack.setFont(fontt);
	}

}
