package handler.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.MemberService;
import serviceImpl.MemberServiceImpl;
import vo.MemberVO;

public class MemberSelectHandler implements CommonHandler {
	private static final String VIEW_PAGE_GO = "/WEB-INF/view/member/memberSelect.jsp";

	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}
		
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String memberId = req.getParameter("memberId");
		MemberVO mv = new MemberVO();
		mv.setMemberId(memberId);
		
		MemberService memberService = MemberServiceImpl.getInstance();
		List<MemberVO> memberList = memberService.memberSelect(mv);
		req.setAttribute("memberVO", memberList.get(0));
		
		return VIEW_PAGE_GO;
	}
}