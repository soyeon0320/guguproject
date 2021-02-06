package serviceImpl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.IntroductionDAO;
import daoImpl.IntroductionDAOImpl;
import service.IntroductionService;
import util.SqlMapClientFactory;
import vo.IntroductionVO;
import vo.MemberPagingVO;
import vo.PagingVO;

public class IntroductionServiceImpl implements IntroductionService {
	private static IntroductionService introductionService;
	
	private IntroductionDAO introductionDAO;
	private SqlMapClient smc;
	
	public IntroductionServiceImpl() {
		introductionDAO = IntroductionDAOImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	

	public static IntroductionService getInstance() {
		if(introductionService == null) {
			introductionService = new IntroductionServiceImpl();
		}
		return introductionService;
	}


	@Override
	public int introductionAllSelectCount() {
		int resCnt = 0;
		try {
			resCnt = introductionDAO.introductionAllSelectCount(smc);
		} catch (SQLException e) {
			throw new RuntimeException("전체 데이터 개수 조회 중 예외 발생",e);
		}
		return resCnt;
	}


	@Override
	public List<IntroductionVO> introductionAllSelect(PagingVO pageVO) {
		List<IntroductionVO> introductionList = Collections.emptyList();
		try {
			introductionList = introductionDAO.introductionSelect(smc, pageVO);
		}catch(SQLException e) {
			throw new RuntimeException("게시글 부분 조회 중 예외 발생!!", e);
		}
		return introductionList;
	}


	@Override
	public IntroductionVO getIntoduction(String introductionCode) {
		IntroductionVO introductionVO = new IntroductionVO();
		try {
			introductionVO = introductionDAO.getIntroduction(smc, introductionCode);
		} catch (SQLException e) {
			throw new RuntimeException("게시글 부분 조회 중 예외 발생!!", e);
		}
		return introductionVO;
	}


	@Override
	public int insert(IntroductionVO introductionVO) {
		
		int cnt = 0;
		
		try {
			cnt = introductionDAO.insert(smc, introductionVO);
		} catch (SQLException e) {
			throw new RuntimeException("게시글 등록 중 예외 발생!!", e);
		}
		return cnt;
	}


	@Override
	public int update(IntroductionVO introductionVO) {
		
		int cnt = 0;
		
		try {
			cnt = introductionDAO.update(smc, introductionVO);
		} catch (SQLException e) {
			throw new RuntimeException("게시글 등록 중 예외 발생!!", e);
		}
		return cnt;
	}


	@Override
	public int delete(String introductionCode) {
		
		int cnt = 0;
		
		try {
			cnt = introductionDAO.delete(smc, introductionCode);
		} catch (SQLException e) {
			throw new RuntimeException("게시글 등록 중 예외 발생!!", e);
		}
		return cnt;
	}


	@Override
	public int memberIntroductionAllSelectCount(String memberId) {
		int cnt = 0;
		try {
			cnt = introductionDAO.memberIntroductionAllSelectCount(smc, memberId);
		} catch (SQLException e) {
			throw new RuntimeException("전체 데이터 개수 조회 중 예외 발생",e);
		}
		return cnt;
	}


	@Override
	public List<IntroductionVO> memberIntroductionAllSelect(MemberPagingVO memberPageVO) {
		List<IntroductionVO> memberIntroductionList = Collections.emptyList();
		try {
			memberIntroductionList = introductionDAO.memberIntroductionSelect(smc, memberPageVO);
		}catch(SQLException e) {
			throw new RuntimeException("게시글 부분 조회 중 예외 발생!!", e);
		}
		return memberIntroductionList;
	}
}
