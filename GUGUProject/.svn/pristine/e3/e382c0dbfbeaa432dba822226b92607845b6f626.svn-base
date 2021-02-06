package handler.successReview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.SuccessReviewService;
import serviceImpl.SuccessReviewServiceImpl;
import util.JsonResolver;
import vo.IntroductionVO;
import vo.SuccessReviewVO;

public class SuccessReviewSelectHandler implements CommonHandler {
	private static final String VIEW_PAGE = "/WEB-INF/view/successreview/successreviewSelect.jsp";
	private SuccessReviewService successReviewService = SuccessReviewServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		if(req.getMethod().equals("GET")) {
			return VIEW_PAGE;
			
		}else if(req.getMethod().equals("POST")) {
			
			String successReviewCode = req.getParameter("successReviewCode");
			System.out.println(successReviewCode);
			SuccessReviewVO successReviewVO =  successReviewService.getSuccessReview(successReviewCode);
			
			JsonResolver.view(res, successReviewVO);
		}
		return null;
		
	}

}
