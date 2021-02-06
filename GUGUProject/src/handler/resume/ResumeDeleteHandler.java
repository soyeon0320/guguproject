package handler.resume;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.ResumeService;
import serviceImpl.ResumeServiceImpl;

/**
 * 이력서 삭제 핸들러
 * @author ksy
 */
public class ResumeDeleteHandler implements CommonHandler {
	/**
	 * 리다이렉트 여부
	 */
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return true;
	}

	/**
	 * 작업을 처리할 메소드
	 */
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String code = req.getParameter("code");
		
		ResumeService resumeService = ResumeServiceImpl.getInstance();
		
		int resCnt = resumeService.ResumeDelete(code);
		
		String message = "";
		if(resCnt > 0) {
			message = "success";
		}else {
			message = "fail";
		}
		
		return req.getContextPath() + "/resume/list.do?message=" + message;
	}

}
