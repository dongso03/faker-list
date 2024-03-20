package member;

import java.util.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinRequest {
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	
	public boolean isPasswordEqualToConfirm() {
		return password != null&& password.equals(confirmPassword);
	}
	public void validate(Map<String, Boolean>errors) {
		checkEmpty(errors,id,"id");
		checkEmpty(errors,name,"name");
		checkEmpty(errors,password,"password");
		checkEmpty(errors,confirmPassword,"confirmPassword");
		if(!isPasswordEqualToConfirm()) {
			errors.put("notMatch", Boolean.TRUE);
		}
	}
	
	private void checkEmpty(Map<String, Boolean>errors,String value,String fieldName) {
		if(value== null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}
}
