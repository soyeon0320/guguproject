package service;

import java.util.List;
import vo.CareerVO;

/**
 * 경력 서비스
 * @author ksy
 */
public interface CareerService {
	/**
	 * 경력 전체 조회
	 * @param cv 경력 정보가 담긴 객체
	 * @return 경력 리스트
	 */
	public List<CareerVO> ResumeCareerSelect(CareerVO cv);
	
	/**
	 * 경력 등록
	 * @param cv 경력 정보가 담긴 객체
	 * @return 0:실패 1:성공
	 */
	public int ResumeCareerInsert(CareerVO cv);
	
	/**
	 * 경력 수정
	 * @param cv 경력 정보가 담긴 객체
	 * @return 0:실패 1:성공
	 */
	public int ResumeCareerUpdate(CareerVO cv);
	
	/**
	 * 경력 삭제
	 * @param careerCode 경력을 구분할 수 있는 고유 코드
	 * @return 0:실패 1:성공
	 */
	public int ResumeCareerDelete(String careerCode);
}
