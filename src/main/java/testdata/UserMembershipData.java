package testdata;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserMembershipData {
	private String errorBlank;

	public static UserMembershipData getUserMembershipData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/src/test/resources/UserMembershipData.json"),
					UserMembershipData.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@JsonProperty("errorBlank")
	public String getErrorBlank() {
		return errorBlank;
	}
	@JsonProperty("projectnameInput")
	private List<projectnameInput> projectnameInputs;

	public List<projectnameInput> getNameProjectInputs() {
		return projectnameInputs;
	}

	public static class projectnameInput {
		private String projectName;
		private String errorProjectName;

		@JsonProperty("projectName")
		public String getProjectName() {
			return projectName;
		}

		@JsonProperty("errorProjectName")
		public String getErrorProjectName() {
			return errorProjectName;
		}

	}
	@JsonProperty("domainInput")
	private List<domainInput> domainInputs;

	public List<domainInput> getDomainInputs() {
		return domainInputs;
	}
	public static class domainInput {
		private String domainName;
		private String errordomainName;

		@JsonProperty("domainName")
		public String getDomainName() {
			return domainName;
		}

		@JsonProperty("errorDomain")
		public String getErrordomainName() {
			return errordomainName;
		}

	}

	@JsonProperty("siteTypeDropdown")
	private List<siteTypeDropdown> siteTypeDropdowns;

	public List<siteTypeDropdown> getSiteTypeDropdowns() {
		return siteTypeDropdowns;
	}
	public static class siteTypeDropdown {
		private String siteType;

		@JsonProperty("siteType")
		public String getSiteType() {
			return siteType;
		}

	}
	@JsonProperty("sitePlanRadiobutton")
	private List<sitePlanRadiobutton> sitePlanRadiobuttons;

	public List<sitePlanRadiobutton> getsitePlanRadiobuttons() {
		return sitePlanRadiobuttons;
	}
	public static class sitePlanRadiobutton {
		private String sitePlan;

		@JsonProperty("sitePlan")
		public String getSitePlan() {
			return sitePlan;
		}

	}
	@JsonProperty("sizeStaffRadiobutton")
	private List<sizeStaffRadiobutton> sizeStaffRadiobuttons;

	public List<sizeStaffRadiobutton> getsizeStaffRadiobutton() {
		return sizeStaffRadiobuttons;
	}
	public static class sizeStaffRadiobutton {
		private String sizeStaff;

		@JsonProperty("sizeStaff")
		public String getSizeStaff() {
			return sizeStaff;
		}

	}
	@JsonProperty("companyNameInput")
	private List<companyNameInput> CompanyNameInputs;

	public List<companyNameInput> getCompanyNameInputs() {
		return CompanyNameInputs;
	}
	public static class companyNameInput {
		private String companyName;
		private String errorCompanyName;

		@JsonProperty("companyName")
		public String getcompanyName() {
			return companyName;
		}

		@JsonProperty("errorCompanyName")
		public String getErrorCompanyName() {
			return errorCompanyName;
		}
	}
	@JsonProperty("companyPhoneInput")
	private List<companyPhoneInput> companyPhoneInputs;

	public List<companyPhoneInput> getcompanyPhoneInputs() {
		return companyPhoneInputs;
	}
	public static class companyPhoneInput {
		private String companyPhone;
		private String errorCompanyPhone;

		@JsonProperty("companyPhone")
		public String getCompanyPhone() {
			return companyPhone;
		}

		@JsonProperty("errorCompanyPhone")
		public String getErrorCompanyPhone() {
			return errorCompanyPhone;
		}

	}

}
