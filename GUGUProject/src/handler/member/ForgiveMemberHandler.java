package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.MemberService;
import serviceImpl.MemberServiceImpl;

public class ForgiveMemberHandler implements CommonHandler{
	
	MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String memberId = req.getParameter("memberId");
		
		int resCnt = memberService.memberForgive(memberId);
		
		return null;
	}

}
