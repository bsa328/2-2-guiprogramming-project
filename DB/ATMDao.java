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

	public String accountInsert(String bank, String acc, String pwd, String name) { // 계좌생성
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

	public String updateDeposit(String money, String acc, String pwd, String bank) { // 입금
		String result = null;
		try {
			String query;
			if (pwd == null) {
				query = "update banktable set money=money+" + money + " where " + "bank='" + bank + "' and " + "acc='"
						+ acc + "'"; // 이체를 할때 상대방 비밀번호를 모르기때문에 위 쿼리문 실행
			} else if (accSelect(bank, acc, pwd) == null) {
				return result; // 잘못된 정보가 들어오면

			} else {
				query = "update banktable set money=money+" + money + " where " + "bank='" + bank + "' and " + "acc='"
						+ acc + "' and " + "pwd='" + pwd + "'"; // 모든 정보가 들어왔을때
			}
			System.out.println("SQL : " + query);
			pstm = conn.prepareStatement(query);
			pstm.executeUpdate();
			result = accSelect(bank, acc, pwd);

		} catch (SQLException e) {
			System.out.println("입금에러");
			e.printStackTrace();
		}
		return result;
	}

	public String updateWithdraw(String money, String acc, String pwd, String bank) { // 출금
		String result = null;
		try {
			String query = "update banktable set money=money-" + money + " where " + "bank='" + bank + "' and "
					+ "acc='" + acc + "' and " + "pwd='" + pwd + "'";
			System.out.println("SQL : " + query);
			pstm = conn.prepareStatement(query);
			pstm.executeUpdate();
			result = accSelect(bank, acc, pwd);

		} catch (SQLException e) {
			System.out.println("출금 에러");
			e.printStackTrace();
		}
		return result;
	}

	public void updateTransfer(String mybank, String myacc, String mypwd, String money, String youBank, String youAcc) {
		/*
		 * 계좌이체는 결국 이체와 출금이 합처진 것이기 때문에 이체 메소드와 출금 메소드를 재이용합니다.
		 */
		updateWithdraw(money, myacc, mypwd, mybank);
		updateDeposit(money, youAcc, null, youBank);
	}

	public String accSelect(String bank, String acc, String pwd) {
		/*
		 * 잔액 조회 메소드를 이용해서 계좌의 존재여부를 확인하고
		 * 잔액 조회의 기능도 실행합니다.
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
			System.out.println("잔액조회 에러");
			e.printStackTrace();
		}
		return result;
	}

	public String accDelete(String bank, String acc, String pwd) { // 계좌 삭제
		String result = null;
		try {
			String query = "delete from banktable where bank='" + bank + "' and " + "acc='" + acc + "' and " + "pwd='"
					+ pwd + "'";
			System.out.println("SQL : " + query);
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
		} catch (Exception e) {
			System.out.println("계좌삭제 에러");
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
			System.out.println("allselect 에러");
			e.printStackTrace();
		}
	}

}