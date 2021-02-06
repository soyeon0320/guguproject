package serviceImpl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.execution.SqlExecutor;

import dao.FunBoardDAO;
import daoImpl.FunBoardDAOImpl;
import service.FunBoardService;
import util.SqlMapClientFactory;
import vo.FunBoardVO;
import vo.PagingVO;

/**
 * 자유게시판 서비스 구현부
 * @author ksy
 */
public class FunBoardServiceImpl implements FunBoardService{
	private static FunBoardService funBoardService;	
	private FunBoardDAO funBoardDao;
	private SqlMapClient smc;

	/**
	 * 자유게시판 서비스 객체 생성
	 * @return 객체가 존재하지 않을 때는 객체를 생성을 하고 객체가 존재하면 기존에 있는 객체를 반환
	 */
	public static FunBoardService getInstance() {
		if(funBoardService==null) {
			funBoardService = new FunBoardServiceImpl();
		}
		return funBoardService;
	}
	
	public FunBoardServiceImpl() {
		funBoardDao = FunBoardDAOImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	
	/**
	 * 자유게시판 전체 조회
	 */
	@Override
	public List<FunBoardVO> FunBoardAllSelect(PagingVO pv) {
		List<FunBoardVO> funBoardList = Collections.emptyList();
		try {
			funBoardList = funBoardDao.FunBoardAllSelect(smc, pv);
		}catch(SQLException e) {
			throw new RuntimeException("게시글 전체 조회 중 예외 발생!!!", e);
		}
		return funBoardList;
	}
	
	/**
	 * 자유게시판 전체 갯수 조회
	 */
	@Override
	public int FunBoardAllSelectCount() {
		int resCnt = 0;
		try {
			resCnt = funBoardDao.FunBoardAllSelectCount(smc);
		} catch (SQLException e) {
			throw new RuntimeException("전체 데이터 개수 조회 중 예외 발생",e);
		}
		return resCnt;
	}

	/**
	 * 자유게시판 상세 조회
	 */
	@Override
	public List<FunBoardVO> FunBoardSelect(FunBoardVO fbv) {
		List<FunBoardVO> funBoardList = Collections.emptyList();
		try {
			funBoardList = funBoardDao.FunBoardSelect(smc, fbv);
		}catch(SQLException e) {
			throw new RuntimeException("게시글 부분 조회 중 예외 발생!!", e);
		}
		return funBoardList;
	}

	/**
	 * 자유게시판 등록
	 */
	@Override
	public int FunBoardInsert(FunBoardVO fbv) {
		int resCnt = 0;
		try {
			smc.startTransaction();
			resCnt = funBoardDao.FunBoardInsert(smc, fbv);
			smc.commitTransaction();
		}catch(SQLException e) {
			try {
				smc.endTransaction();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				smc.endTransaction();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return resCnt;
	}

	/**
	 * 자유게시판 수정
	 */
	@Override
	public int FunBoardUpdate(FunBoardVO fbv) {
		int resCnt = 0;
			try {
				resCnt = funBoardDao.FunBoardUpdate(smc, fbv);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return resCnt;
	}

	/**
	 * 자유게시판 삭제
	 */
	@Override
	public int FunBoardDelete(String funBoardCode) {
		int resCnt = 0;
		try {
			resCnt = funBoardDao.FunBoardDelete(smc, funBoardCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resCnt;
	}


}
