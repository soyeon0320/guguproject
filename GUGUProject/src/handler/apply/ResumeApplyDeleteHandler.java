package handler.apply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.ApplyService;
import serviceImpl.ApplyServiceImpl;

public class ResumeApplyDeleteHandler implements CommonHandler{
	private ApplyService applyService = ApplyServiceImpl.getInstance();

	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String resumeCode = req.getParameter("resumeCode");
		
		int cnt = applyService.resumeDelete(resumeCode);
		
		if(cnt > 0) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
		
		
		return null;
	}

}
