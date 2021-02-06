package handler.successReview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonHandler;
import service.SuccessReviewService;
import serviceImpl.SuccessReviewServiceImpl;
import vo.IntroductionVO;
import vo.SuccessReviewVO;

public class SuccessReviewInsertHandler implements CommonHandler{
	private static final String VIEW_PAGE = "/WEB-INF/view/successreview/successreviewList.jsp";
	private SuccessReviewService successReviewService = SuccessReviewServiceImpl.getInstance();

	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession(false);
		
		SuccessReviewVO successReviewVO = new SuccessReviewVO();
		String memberId = (String)session.getAttribute("memberId"); 
		
		successReviewVO.setTitle(req.getParameter("title"));
		successReviewVO.setRegName(req.getParameter("regName"));
		successReviewVO.setContent(req.getParameter("content"));
		successReviewVO.setImgSrc(req.getParameter("imgSrc"));
		successReviewVO.setMemberId(memberId);
		
		int cnt = successReviewService.insert(successReviewVO);
		
		String msg = "";
		if(cnt > 0) {
			msg = "success";
		}else {
			msg = "fail";
		}
		
		
		return req.getContextPath() + "/successReview/successReviewList.do?msg=" + msg;
	}

}
