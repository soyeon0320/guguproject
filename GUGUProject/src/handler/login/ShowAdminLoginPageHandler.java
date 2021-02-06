package handler.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;

public class ShowAdminLoginPageHandler implements CommonHandler {
	private static final String VIEW_PAGE = "/WEB-INF/view/login/adminlogin.jsp";

	@Override
	public boolean RedirectYn(HttpServletRequest req) {

		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		return VIEW_PAGE;
	}
}
