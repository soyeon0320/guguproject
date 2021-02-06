package vo;

/**
 * 이미지 VO
 * @author ksy
 */
public class ImgVO {
	private String imgCode; //코드
	private String imgPath; //경로
	private String imgNo; //번호
	private String imgExt; //확장자
	private long imgSize; //사이즈
	private String imgRegDate; //등록일
	private String imgName; //이름
//	private String resumeCode; //이력서 코드
	
	public String getImgCode() {
		return imgCode;
	}
	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getImgNo() {
		return imgNo;
	}
	public void setImgNo(String imgNo) {
		this.imgNo = imgNo;
	}
	public String getImgExt() {
		return imgExt;
	}
	public void setImgExt(String imgExt) {
		this.imgExt = imgExt;
	}
	public long getImgSize() {
		return imgSize;
	}
	public void setImgSize(long imgSize) {
		this.imgSize = imgSize;
	}
	public String getImgRegDate() {
		return imgRegDate;
	}
	public void setImgRegDate(String imgRegDate) {
		this.imgRegDate = imgRegDate;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
//	public String getResumeCode() {
//		return resumeCode;
//	}
//	public void setResumeCode(String resumeCode) {
//		this.resumeCode = resumeCode;
//	}
}