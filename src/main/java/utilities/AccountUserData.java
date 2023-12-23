package utilities;

import com.opencsv.bean.CsvBindByName;


import lombok.Data;

@Data
public class AccountUserData {
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String email;
    @CsvBindByName
    private String password;
    @CsvBindByName
    private String passwordConfirm;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
    
 
}
