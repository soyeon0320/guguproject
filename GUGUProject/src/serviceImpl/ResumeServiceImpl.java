package serviceImpl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import dao.ResumeDAO;
import daoImpl.ResumeDAOImpl;
import service.ResumeService;
import util.SqlMapClientFactory;
import vo.PagingVO;
import vo.ResumeVO;

/**
 * 이력서 서비스 구현부
 * @author ksy
 */
public class ResumeServiceImpl implements ResumeService{
	private static ResumeService resumeService;
	private SqlMapClient smc;
	private ResumeDAO resumeDao;
	
	/**
	 * 이력서 서비스 객체 생성
	 * @return 현재 객체가 존재하면 현재 객체를 반환
	 */
	public static ResumeService getInstance() {
		if(resumeService==null) {
			resumeService = new ResumeServiceImpl();
		}
		return resumeService;
	}
	
	public ResumeServiceImpl() {
		resumeDao = ResumeDAOImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	
	/**
	 * 이력서 데이터 전체 조회
	 */
	@Override
	public List<ResumeVO> ResumeAllSelect(PagingVO pv) {
		List<ResumeVO> resumeList = Collections.EMPTY_LIST;
		try {
			resumeList = resumeDao.ResumeAllSelect(smc, pv);
		} catch (SQLException e) {
			throw new RuntimeException("이력서 목록 조회 중 예외 발생!", e);
		}
		return resumeList;
	}

	/**
	 * 이력서 상세 조회
	 */
	@Override
	public List<ResumeVO> ResumeSelect(ResumeVO rv) {
		List<ResumeVO> resumeList = Collections.EMPTY_LIST;
		try {
			resumeList = resumeDao.ResumeSelect(smc, rv);
		}catch(SQLException e) {
			throw new RuntimeException("이력서 조회 중 예외 발생!", e);
		}
		return resumeList;
	}

	/**
	 * 이력서 등록
	 */
	@Override
	public int ResumeInsert(ResumeVO rv) {
		int resCnt = 0;
		try {
			resCnt = resumeDao.ResumeInsert(smc, rv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resCnt;
	}

	/**
	 * 이력서 전체 데이터 갯수 조회
	 */
	@Override
	public int ResumeAllSelectCount() {
		int resCnt = 0;
		try {
			resCnt = resumeDao.ResumeAllSelectCount(smc);
		} catch (SQLException e) {
			throw new RuntimeException("전체 데이터 개수 조회 중 예외 발생",e);
		}
		return resCnt;
	}

	/**
	 * 이력서 삭제
	 */
	@Override
	public int ResumeDelete(String resumeCode) {
		int resCnt = 0;
		try {
			resCnt = resumeDao.ResumeDelete(smc, resumeCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resCnt;
	}

	/**
	 * 이력서 수정
	 */
	@Override
	public int ResumeUpdate(ResumeVO rv) {
		int resCnt = 0;
		try {
			resCnt = resumeDao.ResumeUpdate(smc, rv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resCnt;
	}

	
	
}
