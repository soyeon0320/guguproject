package handler.introduction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;

public class IntroductionInsertFormHandler implements CommonHandler{
	
	private static final String VIEW_PAGE ="/WEB-INF/view/introduction/introductionInsertForm.jsp";
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String from = req.getParameter("from");
		if(from != null && from.equals("modify")) { // null 에대한 컨트롤을 반드시 해줘야 에러가 안남..
			String code = req.getParameter("code");
			return VIEW_PAGE + "?introductionCode=" + code;
		}
		
		return VIEW_PAGE;
	}
}
