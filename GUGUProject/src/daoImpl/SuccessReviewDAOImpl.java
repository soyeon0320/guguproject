package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.SuccessReviewDAO;
import vo.PagingVO;
import vo.SuccessReviewVO;

public class SuccessReviewDAOImpl implements SuccessReviewDAO{
	private static SuccessReviewDAO successReviewDao;
	
	private SuccessReviewDAOImpl() {
		
	}
	
	public static SuccessReviewDAO getInstance() {
		if(successReviewDao == null) {
			successReviewDao = new SuccessReviewDAOImpl();
		}
		return successReviewDao;
	}

	@Override
	public int successReviewAllSelectCount(SqlMapClient smc) throws SQLException {
		int resCnt = (int)smc.queryForObject("successReview.successReviewAllSelectCount");
		return resCnt;
	}

	@Override
	public List<SuccessReviewVO> successReviewSelect(SqlMapClient smc, PagingVO pageVO) throws SQLException {
		List<SuccessReviewVO> successReviewList = new ArrayList<SuccessReviewVO>();
		successReviewList = smc.queryForList("successReview.successReviewAllSelect", pageVO);
		return successReviewList;
	}

	@Override
	public SuccessReviewVO getSuccessReview(SqlMapClient smc, String successReviewCode) throws SQLException {
		SuccessReviewVO successReviewVO = (SuccessReviewVO) smc.queryForObject("successReview.getSuccessReview", successReviewCode);
		return successReviewVO;
	}

	@Override
	public int insert(SqlMapClient smc, SuccessReviewVO successReviewVO) throws SQLException {
		int cnt = 0;
		Object obj = smc.insert("successReview.insert", successReviewVO);
		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int update(SqlMapClient smc, SuccessReviewVO successReviewVO) throws SQLException {
		int cnt = smc.update("successReview.update", successReviewVO);
		return cnt;
	}

	@Override
	public int delete(SqlMapClient smc, String successReviewCode) throws SQLException {
		int cnt = smc.delete("successReview.delete", successReviewCode);
		return cnt;
	}
}
