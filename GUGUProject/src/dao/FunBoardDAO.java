package dao;

import java.sql.SQLException;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import vo.FunBoardVO;
import vo.PagingVO;

/**
 * 자유게시판 DAO
 * @author ksy
 */
public interface FunBoardDAO {
	/**
	 * 자유게시판 전체 조회
	 * @param smc 쿼리 작업을 위한 객체
	 * @param pv 페이징 객체
	 * @return 자유게시판 리스트
	 * @throws SQLException 예외 처리
	 */
	public List<FunBoardVO> FunBoardAllSelect(SqlMapClient smc, PagingVO pv) throws SQLException;
	
	/**
	 * 자유게시판 전체 갯수 조회
	 * @param smc 쿼리 작업을 위한 객체
	 * @return 자유게시판 전체 갯수
	 * @throws SQLException 예외 처리
	 */
	public int FunBoardAllSelectCount(SqlMapClient smc) throws SQLException;

	/**
	 * 자유게시판 상세 조회
	 * @param smc 쿼리 작업을 위한 객체
	 * @param fbv 자유게시판 정보가 담긴 객체
	 * @return 자유게시판 데이터
	 * @throws SQLException 예외 처리
	 */
	public List<FunBoardVO> FunBoardSelect(SqlMapClient smc, FunBoardVO fbv) throws SQLException;
	
	/**
	 * 자유게시판 등록
	 * @param smc 쿼리 작업을 위한 객체
	 * @param fbv 자유게시판 정보가 담긴 객체
	 * @return 0:등록 실패 1:등록 성공
	 * @throws SQLException 예외 처리
	 */
	public int FunBoardInsert(SqlMapClient smc, FunBoardVO fbv) throws SQLException;
	
	/**
	 * 자유게시판 수정
	 * @param smc 쿼리 작업을 위한 객체
	 * @param fbv 자유게시판 정보가 담긴 객체
	 * @return 0:수정 실패 1:수정 성공
	 * @throws SQLException 예외 처리
	 */
	public int FunBoardUpdate(SqlMapClient smc, FunBoardVO fbv) throws SQLException;
	
	/**
	 * 자유게시판 삭제
	 * @param smc 쿼리 작업을 위한 객체
	 * @param funBoardCode 자유게시판의 데이터를 구분하는 고유 코드 번호
	 * @return 0:삭제 실패 1:삭제 성공
	 * @throws SQLException 예외 처리
	 */
	public int FunBoardDelete(SqlMapClient smc, String funBoardCode) throws SQLException;
	
	
}
