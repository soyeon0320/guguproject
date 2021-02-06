package handler.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.MemberService;
import serviceImpl.MemberServiceImpl;
import vo.MemberVO;
import vo.PagingVO;

public class MemberListHandler implements CommonHandler {
	private static final String VIEW_PAGE_GO = "/WEB-INF/view/member/memberList.jsp";
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		MemberService memberService = MemberServiceImpl.getInstance();
		
		String memberId = req.getParameter("memberId");
		MemberVO mv = new MemberVO();
		mv.setMemberId(memberId);
		
		int pageNo = req.getParameter("pageNo")==null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
		PagingVO pageVO = new PagingVO();
		
		int memberTotal = memberService.memberAllSelectCount();
		pageVO.setTotalCount(memberTotal);
		pageVO.setCurrentPageNo(pageNo);
		pageVO.setCountPerPage(10);
		pageVO.setPageSize(10);
		req.setAttribute("pageVO", pageVO);
		
		List<MemberVO> memberList = memberService.memberAllSelect(pageVO);
		req.setAttribute("memberList", memberList);
		
		return VIEW_PAGE_GO;
	}

}
