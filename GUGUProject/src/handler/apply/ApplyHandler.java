package handler.apply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonHandler;
import service.ApplyService;
import serviceImpl.ApplyServiceImpl;
import vo.ApplyVO;

public class ApplyHandler implements CommonHandler {
	private static final String VIEW_PAGE = "/WEB-INF/view/apply/apply.jsp";
	private ApplyService applyService = ApplyServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession(false);
		String memberId = (String)session.getAttribute("memberId");
		
		List<ApplyVO> avList = applyService.getList(memberId);
		
		req.setAttribute("avList", avList);
		
//		System.out.println(avList.get(0).getIntroTitle());
		
		return VIEW_PAGE;
	}

}
