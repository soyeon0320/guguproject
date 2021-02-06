package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import dao.ResumeDAO;
import vo.PagingVO;
import vo.ResumeVO;

/**
 * 이력서 DAO 구현부
 * @author ksy
 */
public class ResumeDAOImpl implements ResumeDAO{
	private static ResumeDAO resumeDao;

	public ResumeDAOImpl() {
		
	}
	
	/**
	 * 이력서 DAO 객체 생성
	 * @return 이미 존재하면 현재 객체를 반환하고 존재하지 않는다면 새로운 객체를 생성
	 */
	public static ResumeDAO getInstance() {
		if(resumeDao==null) {
			resumeDao = new ResumeDAOImpl();
		}
		return resumeDao;
	}
	
	/**
	 * 이력서 전체 조회
	 */
	@Override
	public List<ResumeVO> ResumeAllSelect(SqlMapClient smc, PagingVO pv) throws SQLException {
		List<ResumeVO> resumeList = new ArrayList<ResumeVO>();
		resumeList = smc.queryForList("resume.ResumeAllSelect", pv);
		return resumeList;
	}

	/**
	 * 이력서 상세 조회
	 */
	@Override
	public List<ResumeVO> ResumeSelect(SqlMapClient smc, ResumeVO rv) throws SQLException {
		List<ResumeVO> resumeList = new ArrayList<ResumeVO>();
		resumeList = smc.queryForList("resume.ResumeSelect", rv);
		return resumeList;
	}

	/**
	 * 이력서 등록
	 */
	@Override
	public int ResumeInsert(SqlMapClient smc, ResumeVO rv) throws SQLException {
		int resCnt = 0;
		Object obj = smc.insert("resume.ResumeInsert", rv);
		if(obj==null) {
			resCnt = 1;
		}
		return resCnt;
	}

	/**
	 * 이력서 데이터 전제 갯수 조회
	 */
	@Override
	public int ResumeAllSelectCount(SqlMapClient smc) throws SQLException {
		int resCnt = (int)smc.queryForObject("resume.ResumeAllSelectCount");
		return resCnt;
	}

	/**
	 * 이력서 삭제
	 */
	@Override
	public int ResumeDelete(SqlMapClient smc, String resumeCode) throws SQLException {
		int resCnt = 0;
		resCnt = smc.delete("resume.ResumeDelete", resumeCode);
		return resCnt;
	}

	/**
	 * 이력서 수정
	 */
	@Override
	public int ResumeUpdate(SqlMapClient smc, ResumeVO rv) throws SQLException {
		int resCnt = smc.update("resume.ResumeUpdate", rv);
		return resCnt;
	}
	
}
