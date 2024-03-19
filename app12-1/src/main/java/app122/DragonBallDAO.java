package app122;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app12.listener.MyWebContextListener;

public class DragonBallDAO {
	
	public int countAll() {
		String sql = "SELECT COUNT(*) AS CNT FROM dragonball";
		
		try (Connection conn = MyWebContextListener.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			if (rs.next()) {
				return rs.getInt("CNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public List<DragonBall> getAll(int limit, int offset){
		String sql = "SELECT * FROM dragonball LIMIT ? OFFSET ?";
		List<DragonBall> list = new ArrayList<DragonBall>();
		
		try (Connection conn = MyWebContextListener.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				) {
			stmt.setInt(1, limit);
			stmt.setInt(2, offset);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					list.add( resultMapping(rs) );
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	private DragonBall resultMapping(ResultSet rs) throws SQLException {
		String charactor = rs.getString("charactor");
		
		return new DragonBall(charactor);
	}
	
}
