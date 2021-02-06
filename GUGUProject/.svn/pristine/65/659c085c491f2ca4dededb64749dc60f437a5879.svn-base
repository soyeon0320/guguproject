package handler.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonHandler;

public class LogoutHandler implements CommonHandler {
	
	private static final String VIEW_PAGE = "/index.do";
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			
			session.invalidate();
			
		}
		
		String redirectURL = req.getContextPath() + VIEW_PAGE + "?msg=logout";
		
		
		return redirectURL;
	}

}
