package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ATMDao {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public ATMDao() {
		conn = DBConnection.getConnection();
	}

	public String accountInsert(String bank, String acc, String pwd, String name) { // ���»���
		String result = null;
		try {
			String query = "insert into banktable (bank, acc, pwd, name) values ('" + bank + "','" + acc + "','" + pwd
					+ "','" + name + "')";
			System.out.println("SQL : " + query);
			pstm = conn.prepareStatement(query);
			pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("err");
		}
		return result;
	}

	public String updateDeposit(String money, String acc, String pwd, String bank) { // �Ա�
		String result = null;
		try {
			String query;
			if (pwd == null) {
				query = "update banktable set money=money+" + money + " where " + "bank='" + bank + "' and " + "acc='"
						+ acc + "'"; // ��ü�� �Ҷ� ���� ��й�ȣ�� �𸣱⶧���� �� ������ ����
			} else if (accSelect(bank, acc, pwd) == null) {
				return result; // �߸��� ������ ������

			} else {
				query = "update banktable set money=money+" + money + " where " + "bank='" + bank + "' and " + "acc='"
						+ acc + "' and " + "pwd='" + pwd + "'"; // ��� ������ ��������
			}
			System.out.println("SQL : " + query);
			pstm = conn.prepareStatement(query);
			pstm.executeUpdate();
			result = accSelect(bank, acc, pwd);

		} catch (SQLException e) {
			System.out.println("�Աݿ���");
			e.printStackTrace();
		}
		return result;
	}

	public String updateWithdraw(String money, String acc, String pwd, String bank) { // ���
		String result = null;
		try {
			String query = "update banktable set money=money-" + money + " where " + "bank='" + bank + "' and "
					+ "acc='" + acc + "' and " + "pwd='" + pwd + "'";
			System.out.println("SQL : " + query);
			pstm = conn.prepareStatement(query);
			pstm.executeUpdate();
			result = accSelect(bank, acc, pwd);

		} catch (SQLException e) {
			System.out.println("��� ����");
			e.printStackTrace();
		}
		return result;
	}

	public void updateTransfer(String mybank, String myacc, String mypwd, String money, String youBank, String youAcc) {
		/*
		 * ������ü�� �ᱹ ��ü�� ����� ��ó�� ���̱� ������ ��ü �޼ҵ�� ��� �޼ҵ带 ���̿��մϴ�.
		 */
		updateWithdraw(money, myacc, mypwd, mybank);
		updateDeposit(money, youAcc, null, youBank);
	}

	public String accSelect(String bank, String acc, String pwd) {
		/*
		 * �ܾ� ��ȸ �޼ҵ带 �̿��ؼ� ������ ���翩�θ� Ȯ���ϰ�
		 * �ܾ� ��ȸ�� ��ɵ� �����մϴ�.
		 * */
		String result = null;
		try {
			String query;
			if (pwd == null) {
				query = "select money from banktable where acc='" + acc + "' and " + "bank='" + bank + "'";
			} else if (bank == null) {
				query = "select money from banktable where acc='" + acc + "' and " + "pwd='" + pwd + "'";
			} else {
				query = "select money from banktable where acc='" + acc + "' and " + "pwd='" + pwd + "'" + " and bank="
						+ "'" + bank + "'";
			}

			System.out.println("SQL : " + query);
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();

			while (rs.next()) {
				String money = rs.getString(1);
				result = money;
			}
		} catch (SQLException e) {
			System.out.println("�ܾ���ȸ ����");
			e.printStackTrace();
		}
		return result;
	}

	public String accDelete(String bank, String acc, String pwd) { // ���� ����
		String result = null;
		try {
			String query = "delete from banktable where bank='" + bank + "' and " + "acc='" + acc + "' and " + "pwd='"
					+ pwd + "'";
			System.out.println("SQL : " + query);
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
		} catch (Exception e) {
			System.out.println("���»��� ����");
			e.printStackTrace();
		}
		return result;
	}

	public void allSelect() {
		try {
			String query = "SELECT * FROM BANKTABLE";

			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();

			System.out.println("bank acc pwd name money");
			System.out.println("=======================");

			while (rs.next()) {
				String accnum = rs.getString(1);
				String name = rs.getString(2);
				String pwd = rs.getString(3);
				String bank = rs.getString(4);
				String money = rs.getString(5);

				String result = accnum + " " + name + " " + pwd + " " + bank + " " + money;
				System.out.println(result);
			}

		} catch (SQLException e) {
			System.out.println("allselect ����");
			e.printStackTrace();
		}
	}

}