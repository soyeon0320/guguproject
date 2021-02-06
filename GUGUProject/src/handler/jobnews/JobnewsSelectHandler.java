package handler.jobnews;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.JobNewsService;
import serviceImpl.JobNewsServiceImpl;
import vo.JobNewsVO;

public class JobnewsSelectHandler implements CommonHandler {

	private static final String VIEW_PAGE =
			"/WEB-INF/views/jobnews/jobnewsSelect.jsp";
	private JobNewsService jobnewsSerive;
	
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String jobnewsCode = req.getParameter("jobnewsCode");
		
		JobNewsVO jv = new JobNewsVO();
		jv.setJobNewsCode(jobnewsCode);
		
		JobNewsService jobnewsSerive = 
				JobNewsServiceImpl.getInstance();
		
		List<JobNewsVO> jobnewsList = 
				jobnewsSerive.getSearchJobnews(jv);	
		
		
		
		
		
		
		return VIEW_PAGE;
	}
}
