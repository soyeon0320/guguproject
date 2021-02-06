package handler.successReview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;

public class SuccessReviewInsertFormHandler implements CommonHandler{
	
	private static final String VIEW_PAGE = "/WEB-INF/view/successreview/successreviewInsertForm.jsp";
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String successReviewCode = req.getParameter("successReviewCode");

		if(successReviewCode != null) {
			return VIEW_PAGE + "?successReviewCode=" + successReviewCode;
		}
		
		return VIEW_PAGE;
	}

}
