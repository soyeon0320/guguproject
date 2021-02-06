package handler.resume;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.CommonHandler;
import service.ResumeService;
import serviceImpl.ResumeServiceImpl;
import vo.PagingVO;
import vo.ResumeVO;

/**
 * 이력서 전체 조회 핸들러
 * @author ksy
 */
public class ResumeListHandler implements CommonHandler{
	//이동할 페이지
	private static final String VIEW_PAGE_GO = "/WEB-INF/view/resume/resumeList.jsp";
	
	/**
	 * 리다이렉트 여부
	 */
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	/**
	 * 작업을 처리할 데이터
	 */
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ResumeService resumeService = ResumeServiceImpl.getInstance();
		
		int pageNo = req.getParameter("pageNo")==null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
		PagingVO pageVO = new PagingVO();
		
		int resumeTotal = resumeService.ResumeAllSelectCount();
		pageVO.setTotalCount(resumeTotal);
		pageVO.setCurrentPageNo(pageNo);
		pageVO.setCountPerPage(10);
		pageVO.setPageSize(10);
		
		req.setAttribute("pageVO", pageVO);
		
		List<ResumeVO> resumeList = resumeService.ResumeAllSelect(pageVO);
		req.setAttribute("resumeList", resumeList);
		
		return VIEW_PAGE_GO;
	}

}
