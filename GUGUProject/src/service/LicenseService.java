package service;

import java.util.List;
import vo.LicenseVO;

/**
 * 자격증 서비스
 * @author ksy
 */
public interface LicenseService {
	/**
	 * 자격증 전체 조회
	 * @param lv 자격증 정보가 담긴 객체
	 * @return 자격증 리스트
	 */
	public List<LicenseVO> ResumeLicenseSelect(LicenseVO lv);
	
	/**
	 * 자격증 등록
	 * @param lv 자격증 정보가 담긴 객체
	 * @return 0:실패 1:성공
	 */
	public int ResumeLicenseInsert(LicenseVO lv);
	
	/**
	 * 자격증 수정
	 * @param lv 자격증 정보가 담긴 객체
	 * @return 0:실패 1:성공
	 */
	public int ResumeLicenseUpdate(LicenseVO lv);
	
	/**
	 * 자격증 삭제
	 * @param licenseCode 자격증을 구분할 수 있는 코드
	 * @return 0:실패 1:성공
	 */
	public int ResumeLicenseDelete(String licenseCode);
}
