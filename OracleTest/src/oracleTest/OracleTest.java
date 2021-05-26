package oracleTest;

import DBPKG.DBConnection;

public class OracleTest {

	public static void main(String[] args) {
		try {
			DBConnection.getConnection();
			System.out.println("오라클 연결 성공");
		} catch (Exception e) {
			System.out.println("오라클 연결 실패");
//			e.printStackTrace();
		}

	}

}
