package handler.introduction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.CommonHandler;
import service.IntroductionService;
import serviceImpl.IntroductionServiceImpl;
import util.JsonResolver;
import vo.IntroductionVO;

public class IntroductionSelectHandler implements CommonHandler{
	
	private static final String VIEW_PAGE ="/WEB-INF/view/introduction/introductionSelect.jsp";
	private IntroductionService introductionService = IntroductionServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		if(req.getMethod().equals("GET")) {
			return VIEW_PAGE;
			
		}else if(req.getMethod().equals("POST")) {
			String introductionCode = req.getParameter("introductionCode");
			
			IntroductionVO introductionVO =  introductionService.getIntoduction(introductionCode);
			
			JsonResolver.view(res, introductionVO);
		}
		return null;
	}
}
