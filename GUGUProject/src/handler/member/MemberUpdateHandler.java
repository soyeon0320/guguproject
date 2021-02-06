package handler.member;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.CommonHandler;
import service.MemberService;
import serviceImpl.MemberServiceImpl;
import vo.MemberVO;

public class MemberUpdateHandler implements CommonHandler {
	private static final String VIEW_PAGE_GO = "/WEB-INF/view/member/memberUpdate.jsp";
	MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equals("GET")) {
			String memberId = req.getParameter("memberId");
			
			MemberVO mv = new MemberVO();
			mv.setMemberId(memberId);
			
			List<MemberVO> memberList = memberService.memberSelect(mv);
			req.setAttribute("memberVO", memberList.get(0));
			return VIEW_PAGE_GO;
		}else if(req.getMethod().equals("POST")) {
			MemberVO mv = new MemberVO();
			
			String memberId = req.getParameter("memberId");
			String memberName = req.getParameter("memberName");
			String memberGender = req.getParameter("memberGender");
			String memberPhone = req.getParameter("memberPhone");
			String memberEmail = req.getParameter("memberEmail");
			String memberAddr1 = req.getParameter("memberAddr1");
			String memberAddr2 = req.getParameter("memberAddr2");
			String memberBirth = req.getParameter("memberBirth");
			
			mv.setMemberId(memberId);
			mv.setMemberName(memberName);
			mv.setMemberGender(memberGender);
			mv.setMemberPhone(memberPhone);
			mv.setMemberEmail(memberEmail);
			mv.setMemberAddr1(memberAddr1);
			mv.setMemberAddr2(memberAddr2);
			mv.setMemberBirth(memberBirth);
			
			int resCnt = memberService.memberUpdate(mv);
			
			String message = "";
			if(resCnt > 0) {
				message = "success";
			}else {
				message ="fail";
			}
			
			return req.getContextPath() + "/member/select.do?memberId=" + memberId + "&message=" + message;
		}
		return null;
	}

}
