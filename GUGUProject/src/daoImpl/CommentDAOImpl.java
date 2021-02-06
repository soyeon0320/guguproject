package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import dao.CommentDAO;
import util.SqlMapClientFactory;
import vo.CommentVO;

/**
 * 댓글 DAO 구현부
 * @author ksy
 */
public class CommentDAOImpl implements CommentDAO{
	private static CommentDAO commentDao;
	private SqlMapClient smc;
	
	public CommentDAOImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	/**
	 * 댓글 dao 객체 생성
	 * @return 현재 객체가 존재하면 현재 객체를 반환
	 */
	public static CommentDAO getInstance() {
		if(commentDao==null) {
			commentDao = new CommentDAOImpl();
		}
		return commentDao;
	}

	/**
	 * 댓글 전체 조회
	 */
	@Override
	public List<CommentVO> CommentAllSelect(CommentVO cv) throws SQLException {
		List<CommentVO> commentList = Collections.emptyList();
		commentList = smc.queryForList("funBoard.CommentAllSelect", cv);
		return commentList;
	}

	/**
	 * 댓글 등록
	 */
	@Override
	public int CommentInsert(CommentVO cv) throws SQLException {
		int resCnt = 0;
		Object obj = smc.insert("funBoard.CommentInsert", cv);
		if(obj == null) {
			resCnt = 1;
		}
		return resCnt;
	}

	/**
	 * 댓글 삭제
	 */
	@Override
	public int CommentDelete(String commentCode) throws SQLException {
		int resCnt = 0;
		resCnt = smc.delete("funBoard.CommentDelete", commentCode);
		return resCnt;
	}

	/**
	 * 댓글 수정
	 */
	@Override
	public int CommentUpdate(CommentVO cv) throws SQLException {
		int resCnt = 0;
		resCnt = smc.update("funBoard.CommentUpdate", cv);
		return resCnt;
	}

	/**
	 * 댓글 데이터 전체 조회
	 */
	@Override
	public int CommentAllSelectCount() throws SQLException {
		int resCnt = (int)smc.queryForObject("funBoard.CommentAllSelectCount");
		return resCnt;
	}

	

	
}
