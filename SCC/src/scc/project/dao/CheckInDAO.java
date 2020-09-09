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
import scc.project.SCCCheckIn;

public class CheckInDAO {
	
	protected SCCCheckIn processRow(ResultSet rs) throws SQLException {
		SCCCheckIn checkIn = new SCCCheckIn();
		checkIn.setCheckInTime(rs.getString("checkInTime"));
		checkIn.setCheckInDate(rs.getString("checkInDate"));
		return checkIn;
	}
	
	public List<SCCCheckIn> findAll() {
		List<SCCCheckIn> list = new ArrayList<SCCCheckIn>();
		Connection c = null;
		String sql = "SELECT * FROM CheckIn ORDER BY checkInDate";
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
	
	public SCCCheckIn addCheckIn(SCCCheckIn checkIn) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO CheckIn VALUES (?,?);";
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, checkIn.getCheckInTime());
			ps.setString(2, checkIn.getCheckInDate());
			ps.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return checkIn;
	}
	
}
