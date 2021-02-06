package handler.funboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.CommentService;
import service.FunBoardService;
import serviceImpl.CommentServiceImpl;
import serviceImpl.FunBoardServiceImpl;
import vo.CommentVO;
import vo.FunBoardVO;

/**
 * 댓글 등록 핸들러
 * @author ksy
 */
public class CommentInsertHandler implements CommonHandler{
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

	/**
	 * 작업을 처리할 메소드
	 */
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equals("GET")) {
			return VIEW_PAGE_GO;
		}else if(req.getMethod().equals("POST")) {
			String funBoardCode = req.getParameter("funBoardCode");
			
			FunBoardVO fbv = new FunBoardVO();
			fbv.setCode(funBoardCode);
			
			FunBoardService funBoardService = FunBoardServiceImpl.getInstance();
			List<FunBoardVO> funBoardList = funBoardService.FunBoardSelect(fbv);
			
			req.setAttribute("funBoardVO", funBoardList.get(0));
			
			String regName = req.getParameter("regName");
			String content = req.getParameter("content");
			
			CommentVO cv = new CommentVO();
			//현재 클릭된 자유 게시판에서 댓글 등록을 해야하기 때문에 사용자가 클릭한 게시판의 코드를 가져와서 댓글 fk에 추가
			cv.setFunBoardCode(funBoardList.get(0).getCode());
			cv.setRegName(regName);
			cv.setContent(content);
			
			CommentService commentService = CommentServiceImpl.getInstance();
			
			int resCnt = commentService.CommentInsert(cv);
			
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
