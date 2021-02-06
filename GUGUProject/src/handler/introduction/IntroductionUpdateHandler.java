package handler.introduction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonHandler;
import service.IntroductionService;
import serviceImpl.IntroductionServiceImpl;
import vo.IntroductionVO;

public class IntroductionUpdateHandler implements CommonHandler{
	
	private static final String VIEW_PAGE ="/WEB-INF/view/introduction/introductionSelect.jsp";
	private IntroductionService introductionService = IntroductionServiceImpl.getInstance();

	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String introductionCode = req.getParameter("introductionCode");
		
		HttpSession session = req.getSession(false);
		IntroductionVO introductionVO = new IntroductionVO();
		String memberId = (String)session.getAttribute("memberId"); 
		
		introductionVO.setCode(introductionCode);
		introductionVO.setTitle(req.getParameter("title"));		
		introductionVO.setWriter(req.getParameter("writer"));
		introductionVO.setReason(req.getParameter("reason"));
		introductionVO.setGrowth(req.getParameter("growth"));
		introductionVO.setCareer(req.getParameter("career"));
		introductionVO.setMemberId(memberId);
		
		int cnt = introductionService.update(introductionVO);
		
		String msg = "";
		if(cnt > 0) {
			msg = "success";
		}else {
			msg = "fail";
		}
		
		
		return req.getContextPath() + "/introduction/select.do?introductionCode=" + introductionCode + "&msg=" + msg;
	}

}
