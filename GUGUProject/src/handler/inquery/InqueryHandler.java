package handler.inquery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;

public class InqueryHandler implements CommonHandler {
	private static final String VIEW_PAGE = "/WEB-INF/view/inquery/inquerymember.jsp";
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		 
		return VIEW_PAGE;
	}

}
