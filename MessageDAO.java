package com.message.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private int cnt;
	private String sql;

	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// 1. OracleDriver Ŭ������ �ش� ��ġ�� ���°��(ojdbc6.jar ������)
			// �ذ��� : WEB-INF -> lib -> ojdbc6.jar ����

			// 2. OracleDriver ��ΰ� ��Ÿ�ΰ��
			e.printStackTrace();
		} catch (SQLException e) {
			// DB���� ������ ��Ȯ���� ���� ���
			e.printStackTrace();
		}
	}

	// DB�������� -> ���� ���� ������ ��������
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
