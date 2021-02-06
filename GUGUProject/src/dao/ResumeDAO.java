package dao;

import java.sql.SQLException;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;

import vo.PagingVO;
import vo.ResumeVO;

/**
 * 이력서 DAO
 * @author ksy
 */
public interface ResumeDAO {
	/**
	 * 이력서 전체 조회
	 * @param smc 쿼리를 수행하기 위한 객체
	 * @param pv 페이징 객체
	 * @return 이력서 리스트
	 * @throws SQLException 예외 처리
	 */
	public List<ResumeVO> ResumeAllSelect(SqlMapClient smc, PagingVO pv) throws SQLException;
	
	/**
	 * 이력서 상세 조회
	 * @param smc 쿼리를 수행하기 위한 객체
	 * @param rv 이력서 정보가 담긴 객체
	 * @return 이력서 데이터
	 * @throws SQLException 예외 처리
	 */
	public List<ResumeVO> ResumeSelect(SqlMapClient smc, ResumeVO rv) throws SQLException;
	
	/**
	 * 이력서 등록
	 * @param smc 쿼리를 수행하기 위한 객체
	 * @param rv 이력서 정보가 담긴 객체
	 * @return 0:등록 실패 1:등록 성공
	 * @throws SQLException 예외 처리
	 */
	public int ResumeInsert(SqlMapClient smc, ResumeVO rv) throws SQLException;
	
	/**
	 * 이력서 전체 갯수 조회
	 * @param smc 쿼리를 수행하기 위한 객체
	 * @return 데이터 전체 갯수
	 * @throws SQLException 예외 처리
	 */
	public int ResumeAllSelectCount(SqlMapClient smc) throws SQLException;
	
	/**
	 * 이력서 삭제
	 * @param smc 쿼리를 수행하기 위한 객체
	 * @param resumeCode 이력서를 구분하기 위한 코드
	 * @return 0:삭제 실패 1:삭제 성공
	 * @throws SQLException 예외 처리
	 */
	public int ResumeDelete(SqlMapClient smc, String resumeCode) throws SQLException;
	
	/**
	 * 이력서 수정
	 * @param smc 쿼리를 수행하기 위한 객체
	 * @param rv 이력서 정보가 담긴 객체
	 * @return 0:수정 실패 1:수정 성공
	 * @throws SQLException 예외 처리
	 */
	public int ResumeUpdate(SqlMapClient smc, ResumeVO rv) throws SQLException;
}
