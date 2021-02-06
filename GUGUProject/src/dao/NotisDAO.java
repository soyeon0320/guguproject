package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import vo.NotisVO;

public interface NotisDAO {
	
	public List<NotisVO> notisList(SqlMapClient smc) throws SQLException;
	
	public int insert(SqlMapClient smc, NotisVO vo) throws SQLException;
	
	public int update(SqlMapClient smc, NotisVO vo) throws SQLException;
	
	public List<NotisVO> searchCode(SqlMapClient smc,String code) throws SQLException;
	
	public int delete(SqlMapClient smc, String code) throws SQLException;
	
}


