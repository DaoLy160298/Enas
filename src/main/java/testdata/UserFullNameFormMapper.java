package testdata;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserFullNameFormMapper {
	public static UserFullNameFormMapper getUserFullNameForm() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/src/test/resources/UserFullNameForm.json"),
					UserFullNameFormMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@JsonProperty("titleFullNameInput")
	private List<TitleFullName> titleFullNames;

	public List<TitleFullName> getTitleFullNames() {
		return titleFullNames;
	}

	public static class TitleFullName {
		private String fullNameTitle;

		@JsonProperty("fullNameTitle")
		public String getfullNameTitle() {
			return fullNameTitle;
		}
	}

	@JsonProperty("lastNameInput")
	private List<LastNameInput> lastNameInputs;

	public List<LastNameInput> getLastNameInputs() {
		return lastNameInputs;
	}

	public static class LastNameInput {
		private String lastName;

		@JsonProperty("lastName")
		public String getlastName() {
			return lastName;
		}
	}
	@JsonProperty("firstNameInput")
	private List<FirstNameInput> firstNameInputs;

	public List<FirstNameInput> getfirstNameInputs() {
		return firstNameInputs;
	}

	public static class FirstNameInput {
		private String firstName;

		@JsonProperty("firstName")
		public String getfirstName() {
			return firstName;
		}
	}
	@JsonProperty("titleCFuriganaInput")
	private List<TitleCFuriganaInput> titleCFuriganaInputs;

	public List<TitleCFuriganaInput> getTitleFuriganaInputs() {
		return titleCFuriganaInputs;
	}

	public static class TitleCFuriganaInput {
		private String furiganaTitle;

		@JsonProperty("furiganaTitle")
		public String getFuriganaTitle() {
			return furiganaTitle;
		}
	}
	
	@JsonProperty("lastNameFuriInput")
	private List<LastNameFuriInput> lastNameFuriInputs;

	public List<LastNameFuriInput> getLastNameFuriInputs() {
		return lastNameFuriInputs;
	}

	public static class LastNameFuriInput {
		private String lastNameFuri;

		@JsonProperty("lastNameFuri")
		public String getLastNameFuri() {
			return lastNameFuri;
		}
	}
	
	
	@JsonProperty("firstNameFuriInput")
	private List<FirstNameFuriInput> firstNameFurriInputs;

	public List<FirstNameFuriInput> getfirstNameFurriInputs() {
		return firstNameFurriInputs;
	}

	public static class FirstNameFuriInput {
		private String firstNameFuri;

		@JsonProperty("firstNameFuri")
		public String getfirstNameFuri() {
			return firstNameFuri;
		}
	}

}
