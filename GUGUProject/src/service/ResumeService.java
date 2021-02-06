package service;

import java.util.List;

import vo.PagingVO;
import vo.ResumeVO;

/**
 * 이력서 서비스
 * @author ksy
 */
public interface ResumeService {
	/**
	 * 이력서 전체 조회
	 * @param pv 페이징 객체
	 * @return 이력서 리스트
	 */
	public List<ResumeVO> ResumeAllSelect(PagingVO pv);
	
	/**
	 * 이력서 데이터 전체 갯수 조회
	 * @return 데이터 전체 갯수
	 */
	public int ResumeAllSelectCount();
	
	/**
	 * 이력서 상세 조회
	 * @param rv 이력서 정보가 담긴 객체
	 * @return 이력서 데이터
	 */
	public List<ResumeVO> ResumeSelect(ResumeVO rv);
	
	/**
	 * 이력서 등록
	 * @param rv 이력서 정보가 담긴 객체
	 * @return 0:등록 실패 1:등록 성공
	 */
	public int ResumeInsert(ResumeVO rv);
	
	/**
	 * 이력서 삭제
	 * @param resumeCode 이력서를 구분할 수 있는 고유 코드
	 * @return 0:삭제 실패 1:삭제 성공
	 */
	public int ResumeDelete(String resumeCode);
	
	/**
	 * 이력서 수정
	 * @param rv 이력서 정보가 담긴 객체
	 * @return 0:수정 실패 1:수정 성공
	 */
	public int ResumeUpdate(ResumeVO rv);
}
