package testdata;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataMapper{
	private String nameUser;
	private String emailExist;
	private String emailSuccess;
	private String password;
	private String confirmPassword;
	private String errorTextBlank;
	private String errorTextEmailExist;
	private String passwordNew;
	public static UserDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/src/test/resources/UserData.json"),
					UserDataMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@JsonProperty("nameUser")
	public String getNameUser() {
		return nameUser;
	}

	@JsonProperty("emailExist")
	public String getemailExist() {
		return emailExist;
	}
	@JsonProperty("emailSuccess")
	public String getemailSuccess() {
		return emailSuccess;
	}
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}
	

	@JsonProperty("confirmPassword")
	public String getConfirmPassword() {
		return confirmPassword;
	}

	@JsonProperty("errorTextBlank")
	public String geterrorTextBlank() {
		return errorTextBlank;
	}
	@JsonProperty("errorTextEmailExist")
	public String geterrorTextEmailExist() {
		return errorTextEmailExist;
	}
	@JsonProperty("passwordNew")
	public String getPasswordNew() {
		return passwordNew;
	}

	@JsonProperty("nameInput")
	private List<NameInput> nameInputs;

	public List<NameInput> getNameInputs() {
		return nameInputs;
	}

	public static class NameInput {
		private String name;
		private String errorName;

		@JsonProperty("name")
		public String getName() {
			return name;
		}

		@JsonProperty("errorName")
		public String geterrorName() {
			return errorName;
		}
	}

	@JsonProperty("emailInput")
	private List<EmailInput> emailInputs;

	public List<EmailInput> getEmailInputs() {
		return emailInputs;
	}

	public static class EmailInput {
		private String email;
		private String errorEmail;

		@JsonProperty("email")
		public String getEmail() {
			return email;
		}

		@JsonProperty("errorEmail")
		public String getErrorEmail() {
			return errorEmail;
		}
	}

	@JsonProperty("passwordInput")
	private List<PasswordInput> passwordInputs;

	public List<PasswordInput> getPasswordInputs() {
		return passwordInputs;
	}

	public static class PasswordInput{
		private String password;
		private String confirmPassword;
		private String errorPassword;
		private String errorConfirmPassword;
		@JsonProperty("password")
		public String getPassword() {
			return password;
		}
		@JsonProperty("confirmPassword")
		public String getconfirmPassword() {
			return confirmPassword;
		}

		@JsonProperty("errorPassword")
		public String geterrorPassword() {
			return errorPassword;
		}
		@JsonProperty("errorConfirmPassword")
		public String geterrorConfirmPassword() {
			return errorConfirmPassword;
		}
	}

}
