package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import vo.CommentVO;
import vo.FunBoardVO;
import vo.PagingVO;

/**
 * 댓글 DAO
 * @author ksy
 */
public interface CommentDAO {
	/**
	 * 댓글 전체 조회
	 * @param cv 댓글 정보가 담긴 객체
	 * @return 댓글 리스트
	 * @throws SQLException 예외 처리
	 */
	public List<CommentVO> CommentAllSelect(CommentVO cv) throws SQLException;
	
	/**
	 * 댓글 등록
	 * @param cv 댓글 정보가 담긴 객체
	 * @return 0:실패 1:성공
	 * @throws SQLException 예외 처리
	 */
	public int CommentInsert(CommentVO cv) throws SQLException;
	
	/**
	 * 댓글 삭제
	 * @param commentCode 댓글을 구분할 수 있는 고유 코드
	 * @return 0:실패 1:성공
	 * @throws SQLException 예외 처리
	 */
	public int CommentDelete(String commentCode) throws SQLException;
	
	/**
	 * 
	 * @param cv 댓글 정보가 담긴 객체
	 * @return 0:실패 1:성공
	 * @throws SQLException 예외 처리
	 */
	public int CommentUpdate(CommentVO cv) throws SQLException;
	
	/**
	 * 댓글 전체 갯수 조회
	 * @return 전체 갯수
	 * @throws SQLException 예외 처리
	 */
	public int CommentAllSelectCount() throws SQLException;
	
}
