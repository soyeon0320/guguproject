package handler.funboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.CommonHandler;
import service.FunBoardService;
import service.MemberService;
import serviceImpl.FunBoardServiceImpl;
import serviceImpl.MemberServiceImpl;
import vo.FunBoardVO;
import vo.MemberVO;

/**
 * 자유게시판 등록 핸들러
 * @author ksy 
 */
public class FunBoardInsertHandler implements CommonHandler{
	//이동할 페이지
	private static final String VIEW_PAGE_GO = "/WEB-INF/view/funboard/funboardInsert.jsp";

	/**
	 * 리다이렉트 여부
	 * GET : N
	 * POST : Y
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
		}else if(req.getMethod().equals("POST")){
			//db에 등록할 객체
			String funBoardTitle = req.getParameter("funBoardTitle");
			String funBoardContent = req.getParameter("funBoardContent");
			String memId = req.getParameter("memId");
			
			FunBoardService funBoardService = FunBoardServiceImpl.getInstance();
			
			FunBoardVO fbv = new FunBoardVO();
			
			fbv.setTitle(funBoardTitle);
			fbv.setContent(funBoardContent);
			fbv.setMemId(memId);

			int resCnt = funBoardService.FunBoardInsert(fbv);
			
			String message = "";
			if(resCnt > 0) {
				message = "success";
			}else {
				message = "fail";
			}
			
			String redirectUrl = req.getContextPath() + "/funboard/list.do?msg=" + message;
			return redirectUrl;
		}
		return null;
	}
}
