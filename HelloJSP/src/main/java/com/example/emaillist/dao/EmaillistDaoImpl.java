package com.example.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.example.emaillist.vo.EmailVO;

public class EmaillistDaoImpl implements EmaillistDao {
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Connection 가져오기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "C##BITUSER", "bituser");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public List<EmailVO> getlist() {
		List<EmailVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "SELECT no, first_name, last_name, email" + "FROM emaillist";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// 데이터 받아오고
				Long no = rs.getLong(1);
				String last_name = rs.getString(2);
				String first_name = rs.getString(3);
				String email = rs.getString(4);
				Date createdAt = rs.getDate(5);

				// VO 객체 생성
				EmailVO vo = new EmailVO(no, last_name, first_name, email, createdAt);

				// list에 추가
				list.add(vo);
			}

		} catch (SQLException e) {
			System.err.println("SQL 에러!!!");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int insert(EmailVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long pk) {
		// TODO Auto-generated method stub
		return 0;
	}

}
