package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.NotisDAO;
import vo.NotisVO;

public class NotisDAOImpl implements NotisDAO{

	private static NotisDAO dao;
	public NotisDAOImpl() {}
	
	public static NotisDAO getInstance() {
		if(dao == null) {
			dao = new NotisDAOImpl();
		}
		return dao;
	}
	
	@Override
	public List<NotisVO> notisList(SqlMapClient smc){
		
		List<NotisVO> list = new ArrayList<NotisVO>();
		
		try {
			list = smc.queryForList("notis.notisList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insert(SqlMapClient smc, NotisVO vo) {
		int cnt = 0;
		
		Object obj = null;
		try {
			obj = smc.insert("notis.insert",vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int update(SqlMapClient smc, NotisVO vo) throws SQLException {
		int cnt = 0;
		cnt = smc.update("notis.update",vo);
		return cnt;
	}

	@Override
	public List<NotisVO> searchCode(SqlMapClient smc, String code) throws SQLException {
		List<NotisVO> list = new ArrayList<NotisVO>();
		list = smc.queryForList("notis.searchCode",code);
		return list;
	}

	@Override
	public int delete(SqlMapClient smc, String code) throws SQLException {
		int cnt = 0;
		cnt = smc.delete("notis.delete",code);
		return cnt;
	}

	
}
