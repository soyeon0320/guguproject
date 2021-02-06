package handler.introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonHandler;
import service.IntroductionService;
import serviceImpl.IntroductionServiceImpl;
import vo.IntroductionVO;
import vo.MemberPagingVO;
import vo.PagingVO;

public class IntroductionListHandler implements CommonHandler{
	private static final String VIEW_PAGE ="/WEB-INF/view/introduction/introductionList.jsp";
	private IntroductionService introductionService = IntroductionServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
//		String memberId = req.getParameter("memberId");
		
		HttpSession session = req.getSession(false);
		String memberId = (String)session.getAttribute("memberId");
		
		int pageNo = req.getParameter("pageNo")==null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
//		PagingVO pageVO = new PagingVO();
		
		MemberPagingVO memberPageVO = new MemberPagingVO();
		
//		int introductionTotal = introductionService.introductionAllSelectCount(); // 데이터의 전체 갯수 데이터
//		pageVO.setTotalCount(introductionTotal);
//		pageVO.setCurrentPageNo(pageNo);
//		pageVO.setCountPerPage(10);
//		pageVO.setPageSize(10);
//		req.setAttribute("pageVO", pageVO);
//		
//		List<IntroductionVO> introductionList = introductionService.introductionAllSelect(pageVO); // pageVO정보를 바탕으로한 1페이지의 리스트 데이터
//		List<IntroductionVO> MemberintroductionList = new ArrayList<IntroductionVO>();
//		Collections.reverse(introductionList);
//		
//		for (IntroductionVO introductionVO : introductionList) {
//			if(introductionVO.getMemberId().equals(memberId)) {
//				MemberintroductionList.add(introductionVO);
//			}
//		}
		
		int memberIntroductionTotal = introductionService.memberIntroductionAllSelectCount(memberId); // 회원별 자소서의 전체 갯수 데이터
		memberPageVO.setTotalCount(memberIntroductionTotal);
		memberPageVO.setCurrentPageNo(pageNo);
		memberPageVO.setCountPerPage(10);
		memberPageVO.setPageSize(10);
		memberPageVO.setMemberId(memberId);
		req.setAttribute("memberPageVO", memberPageVO);		
		// => memberId 별로 페이징 데이터 생성
		
		System.out.println(memberPageVO);
		
		List<IntroductionVO> MemberintroductionList = introductionService.memberIntroductionAllSelect(memberPageVO);
		// => memberId별 페이징 데이터를 기반으로한 한페이지의 게시판 리스트 데이터 생성
		
//		Collections.reverse(MemberintroductionList);
		
		req.setAttribute("introductionList", MemberintroductionList);
		
		
		return VIEW_PAGE;
	}

}
