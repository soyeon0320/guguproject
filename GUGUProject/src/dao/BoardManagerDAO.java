package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import vo.BoardManagerVO;

public interface BoardManagerDAO {
	
	public List<BoardManagerVO> searchList(SqlMapClient smc, String searchName) throws SQLException;
	
}
