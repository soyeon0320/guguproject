package vo;

/**
 * 경력사항 VO
 * @author ksy
 */
public class CareerVO {
	private String careerCode; //코드
	private String companyName; //회사명
	private String departName; //부서명
	private String positionName; //직책명
	private String startDate; //입사일
	private String endDate; //퇴사일
	private String jobName; //직무명
	private String resumeCode; //이력서 코드
	
	public String getCareerCode() {
		return careerCode;
	}
	public void setCareerCode(String careerCode) {
		this.careerCode = careerCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getResumeCode() {
		return resumeCode;
	}
	public void setResumeCode(String resumeCode) {
		this.resumeCode = resumeCode;
	}
	
	
}