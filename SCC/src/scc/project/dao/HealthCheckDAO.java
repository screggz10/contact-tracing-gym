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
import scc.project.HealthCheck;
import scc.project.SCCUser;

public class HealthCheckDAO {
	protected HealthCheck processRow(ResultSet rs) throws SQLException {
		HealthCheck check = new HealthCheck();
		check.setFever(rs.getString("fever"));
		check.setCough(rs.getString("cough"));
		check.setBreathless(rs.getString("breathless"));
		check.setSoreThroat(rs.getString("soreThroat"));
		check.setChestPain(rs.getString("chestPain"));
		check.setConfirmedCase(rs.getString("confirmedCase"));
		check.setTravel(rs.getString("travel"));
		check.setTime(rs.getString("time"));
		check.setDate(rs.getString("date"));
		return check;
	}
	
	public List<HealthCheck> findAll() {
		List<HealthCheck> list = new ArrayList<HealthCheck>();
		Connection c = null;
		String sql = "SELECT * FROM HealthCheck";
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
	
	public HealthCheck create(HealthCheck check) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO HealthCheck VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, check.getFever());
			ps.setString(2, check.getCough());
			ps.setString(3, check.getBreathless());
			ps.setString(4, check.getSoreThroat());
			ps.setString(5, check.getChestPain());
			ps.setString(6, check.getConfirmedCase());
			ps.setString(7, check.getTravel());
			ps.setString(8, check.getTime());
			ps.setString(9, check.getDate());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return check;
	}
}
