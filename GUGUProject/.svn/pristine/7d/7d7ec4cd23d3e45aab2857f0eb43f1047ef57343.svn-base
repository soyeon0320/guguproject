package handler.findaccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.FindAccountService;
import serviceImpl.FindAccountServiceImpl;

public class FindPwGowithIdHandler implements CommonHandler {
	private static final String VIEW_PAGE = "/WEB-INF/view/findaccount/findpassword_email.jsp";
	private FindAccountService findAccountService = FindAccountServiceImpl.getInstance();
	
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String memberId = req.getParameter("memberId");
		
		int cnt = findAccountService.findPwInputId(memberId);
		
		String msg = "";
		String pageinfo = "";
		
		if (cnt > 0) {
			pageinfo = "email";
			return req.getContextPath() + "/opneFindPw.do?memberId=" + memberId + "&pageinfo=" + pageinfo;
		}else {
			msg = "fail";
			return req.getContextPath() + "/opneFindPw.do?msg=" + msg; 
		}
	}

}
