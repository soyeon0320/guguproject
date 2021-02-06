package handler.jobnews;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.JobNewsService;
import serviceImpl.JobNewsServiceImpl;
import vo.JobNewsVO;

public class JobnewsDetailHandler implements CommonHandler {

	private JobNewsService jobnewsService = new JobNewsServiceImpl();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String url = "/WEB-INF/view/jobnews/jobnewsDetail.jsp";
		
		String jobNewsCode = req.getParameter("jobNewsCode");
		
		JobNewsVO jv = new JobNewsVO();
		jv.setJobNewsCode(jobNewsCode);
		
		List<JobNewsVO> jobnewsList = jobnewsService.getSearchJobnews(jv);

		req.setAttribute("jobnewsVo", jobnewsList.get(0));		
		
		return url;
	}

}
