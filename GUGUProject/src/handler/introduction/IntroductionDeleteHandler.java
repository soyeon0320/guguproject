package handler.introduction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.IntroductionService;
import serviceImpl.IntroductionServiceImpl;

public class IntroductionDeleteHandler implements CommonHandler{
	
	private IntroductionService introductionService = IntroductionServiceImpl.getInstance();

	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String introductionCode = req.getParameter("introductionCode");
		int cnt = introductionService.delete(introductionCode);
		
		String msg = "";
		if(cnt > 0) {
			msg = "success";
		}else {
			msg = "fail";
		}
		
		return req.getContextPath() + "/introduction/list.do?msg=" + msg;
	}

}
