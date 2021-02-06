package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import vo.ApplyVO;

public interface ApplyDAO {

	int addIntro(SqlMapClient smc, ApplyVO av) throws SQLException;

	List<ApplyVO> getList(SqlMapClient smc, String memberId) throws SQLException;

	int addCareer(SqlMapClient smc, ApplyVO av) throws SQLException;

	int resumeDelete(SqlMapClient smc, String resumeCode) throws SQLException;

	int introDelete(SqlMapClient smc, String introCode) throws SQLException;

}
