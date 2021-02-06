package serviceImpl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.JobnewsDAO;
import daoImpl.JobNewsDAOImpl;
import service.JobNewsService;
import util.SqlMapClientFactory;
import vo.JobNewsVO;


public class JobNewsServiceImpl implements JobNewsService{
	private static JobNewsService jobnewsService;
	private JobnewsDAO jobnewsDao;
	private SqlMapClient smc;
	
	public JobNewsServiceImpl() {
		jobnewsDao = JobNewsDAOImpl.getInstance(); 
		smc=SqlMapClientFactory.getInstance();
	}
	
	public static JobNewsService getInstance() {
		if(jobnewsService==null) {
			jobnewsService = new JobNewsServiceImpl();
		}
		return jobnewsService;
	}	
	
	//list
	@Override
	public List<JobNewsVO> jobnewsAllSelect(JobNewsVO jv) {
		List<JobNewsVO> jobnewsList = Collections.emptyList();
		try {
			jobnewsList = jobnewsDao.jobnewsAllSelect(smc, jv);
		}catch(SQLException e) {
			throw new RuntimeException("전체 게시글 조회 중 예외 발생!!!", e);
		}
		return jobnewsList;
	}
	
	//등록
	@Override
	public int jobnewsInsert(JobNewsVO jv) {
		int cnt = 0;
		
		try {
			smc.startTransaction();
			
			cnt = jobnewsDao.jobnewsInsert(smc, jv);
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
	public int jobnewsDelete (String jobnewsCode) {
		int cnt = 0;
		try {
		cnt = jobnewsDao.jobnewsDelete(smc, jobnewsCode); 
		}catch (Exception e) {
			throw new RuntimeException("삭제중 예외 발생", e);
		}
		return cnt;
	}
	
	//상세조회
	@Override
	public List<JobNewsVO> getSearchJobnews(JobNewsVO mv) {
		
		List<JobNewsVO> memList = Collections.emptyList();
		
		try {
			memList = jobnewsDao.getSearchJobnews(smc, mv);
			
		} catch (SQLException e) {
			throw new RuntimeException("검색중 예외발생", e);
		} 
				
		return memList;
	}

	//수정
	@Override
	public int jobnewsUpdate(JobNewsVO jv) {
		int cnt = 0;
		
		try {
			
			cnt = jobnewsDao.jobnewsUpdate(smc, jv);
			
		} catch(SQLException e) {
			throw new RuntimeException("정보 수정중 예외발생", e);
		}
		return cnt;
	}

	
	
}
