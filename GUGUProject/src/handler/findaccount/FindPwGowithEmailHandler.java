package handler.findaccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.FindAccountService;
import serviceImpl.FindAccountServiceImpl;
import vo.MemberVO;

public class FindPwGowithEmailHandler implements CommonHandler {
	private static final String VIEW_PAGE = "/WEB-INF/view/findaccount/findpassword_email.jsp";
	
	private FindAccountService findAccountService = FindAccountServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		
			return true;
		
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String memberEmail = req.getParameter("memberEmail");
		String memberId =  req.getParameter("memberId");
		
		System.out.println(memberId);
		
		
		MemberVO result = findAccountService.findPwInputEmail(memberEmail);
		
		if (result != null) {
			SendPwToEmail.sendPwToEmail(result);
		}
		
		
		String msg = "";
		String pageinfo = "";
		
		if (result != null) {
			return req.getContextPath() + "/findPwResult.do?memberEmail=" + memberEmail;
		}else {
			msg = "fail2";
			pageinfo = "email";
			return req.getContextPath() + "/opneFindPw.do?msg=" + msg + "&pageinfo=" + pageinfo + "&memberId=" + memberId; 
		}
		
		
		
		
	}

}
