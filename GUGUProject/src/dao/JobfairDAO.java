package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import vo.JobfairVO;
import vo.PagingVO;
import vo.SuccessReviewVO;

public interface JobfairDAO {
	
	/**DB의 jobfair테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드*/
	public List<JobfairVO> jobfairAllSelect(SqlMapClient smc, PagingVO pageVO) throws SQLException;
	/**JobfairVO에 담긴 데이터를 이용하여 회원을 검색하는 메서드*/
	public List<JobfairVO> getSearchJobfair(SqlMapClient smc, JobfairVO jv) throws SQLException;
	/**
	 * 주어진 jobfairCode가 존재하는지 여부를 알아내는 메서드
	 * @param conn SqlMapClient 객체
	 * @param JobfairCode 검색할 JobfairCode
	 * @return 해당 JobfairCode가 있으면 true, 없으면 false
	 * @throws SQLException JDBC관련 예외객체
	 */
	public boolean getJobfair(SqlMapClient smc, String jobfairCode) throws SQLException;

	
	public int jobfairInsert(SqlMapClient smc, JobfairVO mv) throws SQLException;
	
	public int jobfairUpdate(SqlMapClient smc,JobfairVO jv) throws SQLException; 
	
	public int jobfairDelete(SqlMapClient smc, String jobfairCode) throws SQLException;

	List<JobfairVO> JobfairSelect(SqlMapClient smc, PagingVO pageVO) throws SQLException;
	
	public int JobfairAllSelectCount(SqlMapClient smc) throws SQLException;
}
