package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.JobnewsDAO;
import vo.JobNewsVO;

public class JobNewsDAOImpl  implements JobnewsDAO{
static JobnewsDAO jobnewsDao;

private JobNewsDAOImpl() {
		
	}
public static JobnewsDAO getInstance() {
	if(jobnewsDao==null) {
		jobnewsDao = new JobNewsDAOImpl();
	}
	return jobnewsDao;
}
	//jobnews리스트 전체조회
	@Override
	public List<JobNewsVO> jobnewsAllSelect(SqlMapClient smc, JobNewsVO jv) throws SQLException {
		List<JobNewsVO> jobnewsList = new ArrayList<JobNewsVO>();
		jobnewsList = smc.queryForList("jobnews.JobnewsAllSelect",jv);
		return jobnewsList;
	}
	
	//jobnews 등록
	@Override
	public int jobnewsInsert(SqlMapClient smc, JobNewsVO jv) throws SQLException {

		int cnt = 0;
		
		Object obj = smc.insert("jobnews.jobnewsInsert",jv);
		
		if(obj==null) {
			cnt=1;
		}
		return cnt;
	}

	//jobnews 삭제
	@Override
	public int jobnewsDelete(SqlMapClient smc, String jobnewsCode) throws SQLException {
		int resCnt = 0;
		resCnt = smc.delete("jobnews.jobnewsDelete", jobnewsCode);
		return resCnt;
	}
	
	//jobnews 상세검색(상세조회)=>select
	@Override
	public List<JobNewsVO> getSearchJobnews (SqlMapClient smc, JobNewsVO jv) throws SQLException {
		List<JobNewsVO> jobnewsList = new ArrayList<>();
		jobnewsList = smc.queryForList("jobnews.getSearchJobnews", jv);
		return jobnewsList;
	}
	
	//jobnews 수정
	@Override
	public int jobnewsUpdate(SqlMapClient smc, JobNewsVO jv) throws SQLException {
		
		int cnt = 0;

		cnt = smc.update("jobnews.updateJobnews", jv);
		
		return cnt;
		
	}

	@Override
	public boolean getJobnews(SqlMapClient smc, String jobnewsCode) throws SQLException {
		return false;
	}

	

	
}

