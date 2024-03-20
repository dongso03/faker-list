package member;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import mylistener.MyWebContextListener;

public class JoinService {
	private MemberDAO dao = new MemberDAO();

	public void join(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = MyWebContextListener.getConnection();
			conn.setAutoCommit(false);
			Member mem = dao.selectById(conn, joinReq.getId());
			if (mem != null) {
			}
			dao.insert(conn, new Member(
					joinReq.getId(),
					joinReq.getName(),
					joinReq.getPassword(),
					new Date()
					));
			conn.commit();
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
