package handler.index;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.CommonHandler;
import service.BoardManagerService;
import serviceImpl.BoardManagerServiceImpl;
import vo.BoardManagerVO;

/**
 * 통합 검색 페이지
 * @author 송 지은
 *
 */
public class AllsearchHandler implements CommonHandler{

	private static final String VIEW_PAGE="/WEB-INF/view/search/serchView.jsp";
	BoardManagerService bms = BoardManagerServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String searchName = req.getParameter("All");
		BoardManagerVO vo = new BoardManagerVO();
		vo.setSearchName(searchName);
		System.out.println("검색어"+searchName);
		
		List<BoardManagerVO> list = bms.searchList(searchName);
		
		req.setAttribute("list",list);
		
		return VIEW_PAGE;
	}

}
