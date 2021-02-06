package daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.ApplyDAO;
import dao.IntroductionDAO;
import vo.ApplyVO;

public class ApplyDAOImpl implements ApplyDAO{
	private static ApplyDAO applyDao;
	
	private ApplyDAOImpl() {
		
	}
	
	public static ApplyDAO getInstance() {
		if(applyDao == null) {
			applyDao = new ApplyDAOImpl();
		}
		return applyDao;
	}

	@Override
	public int addIntro(SqlMapClient smc, ApplyVO av) throws SQLException {
		Object obj = smc.insert("apply.addIntro", av);
		int cnt = 0;
		if (obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public List<ApplyVO> getList(SqlMapClient smc, String memberId) throws SQLException {
		
		List<ApplyVO> avList = smc.queryForList("apply.getList", memberId);
		
		return avList;
	}

	@Override
	public int addCareer(SqlMapClient smc, ApplyVO av) throws SQLException {
		Object obj = smc.insert("apply.addCareer", av);
		int cnt = 0;
		if (obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int resumeDelete(SqlMapClient smc, String resumeCode) throws SQLException {
		int cnt = smc.delete("apply.resumeDelete", resumeCode);
		return cnt;
	}

	@Override
	public int introDelete(SqlMapClient smc, String introCode) throws SQLException {
		int cnt = smc.delete("apply.introDelete", introCode);
		return cnt;
	}
}
