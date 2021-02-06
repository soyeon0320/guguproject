package handler.findaccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;

public class OpenFindPwHandler implements CommonHandler{
	
	private static final String VIEW_PAGE = "/WEB-INF/view/findaccount/findpassword.jsp";
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("이거는 됨?");
		return VIEW_PAGE;
	}

}
