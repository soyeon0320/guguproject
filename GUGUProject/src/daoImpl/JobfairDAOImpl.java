package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.JobfairDAO;
import vo.JobfairVO;
import vo.PagingVO;
import vo.SuccessReviewVO;

public class JobfairDAOImpl  implements JobfairDAO{
static JobfairDAO jobfairDao;

private JobfairDAOImpl() {
		
	}
public static JobfairDAO getInstance() {
	if(jobfairDao==null) {
		jobfairDao = new JobfairDAOImpl();
	}
	return jobfairDao;
}
	//jobfair리스트 전체조회
	@Override
	public List<JobfairVO> jobfairAllSelect(SqlMapClient smc, PagingVO pageVO) throws SQLException {
		List<JobfairVO> jobfairList = new ArrayList<JobfairVO>();
		jobfairList = smc.queryForList("jobfair.JobfairAllSelect", pageVO);
		return jobfairList;
	}
	//페이징처리
	@Override
	public List<JobfairVO> JobfairSelect(SqlMapClient smc, PagingVO pageVO) throws SQLException {
		List<JobfairVO> jobfairList = new ArrayList<JobfairVO>();
		jobfairList = smc.queryForList("jobfair.jobfairAllSelect", pageVO);
		return jobfairList;
	}
	
	//jobfair 등록
	@Override
	public int jobfairInsert(SqlMapClient smc, JobfairVO jv) throws SQLException {

		int cnt = 0;
		
		Object obj = smc.insert("jobfair.jobfairInsert",jv);
		
		if(obj==null) {
			cnt=1;
		}
		return cnt;
	}

	//jobfair 삭제
	@Override
	public int jobfairDelete(SqlMapClient smc, String jobfairCode) throws SQLException {
		int resCnt = 0;
		resCnt = smc.delete("jobfair.jobfairDelete", jobfairCode);
		return resCnt;
	}
	
	//jobfair 상세검색(상세조회)=>select
	@Override
	public List<JobfairVO> getSearchJobfair (SqlMapClient smc, JobfairVO jv) throws SQLException {
		List<JobfairVO> jobfairList = new ArrayList<>();
		jobfairList = smc.queryForList("jobfair.getSearchJobfair", jv);
		return jobfairList;
	}
	
	//jobfair 수정
	@Override
	public int jobfairUpdate(SqlMapClient smc, JobfairVO jv) throws SQLException {
		
		int cnt = 0;

		cnt = smc.update("jobfair.jobfairUpdate", jv);
		
		return cnt;
		
	}

	@Override
	public boolean getJobfair(SqlMapClient smc, String jobfairCode) throws SQLException {
		return false;
	}
	@Override
	public int JobfairAllSelectCount(SqlMapClient smc)throws SQLException {
		int resCnt = (int)smc.queryForObject("jobfair.JobfairAllSelectCount");
		return resCnt;
	}
	

	

	
}

