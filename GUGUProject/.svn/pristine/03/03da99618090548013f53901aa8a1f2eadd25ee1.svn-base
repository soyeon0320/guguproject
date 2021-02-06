package handler.jobnews;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.JobNewsService;
import serviceImpl.JobNewsServiceImpl;
import vo.JobNewsVO;

public class JobnewsManagerListHandler implements CommonHandler{

	private JobNewsService jobnewsService = new JobNewsServiceImpl();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String url = "/WEB-INF/view/jobnews/jobnewsManagerList.jsp";
		
		String gubun=req.getParameter("GUBUN");
		if(gubun==null) {
			gubun="NEWS";
		}
		
		JobNewsVO jv = new JobNewsVO();
		jv.setJobNewsGubun(gubun);
		
		
		List<JobNewsVO> jobnewsList = jobnewsService.jobnewsAllSelect(jv);

		req.setAttribute("jobnewsList", jobnewsList);		
		req.setAttribute("GUBUN", gubun);		
		
		return url+"?GUBUN="+gubun;
	}
	
}