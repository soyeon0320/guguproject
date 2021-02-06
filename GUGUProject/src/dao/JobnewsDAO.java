package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import vo.JobNewsVO;

public interface JobnewsDAO {
	
	/**DB의 jobnews테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드*/
	public List<JobNewsVO> jobnewsAllSelect(SqlMapClient smc, JobNewsVO jv) throws SQLException;
	/**JobnewsVO에 담긴 데이터를 이용하여 회원을 검색하는 메서드*/
	public List<JobNewsVO> getSearchJobnews(SqlMapClient smc, JobNewsVO jv) throws SQLException;
	/**
	 * 주어진 jobnewsCode가 존재하는지 여부를 알아내는 메서드
	 * @param conn SqlMapClient 객체
	 * @param jobnewsCode 검색할 jobnewsCode
	 * @return 해당 회원ID가 있으면 true, 없으면 false
	 * @throws SQLException JDBC관련 예외객체
	 */
	public boolean getJobnews(SqlMapClient smc, String jobnewsCode) throws SQLException;

	
	public int jobnewsInsert(SqlMapClient smc, JobNewsVO mv) throws SQLException;
	
	public int jobnewsUpdate(SqlMapClient smc,JobNewsVO jv) throws SQLException; 
	
	public int jobnewsDelete(SqlMapClient smc, String jobnewsCode) throws SQLException;

}

