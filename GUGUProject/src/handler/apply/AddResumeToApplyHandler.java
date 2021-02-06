package handler.apply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.ApplyService;
import serviceImpl.ApplyServiceImpl;
import vo.ApplyVO;

public class AddResumeToApplyHandler implements CommonHandler{
	private ApplyService applyService = ApplyServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String careerCode = req.getParameter("resumeCode");
		String careerTitle = req.getParameter("resumeTitle");
		String memberId = req.getParameter("memberId");
		
		ApplyVO av = new ApplyVO();
		av.setCareerCode(careerCode);
		av.setMemberId(memberId);
		av.setCareerTitle(careerTitle);
		
		int cnt = applyService.addCareer(av);
		
		if(cnt > 0) {
			System.out.println("등록성공");
		}else {
			System.out.println("등록실패");
		}
		
		return null;
	}

}
