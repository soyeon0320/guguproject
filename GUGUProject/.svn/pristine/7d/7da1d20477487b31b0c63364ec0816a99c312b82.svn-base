package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import dao.BoardManagerDAO;
import vo.BoardManagerVO;

public class BoardManagerDAOImpl implements BoardManagerDAO{
	
	private static BoardManagerDAO dao;
	public BoardManagerDAOImpl() {}
	public static BoardManagerDAO getInstance() {
		if(dao == null) {
			dao = new BoardManagerDAOImpl();
		}
		return dao;
	}

	@Override
	public List<BoardManagerVO> searchList(SqlMapClient smc, String searchName) throws SQLException {
		List<BoardManagerVO> list = new ArrayList<BoardManagerVO>();
		list = smc.queryForList("boardManager.list",searchName);
		System.out.println(list);
		return list;
	}
	
}
