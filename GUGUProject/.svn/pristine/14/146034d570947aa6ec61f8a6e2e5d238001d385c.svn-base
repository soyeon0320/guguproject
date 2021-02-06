package handler.jobfair;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.JobfairService;
import serviceImpl.JobfairServiceImpl;
import vo.JobfairVO;
import vo.PagingVO;
import vo.SuccessReviewVO;

public class JobfairManagerListHandler implements CommonHandler{
	private static final String VIEW_PAGE = "/WEB-INF/view/jobfair/jobfairManagerList.jsp";
	
	
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		JobfairService jobfairService = new JobfairServiceImpl();
		
		
		int pageNo = req.getParameter("pageNo")==null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
		PagingVO pageVO = new PagingVO();
		
		int JobfairListTotal = jobfairService.JobfairAllSelectCount();
		pageVO.setTotalCount(JobfairListTotal);
		pageVO.setCurrentPageNo(pageNo);
		pageVO.setCountPerPage(10);
		pageVO.setPageSize(10);
		
		req.setAttribute("pageVO", pageVO);
		
		List<JobfairVO> jobfairList = jobfairService.jobfairAllSelect(pageVO);
		req.setAttribute("jobfairList", jobfairList);
		
		
		return VIEW_PAGE;
	}

	
}