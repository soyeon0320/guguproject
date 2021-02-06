package service;

import java.sql.SQLException;
import java.util.List;
import vo.CommentVO;
import vo.FunBoardVO;

/**
 * 댓글 서비스
 * @author ksy
 */
public interface CommentService {
	/**
	 * 댓글 전체 조회
	 * @param cv 댓글 정보가 담긴 객체
	 * @return 댓글 목록
	 * @throws SQLException 예외 처리
	 */
	public List<CommentVO> CommentAllSelect(CommentVO cv) throws SQLException;
	
	/**
	 * 댓글 데이터 전체 갯수
	 * @return 댓글 갯수
	 * @throws SQLException 예외 처리
	 */
	public int CommentAllSelectCount() throws SQLException;
	
	/**
	 * 댓글 등록
	 * @param cv 댓글 정보가 담긴 객체
	 * @return 0:등록 실패 1:등록 성공
	 * @throws SQLException 예외 처리
	 */
	public int CommentInsert(CommentVO cv) throws SQLException;
	
	/**
	 * 댓글 삭제
	 * @param commentCode 댓글을 구분할 수 있는 고유 코드
	 * @return 0:삭제 실패 1:삭제 성공
	 * @throws SQLException 예외 처리
	 */
	public int CommentDelete(String commentCode) throws SQLException;
	
	/**
	 * 댓글 수정
	 * @param cv 댓글 정보가 담긴 객체
	 * @return 0:수정 실패 1:수정 성공
	 * @throws SQLException 예외 처리
	 */
	public int CommentUpdate(CommentVO cv) throws SQLException;
}
