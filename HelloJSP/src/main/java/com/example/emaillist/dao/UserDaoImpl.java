package com.example.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.emaillist.vo.UserVo;

public class UserDaoImpl implements UserDao {

	// Connection
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.dirver.OracleDriver");
			// connection 얻기
			String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			conn = DriverManager.getConnection(dburl, "C##BITUSER", "bituser");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		}
		return conn;
	}

	// 르그인용
	@Override
	public UserVo getUserByEmailandPassworkd(String email, String password) {
		UserVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			String sql = "SELECT no, name, email, gender FROM users WHERE email=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 결과값이 있으면
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String email_str = rs.getString(3);
				String gender = rs.getString(4);

				vo = new UserVo();
				vo.setName(name);
				vo.setNo(no);
				vo.setEmail(email_str);
				vo.setGender(gender);
				System.out.println("User  Found" + vo);

			} else {
				System.out.println("User Not Found");
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				rs.close();
				conn.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return vo;
	}

	@Override
	public int insert(UserVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
