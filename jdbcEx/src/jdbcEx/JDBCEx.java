package jdbcEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCEx {

	public static void main(String[] args) {
		Connection conn = null;
		
		//DB url 변수
		//String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pw = "tiger";
		
		//SQL 문장 실행을 도와줄 객체
		Statement stmt = null;//SQL을 실행할 수 있는 객체
		PreparedStatement pstmt = null;//SQL을 실행할 수 있는 객체
		
		ResultSet rs = null;//SELECT 결과 저장 변수
		String sql = null;
		
		try {
			//jdbc 드라이버를 메모리에 올림, 로딩.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB 정보로 커넷션 객체 생성
			conn = DriverManager.getConnection(url, id, pw);
//			System.out.println(conn);
			// Statement 객체 생성
			// sql문을 데이터베이스로 실행을 요청하기 위함
			stmt = conn.createStatement();
			
//			sql="CREATE TABLE PEOPLE(NAME VARCHAR(20), AGE NUMBER)"
//			stmt.executeUpdate(sql);
			
			//INSERT SQL
//			sql = "INSERT INTO PEOPLE VALUES(?, ?)";
//			
//			//SQL 문장을 파라미터로 PreparedStatement 객체 생성
//			pstmt=conn.prepareStatement(sql);
//			
//			//첫번째 매개변수로 전달할 값
//			pstmt.setString(1, "홍길동");
//			//두번째 매개변수로 전달할 값
//			pstmt.setInt(2, 18);
//			//맵핑 결과 SQL문 -> INSERT INTO PEOPLE VALUE("홍길동", 18)
//			int insert = pstmt.executeUpdate();
//			//결과확인
//			System.out.println(insert+"개의 행이 입력되었습니다.");
			//SELECT문, 데이터 조회
			sql="SELECT * FROM PEOPLE";
			rs = stmt.executeQuery(sql);
			String name;
			int age;
			System.out.println("------------------------");
			while(rs.next()) {
				//name컬럼의 값을 담을 name변수
				name = rs.getString("name");
				//age컬럼의 값을 담을 age변수
				age = rs.getInt("age");
				System.out.println("이름 : "+name+" 나이 : "+age);
			}
			System.out.println("------------------------");
			
			//UPDATE SQL
//			sql = "UPDATE PEOPLE SET AGE = ? WHERE NAME = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, 20);
//			pstmt.setString(2, "홍길동");
//			
//			int update = pstmt.executeUpdate();
//			System.out.println(update+"개의 행이 업데이트 되었습니다.");
					
			//DELETE SQL
			sql="DELETE FROM PEOPLE WHERE AGE=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 20);

			System.out.println(pstmt.executeUpdate());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
