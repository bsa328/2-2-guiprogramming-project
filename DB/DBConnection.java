package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection dbConn;

	public static Connection getConnection() {

		Connection conn = null;
		try {
			String user = "bsa328";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("Database에 연결되었습니다.\n");

		} catch (Exception e) {
			System.out.println("디비 에러");
		}
		return conn;
	}
}

//create table banktable (
//bank varchar2(40) not null,
//acc varchar2(40) primary key,
//pwd varchar2(40) not null,
//name varchar2(40) not null,
//money varchar2(40) default 0
//);