package com.example.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", // DBURL
					"C##BITUSER", // DB User
					"bituser");
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

			String sql = "SELECT no, last_name, first_name, email, createdAt " + " FROM emaillist ORDER BY no DESC";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// 데이터 받아오고
				// 데이터 받기
				Long no = rs.getLong(1);
				String lastName = rs.getString(2);
				String firstName = rs.getString(3);
				String email = rs.getString(4);
				Date createdAt = rs.getDate(5);

				// VO 객체 생성
				EmailVO vo = new EmailVO();
				vo.setNo(no);
				vo.setLastname(lastName);
				vo.setFirstname(firstName);
				vo.setEmail(email);
				vo.setCreatedAt(createdAt);

				// 리스트에 추가
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
		System.out.println(list);
		return list;
	}

	@Override
	public int insert(EmailVO vo) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 실행 계획
			String sql = "INSERT INTO emaillist " + "(no, last_name, first_name, email) "
					+ " VALUES(seq_emaillist_pk.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			// 파라미터 바인딩
			pstmt.setString(1, vo.getLastname());
			pstmt.setString(2, vo.getFirstname());
			pstmt.setString(3, vo.getEmail());

			// 쿼리 수행
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public int delete(Long pk) {
		int deletedCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getConnection();
			String sql = "DELETE FROM emaillist Where no =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, pk);

			deletedCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return deletedCount;
	}

}
