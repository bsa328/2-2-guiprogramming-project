package Handler;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Out extends JFrame {
	JLabel label;
	JLabel lbOut;
	JLabel lbMoney;
	JButton btn; // Ȯ�� ��ư
	
	public Out() {
		JPanel panel = new JPanel();
		this.setBounds(590, 270, 300, 200);
		
		label = new JLabel("������� �Ϸ�Ǿ����ϴ٢�");
		lbOut = new JLabel(); // ��� �ݾ�
		lbMoney = new JLabel(); // �Ա� �� �ܾ�
		btn = new JButton("Ȯ��");
		
		this.setLayout(null);
		label.setBounds(55, 10, 400, 30);
		lbOut.setBounds(80, 50, 400, 30);
		lbMoney.setBounds(80, 80, 400, 30);
		btn.setBounds(120, 130, 60, 30);
		
		this.add(label);
		this.add(lbOut);
		this.add(lbMoney);
		this.add(btn);
		
		Font font = new Font("���", Font.BOLD, 15);
		label.setFont(font);
		lbOut.setFont(font);
		lbMoney.setFont(font);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}