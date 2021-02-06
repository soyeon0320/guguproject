package vo;

/**
 * 이력서 VO
 * @author ksy
 */
public class ResumeVO {
	private String code; //코드
	private String title; //제목
	private String memberId; //등록자
	private String schoolSection; //학교구분
	private String schoolName; //학교명
	private String schoolMajor; //전공명
	private double schoolScore; //학점
	private String schoolStartDate; //입학날짜
	private String schoolEndDate; //졸업날짜
	private String schoolEndYn; //졸업여부
	private String imgSrc; //이미지 경로
	private String imgName; //이미지 이름
	private String regDate; //등록일
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getSchoolSection() {
		return schoolSection;
	}
	public void setSchoolSection(String schoolSection) {
		this.schoolSection = schoolSection;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolMajor() {
		return schoolMajor;
	}
	public void setSchoolMajor(String schoolMajor) {
		this.schoolMajor = schoolMajor;
	}
	public double getSchoolScore() {
		return schoolScore;
	}
	public void setSchoolScore(double schoolScore) {
		this.schoolScore = schoolScore;
	}
	public String getSchoolStartDate() {
		return schoolStartDate;
	}
	public void setSchoolStartDate(String schoolStartDate) {
		this.schoolStartDate = schoolStartDate;
	}
	public String getSchoolEndDate() {
		return schoolEndDate;
	}
	public void setSchoolEndDate(String schoolEndDate) {
		this.schoolEndDate = schoolEndDate;
	}
	public String getSchoolEndYn() {
		return schoolEndYn;
	}
	public void setSchoolEndYn(String schoolEndYn) {
		this.schoolEndYn = schoolEndYn;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
