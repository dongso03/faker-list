package auth;

import java.sql.Connection;
import java.sql.SQLException;

import member.Member;
import member.MemberDAO;
import mylistener.MyWebContextListener;

public class LoginService {
	private MemberDAO memberDao = new MemberDAO();

	public User login(String id, String password) {
		try (Connection conn = MyWebContextListener.getConnection()) {
			Member member = memberDao.selectById(conn, id);
			if (member == null) {
				throw new LoginFailException();
			}
			if (!member.matchPassword(password)) {
				throw new LoginFailException();
			}
			return new User(member.getId(), member.getName());

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
