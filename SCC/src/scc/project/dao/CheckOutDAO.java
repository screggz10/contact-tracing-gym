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
import scc.project.SCCCheckOut;

public class CheckOutDAO {
	
	protected SCCCheckOut processRow(ResultSet rs) throws SQLException {
		SCCCheckOut checkOut = new SCCCheckOut();
		checkOut.setCheckOutTime(rs.getString("checkOutTime"));
		checkOut.setCheckOutDate(rs.getString("checkOutDate"));
		return checkOut;
	}
	
	public List<SCCCheckOut> findAll() {
		List<SCCCheckOut> list = new ArrayList<SCCCheckOut>();
		Connection c = null;
		String sql = "SELECT * FROM CheckOut ORDER BY checkOutDate";
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
	
	public SCCCheckOut addCheckOut(SCCCheckOut checkOut) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO CheckOut VALUES (?,?);";
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, checkOut.getCheckOutTime());
			ps.setString(2, checkOut.getCheckOutDate());
			ps.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return checkOut;
	}
}
