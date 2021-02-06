package serviceImpl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.ApplyDAO;
import daoImpl.ApplyDAOImpl;
import service.ApplyService;
import util.SqlMapClientFactory;
import vo.ApplyVO;
import vo.IntroductionVO;

public class ApplyServiceImpl implements ApplyService {
	private static ApplyService applyService;
	
	private ApplyDAO applyDAO;
	private SqlMapClient smc;
	
	public ApplyServiceImpl() {
		applyDAO = ApplyDAOImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	

	public static ApplyService getInstance() {
		if(applyService == null) {
			applyService = new ApplyServiceImpl();
		}
		return applyService;
	}

	@Override
	public int addIntro(ApplyVO av) {

		int cnt = 0;
		
		try {
			cnt = applyDAO.addIntro(smc, av);
		} catch (SQLException e) {
			throw new RuntimeException("예외 발생!!", e);
		}
		return cnt;
	}


	@Override
	public List<ApplyVO> getList(String memberId) {
		
		List<ApplyVO> avList = null;
		try {
			avList = applyDAO.getList(smc, memberId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return avList;
	}


	@Override
	public int addCareer(ApplyVO av) {
		int cnt = 0;
		
		try {
			cnt = applyDAO.addCareer(smc, av);
		} catch (SQLException e) {
			throw new RuntimeException("예외 발생!!", e);
		}
		return cnt;
	}


	@Override
	public int resumeDelete(String resumeCode) {
		int cnt = 0;
		
		try {
			cnt = applyDAO.resumeDelete(smc, resumeCode);
		} catch (SQLException e) {
			throw new RuntimeException("예외 발생!!", e);
		}
		return cnt;
	}


	@Override
	public int introDelete(String introCode) {
		int cnt = 0;
		try {
			cnt = applyDAO.introDelete(smc, introCode);
		} catch (SQLException e) {
			throw new RuntimeException("예외 발생", e);
		}
		return cnt;
	}
}
