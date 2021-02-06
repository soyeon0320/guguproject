package serviceImpl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.JobfairDAO;
import daoImpl.JobfairDAOImpl;
import service.JobfairService;
import util.SqlMapClientFactory;
import vo.JobfairVO;
import vo.PagingVO;

public class JobfairServiceImpl implements JobfairService{
	private static JobfairService jobfairService;
	private JobfairDAO jobfairDao;
	private SqlMapClient smc;
	private Object pageVO;
	
	public JobfairServiceImpl() {
		jobfairDao = JobfairDAOImpl.getInstance();
		smc=SqlMapClientFactory.getInstance();
	}
	
	public static JobfairService getInstance() {
		if(jobfairService==null) {
			jobfairService = new JobfairServiceImpl();
		}
		return jobfairService;
	}	
	
	//list
	@Override
	public List<JobfairVO> jobfairAllSelect(PagingVO pageVO) {
		List<JobfairVO> jobfairList = Collections.emptyList();
		try {
			jobfairList = jobfairDao.jobfairAllSelect(smc, pageVO);
		}catch(SQLException e) {
			throw new RuntimeException("전체 게시글 조회 중 예외 발생!!!", e);
		}
		return jobfairList;
	}
	
	//등록
	@Override
	public int jobfairInsert(JobfairVO jv) {
		int cnt = 0;
		
		try {
			smc.startTransaction();
			
			cnt = jobfairDao.jobfairInsert(smc, jv);
			smc.commitTransaction();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				smc.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return cnt;
	}
	
	//삭제
	@Override
	public int jobfairDelete (String jobfairCode) {
		int cnt = 0;
		try {
		cnt = jobfairDao.jobfairDelete(smc, jobfairCode); 
		}catch (Exception e) {
			throw new RuntimeException("삭제중 예외 발생", e);
		}
		return cnt;
	}
	
	//상세조회
	@Override
	public List<JobfairVO> getSearchJobfair(JobfairVO mv) {
		
		List<JobfairVO> memList = Collections.emptyList();
		
		try {
			memList = jobfairDao.getSearchJobfair(smc, mv);
			
		} catch (SQLException e) {
			throw new RuntimeException("검색중 예외발생", e);
		} 
				
		return memList;
	}

	//수정
	@Override
	public int jobfairUpdate(JobfairVO jv) {
		int cnt = 0;
		
		try {
			
			cnt = jobfairDao.jobfairUpdate(smc, jv);
			
		} catch(SQLException e) {
			throw new RuntimeException("정보 수정중 예외발생", e);
		}
		return cnt;
	}

	@Override
	public int JobfairAllSelectCount() {
		int resCnt = 0;
		try {
			resCnt = jobfairDao.JobfairAllSelectCount(smc);
		} catch (SQLException e) {
			throw new RuntimeException("전체 데이터 개수 조회 중 예외 발생",e);
		}
		return resCnt;
	}

	
	
	
}
