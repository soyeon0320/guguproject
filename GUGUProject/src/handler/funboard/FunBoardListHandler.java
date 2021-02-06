package handler.funboard;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonHandler;
import service.CommentService;
import service.FunBoardService;
import serviceImpl.CommentServiceImpl;
import serviceImpl.FunBoardServiceImpl;
import vo.CommentVO;
import vo.FunBoardVO;
import vo.MemberVO;
import vo.PagingVO;

/**
 * 자유게시판 리스트 핸들러
 * @author ksy
 */
public class FunBoardListHandler implements CommonHandler{
	//이동할 페이지
	private static final String VIEW_PAGE_GO = "/WEB-INF/view/funboard/funboardList.jsp";
	
	/**
	 * 리다이렉트 여부
	 */
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	/**
	 * 작업을 처리할 메소드
	 */
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		FunBoardService funBoardService = FunBoardServiceImpl.getInstance();
		
		//페이징
		int pageNo = req.getParameter("pageNo")==null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
		PagingVO pageVO = new PagingVO();
		
		int funBoardTotal = funBoardService.FunBoardAllSelectCount();
		pageVO.setTotalCount(funBoardTotal);
		pageVO.setCurrentPageNo(pageNo);
		pageVO.setCountPerPage(10);
		pageVO.setPageSize(10);
		
		req.setAttribute("pageVO", pageVO);
		
		List<FunBoardVO> funBoardList = funBoardService.FunBoardAllSelect(pageVO);
		req.setAttribute("funBoardList", funBoardList);
		
		return VIEW_PAGE_GO;
	}
}
