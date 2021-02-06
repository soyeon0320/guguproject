package vo;

/**
 * 설문조사결과 VO
 * @author pjy
 */
public class SurveyWinnerVO {
	private String surveywinnerProinfo; // 상품정보
	private String surveywinnerReceiptdate;// 상품전달일자
	private String memberId; // 회원아이디
	private String memberName;// 이름
	private int surveywinnerSn;// 당첨자일련번호
	private String surveyCode;// 설문코드
	
	public String getSurveywinnerProinfo() {
		return surveywinnerProinfo;
	}
	public void setSurveywinnerProinfo(String surveywinnerProinfo) {
		this.surveywinnerProinfo = surveywinnerProinfo;
	}
	public String getSurveywinnerReceiptdate() {
		return surveywinnerReceiptdate;
	}
	public void setSurveywinnerReceiptdate(String surveywinnerReceiptdate) {
		this.surveywinnerReceiptdate = surveywinnerReceiptdate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getSurveywinnerSn() {
		return surveywinnerSn;
	}
	public void setSurveywinnerSn(int surveywinnerSn) {
		this.surveywinnerSn = surveywinnerSn;
	}
	public String getSurveyCode() {
		return surveyCode;
	}
	public void setSurveyCode(String surveyCode) {
		this.surveyCode = surveyCode;
	}

	
	
	
	

}
