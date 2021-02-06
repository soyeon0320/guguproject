package vo;

/**
 * 자기소개서 VO
 * @author ksy
 */
public class IntroductionVO implements Comparable<IntroductionVO> {
	private String code; //코드
	private String title; //제목
	private String writer; // 작성자
	private String regDate; //등록일
	private String reason; //지원동기
	private String growth; //성장배경
	private String career; //경력사항
	private String memberId; // 회원 아이디
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getGrowth() {
		return growth;
	}
	public void setGrowth(String growth) {
		this.growth = growth;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	@Override
	public int compareTo(IntroductionVO o) {
		
		return 0;
	}
	
	
	
}
