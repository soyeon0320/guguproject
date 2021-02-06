package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import vo.AdminVO;
import vo.FaqVO;

public interface FaqDAO {
	
	public List<FaqVO> faqList(SqlMapClient smc) throws SQLException;
	
	public int InsertFaq(SqlMapClient smc, FaqVO vo) throws SQLException;
	
	public List<FaqVO> searchCode(SqlMapClient smc, FaqVO vo) throws SQLException;
	
	public int update(SqlMapClient smc, FaqVO vo) throws SQLException;
	
	public int delete(SqlMapClient smc, String code) throws SQLException;
}
