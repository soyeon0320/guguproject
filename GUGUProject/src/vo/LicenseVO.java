package vo;

/**
 * 자격증 VO
 */
public class LicenseVO {
	private String licenseCode; //코드
	private String name; //이름
	private String getDate; //취득일
	private String resumeCode; //이력서 코드
	
	public String getLicenseCode() {
		return licenseCode;
	}
	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGetDate() {
		return getDate;
	}
	public void setGetDate(String getDate) {
		this.getDate = getDate;
	}
	public String getResumeCode() {
		return resumeCode;
	}
	public void setResumeCode(String resumeCode) {
		this.resumeCode = resumeCode;
	}
	
	
}
