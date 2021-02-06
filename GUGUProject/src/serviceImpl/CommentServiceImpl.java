package serviceImpl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import dao.CommentDAO;
import daoImpl.CommentDAOImpl;
import service.CommentService;
import vo.CommentVO;
import vo.FunBoardVO;

/**
 * 댓글 서비스 구현부
 * @author ksy
 */
public class CommentServiceImpl implements CommentService{
	private static CommentService commentService;
	private CommentDAO commentDao;
	private SqlMapClient smc;
	
	public static CommentService getInstance() {
		if(commentService==null) {
			commentService = new CommentServiceImpl();
		}
		return commentService;
	}
	
	public CommentServiceImpl() {
		commentDao = CommentDAOImpl.getInstance();
	}

	/**
	 * 댓글 전체 조회
	 */
	@Override
	public List<CommentVO> CommentAllSelect(CommentVO cv) throws SQLException{
		return commentDao.CommentAllSelect(cv);
	}

	/**
	 * 댓글 등록
	 */
	@Override
	public int CommentInsert(CommentVO cv) throws SQLException {
		return commentDao.CommentInsert(cv);
	}

	/**
	 * 댓글 삭제
	 */
	@Override
	public int CommentDelete(String commentCode) throws SQLException {
		return commentDao.CommentDelete(commentCode);
	}

	/**
	 * 댓글 수정
	 */
	@Override
	public int CommentUpdate(CommentVO cv) throws SQLException {
		return commentDao.CommentUpdate(cv);
	}

	/**
	 * 댓글 전체 데이터 갯수
	 */
	@Override
	public int CommentAllSelectCount() throws SQLException {
		return commentDao.CommentAllSelectCount();
	}

	
}
