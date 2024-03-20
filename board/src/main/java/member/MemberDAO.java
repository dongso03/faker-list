package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class MemberDAO {
	
	public Member selectById(Connection conn , String id) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rs= null;
		try {
			stmt = conn.prepareStatement("select * from member where memberid =?");
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			Member member = null;
			if(rs.next()) {
				member = new Member(rs.getString("memberid"), rs.getString("name"), rs.getString("password"), toDate(rs.getTimestamp("regdate")));
			}
			return member;
		} finally {
			rs.close();
			stmt.close();
		}
	}
	private Date toDate(Timestamp date) {
		return date == null? null: new Date(date.getTime());
	}
	
	public void insert(Connection conn , Member mem)throws SQLException {
		try(PreparedStatement stmt = conn.prepareStatement("insert into member values(?,?,?,?)")){
			stmt.setString(1, mem.getId());
			stmt.setString(2, mem.getName());
			stmt.setString(3, mem.getPassword());
			stmt.setTimestamp(4, new Timestamp(mem.getRegDate().getTime()));
			stmt.executeUpdate();
		}
	}
}
