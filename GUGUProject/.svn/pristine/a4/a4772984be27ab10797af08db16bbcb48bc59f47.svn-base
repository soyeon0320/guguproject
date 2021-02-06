package handler.successReview;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.SuccessReviewService;
import serviceImpl.SuccessReviewServiceImpl;
import vo.JobNewsVO;
import vo.PagingVO;
import vo.SuccessReviewVO;

public class SuccessReviewListHandler implements CommonHandler{
	private static final String VIEW_PAGE = "/WEB-INF/view/successreview/successreviewList.jsp";
	private SuccessReviewService successReviewService = SuccessReviewServiceImpl.getInstance();
	
		
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		int pageNo = req.getParameter("pageNo")==null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
		PagingVO pageVO = new PagingVO();
		
		int successReviewTotal = successReviewService.SuccessReviewAllSelectCount();
		pageVO.setTotalCount(successReviewTotal);
		pageVO.setCurrentPageNo(pageNo);
		pageVO.setCountPerPage(10);
		pageVO.setPageSize(10);
		req.setAttribute("pageVO", pageVO);
		
		
		List<SuccessReviewVO> successReviewList = successReviewService.SuccessReviewAllSelect(pageVO);
		
		
		req.setAttribute("successReviewList", successReviewList);
		
		
		return VIEW_PAGE;
	}

}
