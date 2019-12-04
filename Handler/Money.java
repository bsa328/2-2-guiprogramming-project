package Handler;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Money extends JFrame {
	JLabel label;
	JLabel lbBank;
	JLabel lbAcc;
	JLabel lbMoney;
	JButton btn; // 확인 버튼
	
	public Money() {
		JPanel panel = new JPanel();
		this.setBounds(590, 270, 300, 200);
		
		label = new JLabel("▶잔액 확인◀");
		lbBank = new JLabel();
		lbAcc = new JLabel();
		lbMoney = new JLabel();
		btn = new JButton("확인");
		
		this.setLayout(null);
		label.setBounds(100, 10, 400, 30);
		lbBank.setBounds(80, 40, 400, 30);
		lbAcc.setBounds(80, 70, 400, 30);
		lbMoney.setBounds(80, 100, 400, 30);
		btn.setBounds(120, 130, 60, 30);
		
		this.add(label);
		this.add(lbBank);
		this.add(lbAcc);
		this.add(lbMoney);
		this.add(btn);
		
		Font font = new Font("고딕", Font.BOLD, 15);
		label.setFont(font);
		lbBank.setFont(font);
		lbAcc.setFont(font);
		lbMoney.setFont(font);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
