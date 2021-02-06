package vo;

/**
 * 설문조사 VO
 * @author pjy
 */
public class QuestionItemVO {
	private String qiNo; //문항번호
	private String qiContent; //문항내용
	private int itemSn; //문항일련번호
	private String sqCode; //질문코드
	
	public String getQiNo() {
		return qiNo;
	}
	public void setQiNo(String qiNo) {
		this.qiNo = qiNo;
	}
	public String getQiContent() {
		return qiContent;
	}
	public void setQiContent(String qiContent) {
		this.qiContent = qiContent;
	}
	public int getItemSn() {
		return itemSn;
	}
	public void setItemSn(int itemSn) {
		this.itemSn = itemSn;
	}
	public String getSqCode() {
		return sqCode;
	}
	public void setSqCode(String sqCode) {
		this.sqCode = sqCode;
	}
    
	
	
	
}   
    