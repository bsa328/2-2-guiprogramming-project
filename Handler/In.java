package Handler;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class In extends JFrame {
	JLabel label;
	JLabel lbIn;
	JLabel lbMoney;
	JButton btn; // 확인 버튼

	public In() {
		JPanel panel = new JPanel();
		this.setBounds(590, 270, 300, 200);
		
		label = new JLabel("▶입금이 완료되었습니다◀");
		lbIn = new JLabel(); // 입금 금액
		lbMoney = new JLabel(); // 입금 후 잔액
		btn = new JButton("확인");
	
		this.setLayout(null);
		label.setBounds(55, 10, 400, 30);
		lbIn.setBounds(80, 50, 400, 30);
		lbMoney.setBounds(80, 80, 400, 30);
		btn.setBounds(120, 130, 60, 30);
		
		this.add(label);
		this.add(lbIn);
		this.add(lbMoney);
		this.add(btn);
		
		Font font = new Font("고딕", Font.BOLD, 15);
		label.setFont(font);
		lbIn.setFont(font);
		lbMoney.setFont(font);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
