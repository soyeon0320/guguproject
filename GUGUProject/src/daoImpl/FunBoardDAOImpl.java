package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import dao.FunBoardDAO;
import vo.FunBoardVO;
import vo.PagingVO;

/**
 * 자유게시판 DAO 구현부
 * @author ksy
 */
public class FunBoardDAOImpl implements FunBoardDAO{
	private static FunBoardDAO funBoardDao;
	
	private FunBoardDAOImpl() {
	}
	
	/**
	 * 자유게시판 DAO 객체 생성
	 * @return 현재 객체가 존재하면 현재 객체를 반환하고 존재하지 않는다면 객체를 생성
	 */
	public static FunBoardDAO getInstance() {
		if(funBoardDao==null) {
			funBoardDao = new FunBoardDAOImpl();
		}
		return funBoardDao;
	}
	
	/**
	 * 자유게시판 전체 조회
	 */
	public List<FunBoardVO> FunBoardAllSelect(SqlMapClient smc, PagingVO pv) throws SQLException {
		List<FunBoardVO> funBoardList = new ArrayList<FunBoardVO>();
		funBoardList = smc.queryForList("funBoard.FunBoardAllSelect", pv);
		return funBoardList;
	}
	
	/**
	 * 자유게시판 전체 데이터 갯수 조회
	 */
	@Override
	public int FunBoardAllSelectCount(SqlMapClient smc) throws SQLException {
		int resCnt = (int)smc.queryForObject("funBoard.FunBoardAllSelectCount");
		return resCnt;
	}

	/**
	 * 자유게시판 상세 조회
	 */
	@Override
	public List<FunBoardVO> FunBoardSelect(SqlMapClient smc, FunBoardVO fbv) throws SQLException {
		List<FunBoardVO> funBoardList = new ArrayList<FunBoardVO>();
		funBoardList = smc.queryForList("funBoard.FunBoardSelect", fbv);
		return funBoardList;
	}

	/**
	 * 자유게시판 등록
	 */
	@Override
	public int FunBoardInsert(SqlMapClient smc, FunBoardVO fbv) throws SQLException {
		int resCnt = 0;
		Object obj = smc.insert("funBoard.FunBoardInsert", fbv);
		if(obj == null) {
			resCnt = 1;
		}
		return resCnt;
	}

	/**
	 * 자유게시판 수정
	 */
	@Override
	public int FunBoardUpdate(SqlMapClient smc, FunBoardVO fbv) throws SQLException {
		int resCnt = 0;
		resCnt = smc.update("funBoard.FunBoardUpdate", fbv);
		return resCnt;
	}

	/**
	 * 자유게시판 삭제
	 */
	@Override
	public int FunBoardDelete(SqlMapClient smc, String funBoardCode) throws SQLException {
		int resCnt = 0;
		resCnt = smc.delete("funBoard.FunBoardDelete", funBoardCode);
		return resCnt;
	}

	
}
