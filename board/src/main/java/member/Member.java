package member;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String id;
	private String name;
	private String password;
	private Date regDate;
	
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}
}
