package handler.index;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.FaqService;
import serviceImpl.FaqServiceImpl;
import vo.FaqVO;

/**
 * 메인 페이지에서 FAQ 목록을 보여주는 페이지
 * - 메인 페이지 연결 되는 페이지 (index.jsp)
 * @author 송 지은
 *
 */
public class FaqHandler implements CommonHandler{
	
	private static final String VIEW_PAGE = "/WEB-INF/index.jsp";
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		FaqService fs = FaqServiceImpl.getInstance();
		List<FaqVO> list = fs.faqList();
	
		req.setAttribute("list", list);
		return VIEW_PAGE;
	}

}
