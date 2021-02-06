package service;

import java.util.List;
import vo.FunBoardVO;
import vo.PagingVO;

/**
 * 자유게시판 서비스
 * @author ksy
 */
public interface FunBoardService {
	/**
	 * 자유게시판 전체 조회
	 * @param pv 페이징 객체
	 * @return 자유게시판 리스트
	 */
	public List<FunBoardVO> FunBoardAllSelect(PagingVO pv);
	
	/**
	 * 페이징을 위한 자유게시판 전체 갯수 조회
	 * @return 자유게시판 데이터 전체 갯수
	 */
	public int FunBoardAllSelectCount();
	
	/**
	 * 자유게시판 상세 조회
	 * @param fbv 자유게시판 정보가 담긴 객체
	 * @return 자유게시판 데이터
	 */
	public List<FunBoardVO> FunBoardSelect(FunBoardVO fbv);
	
	/**
	 * 자유게시판 등록
	 * @param fbv 자유게시판 정보가 담긴 객체
	 * @return 0:등록 실패 1:등록 성공
	 */
	public int FunBoardInsert(FunBoardVO fbv);
	
	/**
	 * 자유게시판 수정
	 * @param fbv 자유게시판 정보가 담긴 객체
	 * @return 0:수정 실패 1:수정 성공
	 */
	public int FunBoardUpdate(FunBoardVO fbv);
	
	/**
	 * 자유게시판 삭제
	 * @param funBoardCode
	 * @return 0:삭제 실패 1:삭제 성공
	 */
	public int FunBoardDelete(String funBoardCode);
	
}
