package handler.jobfair;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.JobfairService;
import serviceImpl.JobfairServiceImpl;
import vo.JobfairVO;

public class JobfairSelectHandler implements CommonHandler {

	private static final String VIEW_PAGE =
			"/WEB-INF/views/jobfair/jobfairSelect.jsp";
	private JobfairService jobfairSerive;
	
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String jobfairCode = req.getParameter("jobfairCode");
		
		JobfairVO jv = new JobfairVO();
		jv.setJobfairCode(jobfairCode);
		
		JobfairService jobfairSerive = 
				JobfairServiceImpl.getInstance();
		
		List<JobfairVO> jobfairList = 
				jobfairSerive.getSearchJobfair(jv);	
		
		
		
		
		
		
		return VIEW_PAGE;
	}
}
