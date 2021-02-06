package handler.successReview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonHandler;
import service.IntroductionService;
import service.SuccessReviewService;
import serviceImpl.IntroductionServiceImpl;
import serviceImpl.SuccessReviewServiceImpl;
import vo.IntroductionVO;
import vo.SuccessReviewVO;

public class SuccessReviewUpdateHandler implements CommonHandler{
	
	private static final String VIEW_PAGE ="/WEB-INF/view/successReview/successReviewSelect.jsp";
	private SuccessReviewService successReviewService = SuccessReviewServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String successReviewCode = req.getParameter("successReviewCode");
		
		HttpSession session = req.getSession(false);
		SuccessReviewVO successReviewVO = new SuccessReviewVO();
		String memberId = (String)session.getAttribute("memberId"); 
		
		successReviewVO.setCode(successReviewCode);
		successReviewVO.setTitle(req.getParameter("title"));
		successReviewVO.setRegName(req.getParameter("regName"));
		successReviewVO.setContent(req.getParameter("content"));
		successReviewVO.setImgSrc(req.getParameter("imgSrc"));
		successReviewVO.setMemberId(memberId);
		
		int cnt = successReviewService.update(successReviewVO);
		
		String msg = "";
		if(cnt > 0) {
			msg = "success";
		}else {
			msg = "fail";
		}
		
		return req.getContextPath() + "/successReview/select.do?successReviewCode=" + successReviewCode + "&msg=" + msg;
	}

}
