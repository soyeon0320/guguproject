package handler.funboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.CommonHandler;
import service.CommentService;
import serviceImpl.CommentServiceImpl;
import vo.FunBoardVO;

/**
 * 댓글 삭제 핸들러
 * @author ksy
 */
public class CommentDeleteHandler implements CommonHandler{
	//이동할 페이지
	private static final String VIEW_PAGE_GO = "/WEB-INF/view/funboard/funboardSelect.jsp";

	/**
	 * 리다이렉트 여부
	 */
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equals("GET")) {
			return VIEW_PAGE_GO;
		}else if(req.getMethod().equals("POST")) {
			String funBoardCode = req.getParameter("funBoardCode");
			FunBoardVO fbv = new FunBoardVO();
			fbv.setCode(funBoardCode);
			
			String commentCode = req.getParameter("commentCode");
			CommentService commentService = CommentServiceImpl.getInstance();
			int resCnt = commentService.CommentDelete(commentCode);
			
			String message = "";
			if(resCnt > 0) {
				message = "success";
			}else {
				message = "fail";
			}
			
			String redirectUrl = req.getContextPath() + "/funboard/select.do?funBoardCode=" + funBoardCode + "&message=" + message;
			return redirectUrl;
		}
		return null;
	}
}
