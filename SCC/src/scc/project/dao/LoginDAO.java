package scc.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scc.project.ConnectionHelper;
import scc.project.SCCLogin;

public class LoginDAO {
	SCCLogin login = null;
	Connection c = null;

	protected SCCLogin processRow(ResultSet rs) throws SQLException {
		SCCLogin login = new SCCLogin();
		login.setUsername(rs.getString("username"));
		login.setPassword(rs.getString("password"));
		login.setAccessID(rs.getInt("accessID"));
		return login;
	}
	
	public SCCLogin findByUsername(String username) {

		String sql = "SELECT * FROM Login WHERE username = ?";
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				login = processRow(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return login;

	}

	public void addLogin(String username, String password, int accessType) {

		String sql = "INSERT INTO Login values (?,?,?);";
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, accessType);
			ps.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
