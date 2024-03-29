package vo;

/**
 * 채용설명회 VO
 * @author pjy
 */
public class JobfairVO {
	private String jobfairCode; //코드
	private String jobfairGroup; //분류
	private String jobfairTitle; //제목
	private String jobfairStartdate; //시작일
	private String jobfairEnddate; //종료일
	private String jobfairPlace; //장소
	private String companyCode; //기업코드
	private String companyName; //기업명
	
	private char Manager;
	
	public String getJobfairCode() {
		return jobfairCode;
	}
	public void setJobfairCode(String jobfairCode) {
		this.jobfairCode = jobfairCode;
	}
	public String getJobfairGroup() {
		return jobfairGroup;
	}
	public void setJobfairGroup(String jobfairGroup) {
		this.jobfairGroup = jobfairGroup;
	}
	public String getJobfairTitle() {
		return jobfairTitle;
	}
	public void setJobfairTitle(String jobfairTitle) {
		this.jobfairTitle = jobfairTitle;
	}
	public String getJobfairStartdate() {
		return jobfairStartdate;
	}
	public void setJobfairStartdate(String jobfairStartdate) {
		this.jobfairStartdate = jobfairStartdate;
	}
	public String getJobfairEnddate() {
		return jobfairEnddate;
	}
	public void setJobfairEnddate(String jobfairEnddate) {
		this.jobfairEnddate = jobfairEnddate;
	}
	public String getJobfairPlace() {
		return jobfairPlace;
	}
	public void setJobfairPlace(String jobfairPlace) {
		this.jobfairPlace = jobfairPlace;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public char getManager() {
		return Manager;
	}
	public void setManager(char manager) {
		Manager = manager;
	}
	
	
}
