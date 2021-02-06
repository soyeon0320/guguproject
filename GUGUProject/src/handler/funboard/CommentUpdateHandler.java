package handler.funboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.CommonHandler;
import service.CommentService;
import service.FunBoardService;
import serviceImpl.CommentServiceImpl;
import vo.CommentVO;
import vo.FunBoardVO;

/**
 * 댓글 수정 핸들러
 * @author ksy
 */
public class CommentUpdateHandler implements CommonHandler{
	//이동할 페이지
	private static final String VIEW_PAGE_GO = "/WEB-INF/view/funboard/commentUpdate.jsp";
	
	/**
	 * 리다이렉트 여부
	 */
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	/**
	 * 작업을 처리할 메소드
	 */
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equals("GET")) {
			String commentCode = req.getParameter("commentCode");
			String content = req.getParameter("content");
			CommentVO cv = new CommentVO();
			cv.setCode(commentCode);
			cv.setContent(content);
			return VIEW_PAGE_GO;
		}else if(req.getMethod().equals("POST")) {
			String commentCode = req.getParameter("commentCode");
			String content = req.getParameter("content");	
			CommentVO cv = new CommentVO();
			cv.setContent(content);
			cv.setCode(commentCode);
			
			CommentService commentService = CommentServiceImpl.getInstance();
			commentService.CommentUpdate(cv);
		}
		return null;
	}
}
