package com.toyproject.pos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.toyproject.pos.vo.ProductVo;

public class ProductDaoImpl implements ProductDao {

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##BITUSER", "bituser");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public List<ProductVo> getlist() {

		List<ProductVo> list = new ArrayList();
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "SELECT id, name, price From Product";

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Long id = rs.getLong(1);
				String name = rs.getString(2);
				Long price = rs.getLong(3);

				ProductVo vo = new ProductVo(id, name, price);
				list.add(vo);
			}

		} catch (Exception e) {

		}

		return list;
	}

	@Override
	public int Insert(ProductVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ProductVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductVo> cart(Long pk) {
		List<ProductVo> list = new ArrayList<>();
		
		
		return null;
	}

}
