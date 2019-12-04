package Handler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Acc extends JFrame {
	JLabel label;
	JLabel lbBank;
	JLabel lbAcc;
	JButton btn; // 확인 버튼

	public Acc() {
		JPanel ColorPn = new JPanel();
		this.setBounds(590, 270, 300, 200);

		label = new JLabel("▶계좌생성이 완료되었습니다◀");
		lbBank = new JLabel();
		lbAcc = new JLabel();
		btn = new JButton("확인");

		this.setLayout(null);
		label.setBounds(40, 10, 400, 30);
		lbBank.setBounds(80, 50, 400, 30);
		lbAcc.setBounds(80, 80, 400, 30);
		btn.setBounds(120, 130, 60, 30);

		this.add(label);
		this.add(lbBank);
		this.add(lbAcc);
		this.add(btn);
		
		Font font = new Font("고딕", Font.BOLD, 15);
		label.setFont(font);
		lbBank.setFont(font);
		lbAcc.setFont(font);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
