package serviceImpl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.SuccessReviewDAO;
import daoImpl.SuccessReviewDAOImpl;
import service.SuccessReviewService;
import util.SqlMapClientFactory;
import vo.PagingVO;
import vo.SuccessReviewVO;

public class SuccessReviewServiceImpl implements SuccessReviewService {
	
	private static SuccessReviewService successReviewService;
	
	private SuccessReviewDAO successReviewDAO;
	private SqlMapClient smc;
	
	public SuccessReviewServiceImpl() {
		successReviewDAO = SuccessReviewDAOImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	

	public static SuccessReviewService getInstance() {
		if(successReviewService == null) {
			successReviewService = new SuccessReviewServiceImpl();
		}
		return successReviewService;
	}


	@Override
	public int SuccessReviewAllSelectCount() {
		int resCnt = 0;
		try {
			resCnt = successReviewDAO.successReviewAllSelectCount(smc);
		} catch (SQLException e) {
			throw new RuntimeException("전체 데이터 개수 조회 중 예외 발생",e);
		}
		return resCnt;
	}


	@Override
	public List<SuccessReviewVO> SuccessReviewAllSelect(PagingVO pageVO) {
		List<SuccessReviewVO> successReviewList = Collections.emptyList();
		try {
			successReviewList = successReviewDAO.successReviewSelect(smc, pageVO);
		}catch(SQLException e) {
			throw new RuntimeException("게시글 부분 조회 중 예외 발생!!", e);
		}
		return successReviewList;
	}


	@Override
	public SuccessReviewVO getSuccessReview(String successReviewCode) {
		SuccessReviewVO successReviewVO = new SuccessReviewVO();
		try {
			successReviewVO = successReviewDAO.getSuccessReview(smc, successReviewCode);
		} catch (SQLException e) {
			throw new RuntimeException("게시글 부분 조회 중 예외 발생!!", e);
		}
		return successReviewVO;
	}


	@Override
	public int insert(SuccessReviewVO successReviewVO) {
		int cnt = 0;
		try {
			cnt = successReviewDAO.insert(smc, successReviewVO);
		} catch (SQLException e) {
			throw new RuntimeException("게시글 부분 조회 중 예외 발생!!", e);
		}
		return cnt;
	}


	@Override
	public int update(SuccessReviewVO successReviewVO) {
		int cnt = 0;
		try {
			cnt = successReviewDAO.update(smc, successReviewVO);
		} catch (SQLException e) {
			throw new RuntimeException("게시글 부분 조회 중 예외 발생!!", e);
		}
		return cnt;
	}


	@Override
	public int delete(String successReviewCode) {
		int cnt = 0;
		try {
			cnt = successReviewDAO.delete(smc, successReviewCode);
		} catch (SQLException e) {
			throw new RuntimeException("게시글 부분 조회 중 예외 발생!!", e);
		}
		return cnt;
	}
}
