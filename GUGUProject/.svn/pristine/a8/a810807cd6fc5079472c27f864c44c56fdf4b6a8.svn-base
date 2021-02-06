package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.FaqDAO;
import vo.FaqVO;

public class FaqDAOImpl implements FaqDAO{

	private static FaqDAO dao;
	public FaqDAOImpl() {}
	
	public static FaqDAO getInstance() {
		if(dao == null) {
			dao = new FaqDAOImpl();
		}
		return dao;
	}

	@Override
	public List<FaqVO> faqList(SqlMapClient smc) throws SQLException{
		List<FaqVO> list = new ArrayList<FaqVO>();
		list = smc.queryForList("admin.faqList");
		return list;
	}

	@Override
	public int InsertFaq(SqlMapClient smc, FaqVO vo) throws SQLException {
		int cnt = 0;
		Object obj = smc.insert("faq.insertFaq",vo);
		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public List<FaqVO> searchCode(SqlMapClient smc, FaqVO vo) throws SQLException {
		List<FaqVO> list = new ArrayList<FaqVO>();
		list = smc.queryForList("faq.searchCode", vo);
		return list;
	}

	@Override
	public int update(SqlMapClient smc, FaqVO vo) throws SQLException {
		int cnt = 0;
		cnt = smc.update("faq.update",vo);
		return cnt;
	}

	@Override
	public int delete(SqlMapClient smc, String code) throws SQLException {
		int cnt = 0;
		cnt = smc.delete("faq.delete",code);
		return cnt;
	}
	
	
}
