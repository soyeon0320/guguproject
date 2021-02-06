package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonHandler;
import service.MemberService;
import serviceImpl.MemberServiceImpl;
import vo.MemberVO;

public class MemberDeleteHandler implements CommonHandler {
	
	MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession(false);
		
		String memberId = req.getParameter("memberId");
		
		int resCnt = memberService.memberDelete(memberId);
		
		session.invalidate();
		
		return null;
	}

}
