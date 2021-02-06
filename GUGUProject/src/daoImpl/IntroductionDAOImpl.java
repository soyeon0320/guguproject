package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.IntroductionDAO;
import dao.IntroductionDAO;
import vo.IntroductionVO;
import vo.MemberPagingVO;
import vo.PagingVO;

public class IntroductionDAOImpl implements IntroductionDAO {
	private static IntroductionDAO jobNewsDao;
	
	private IntroductionDAOImpl() {
		
	}
	
	public static IntroductionDAO getInstance() {
		if(jobNewsDao == null) {
			jobNewsDao = new IntroductionDAOImpl();
		}
		return jobNewsDao;
	}

	@Override
	public int introductionAllSelectCount(SqlMapClient smc) throws SQLException {
		int resCnt = (int)smc.queryForObject("introduction.introductionAllSelectCount");
		return resCnt;
	}

	@Override
	public List<IntroductionVO> introductionSelect(SqlMapClient smc, PagingVO pageVO) throws SQLException {
		List<IntroductionVO> introductionList = new ArrayList<IntroductionVO>();
		introductionList = smc.queryForList("introduction.introductionAllSelect", pageVO);
		return introductionList;
	}

	@Override
	public IntroductionVO getIntroduction(SqlMapClient smc, String introductionCode) throws SQLException {
		IntroductionVO introductionVO = (IntroductionVO) smc.queryForObject("introduction.getInroduction", introductionCode);
		return introductionVO;
	}

	@Override
	public int insert(SqlMapClient smc, IntroductionVO introductionVO) throws SQLException {
		Object obj = smc.insert("introduction.insert", introductionVO);
		int cnt = 0;
		if (obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int update(SqlMapClient smc, IntroductionVO introductionVO) throws SQLException {
		int cnt = smc.update("introduction.update", introductionVO);
		return cnt;
	}

	@Override
	public int delete(SqlMapClient smc, String introductionCode) throws SQLException {
		int cnt = smc.delete("introduction.delete", introductionCode);
		return 0;
	}

	@Override
	public int memberIntroductionAllSelectCount(SqlMapClient smc, String memberId) throws SQLException {
		int resCnt = (int)smc.queryForObject("introduction.memberIntroductionAllSelectCount", memberId);
		return resCnt;
	}

	@Override
	public List<IntroductionVO> memberIntroductionSelect(SqlMapClient smc, MemberPagingVO memberPageVO)	throws SQLException {
		List<IntroductionVO> memberIntroductionList = new ArrayList<IntroductionVO>();
		memberIntroductionList = smc.queryForList("introduction.memberIntroductionAllSelect", memberPageVO);
		return memberIntroductionList;
	}
}
