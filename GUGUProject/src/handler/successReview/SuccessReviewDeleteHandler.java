package handler.successReview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.SuccessReviewService;
import serviceImpl.SuccessReviewServiceImpl;

public class SuccessReviewDeleteHandler implements CommonHandler{
	private SuccessReviewService successReviewService = SuccessReviewServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String successReviewCode = req.getParameter("successReviewCode");
		int cnt = successReviewService.delete(successReviewCode);
		
		String msg = "";
		if(cnt > 0) {
			msg = "success";
		}else {
			msg = "fail";
		}
		
		return req.getContextPath() + "/successReview/successReviewList.do?msg=" + msg;
	}
}
