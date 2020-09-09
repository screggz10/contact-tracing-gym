package scc.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import scc.project.ConnectionHelper;
import scc.project.SCCUser;

public class UserDAO {
	protected SCCUser processRow(ResultSet rs) throws SQLException {
		SCCUser user = new SCCUser();
		user.setUserID(rs.getInt("userID"));
		user.setUserName(rs.getString("userName"));
		user.setGender(rs.getString("gender"));
		user.setEmailAddress(rs.getString("emailAddress"));
		user.setPassword(rs.getString("password"));
		user.setPhoneNumber(rs.getString("phoneNumber"));
		user.setAddress(rs.getString("address"));
		user.setCity(rs.getString("city"));
		return user;
	}
	
	public List<SCCUser> findAll() {
		List<SCCUser> list = new ArrayList<SCCUser>();
		Connection c = null;
		String sql = "SELECT * FROM SCCUser ORDER BY userID";
		try {
			c = ConnectionHelper.getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				list.add(processRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return list;
	}
	
	public SCCUser create(SCCUser user) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement("INSERT INTO SCCUser" + " (userName, gender, emailAddress, password, phoneNumber, address, city)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?)", new String[] { "userID" });
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getGender());
			ps.setString(3, user.getEmailAddress());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getPhoneNumber());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getCity());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			// Update the id in the returned object. This is important as this value must be
			// returned
			int id = rs.getInt(1);
			user.setUserID(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return user;
	}
	
	public SCCUser findByUsername(String username) {
		SCCUser user = new SCCUser();
		Connection c = null;
		String sql = "SELECT * FROM SCCUser WHERE emailAddress = ?";
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = processRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return user;
	}
}
