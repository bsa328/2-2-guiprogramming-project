package Handler;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Go extends JFrame {
	JLabel label;
	JLabel lbMoney;
	JLabel lbTo;
	JButton btn; // Ȯ�� ��ư

	public Go() {
		JPanel panel = new JPanel();
		this.setBounds(590, 270, 300, 200);
		
		label = new JLabel("��������ü�� �Ϸ�Ǿ����ϴ٢�");
		lbMoney = new JLabel(); // ���� �ݾ�
		lbTo = new JLabel(); // �޴� ���
		btn = new JButton("Ȯ��");
		
		this.setLayout(null);
		label.setBounds(40, 10, 400, 30);
		lbMoney.setBounds(80, 50, 400, 30);
		lbTo.setBounds(80, 80, 400, 30);
		btn.setBounds(120, 130, 60, 30);
		
		this.add(label);
		this.add(lbMoney);
		this.add(lbTo);
		this.add(btn);
		
		Font font = new Font("���", Font.BOLD, 15);
		label.setFont(font);
		lbMoney.setFont(font);
		lbTo.setFont(font);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
