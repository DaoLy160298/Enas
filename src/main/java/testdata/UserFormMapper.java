package testdata;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserFormMapper {
	public static UserFormMapper getUserForm() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/src/test/resources/UserForm.json"),
					UserFormMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@JsonProperty("titleComponentInput")
	private List<TitleComponent> titleComponents;

	public List<TitleComponent> getTitleComponents() {
		return titleComponents;
	}

	public static class TitleComponent {
		private String titleComponentText;

		@JsonProperty("titleComponent")
		public String getTitleComponentText() {
			return titleComponentText;
		}
	}

	@JsonProperty("sampleTextInput")
	private List<sampleText> sampleTexts;

	public List<sampleText> getSampleTexts() {
		return sampleTexts;
	}

	public static class sampleText {
		private String sampleText;

		@JsonProperty("sampleText")
		public String getSampleText() {
			return sampleText;
		}
	}

	@JsonProperty("generalExplantionTextarea")
	private List<generalExplantion> generalExplantions;

	public List<generalExplantion> getGeneralExplantions() {
		return generalExplantions;
	}

	public static class generalExplantion {
		private String generalExplantion;

		@JsonProperty("generalExplantion")
		public String getGeneralExplantion() {
			return generalExplantion;
		}
	}

	@JsonProperty("additionalExplantionTextarea")
	private List<additionalExplantion> additionalExplantions;

	public List<additionalExplantion> getAdditionalExplantions() {
		return additionalExplantions;
	}

	public static class additionalExplantion {
		private String additionalExplantion;

		@JsonProperty("additionalExplantion")
		public String getAdditionalExplantion() {
			return additionalExplantion;
		}
	}

}
