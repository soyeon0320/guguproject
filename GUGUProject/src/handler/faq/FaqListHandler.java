package handler.faq;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.CommonHandler;
import service.FaqService;
import serviceImpl.FaqServiceImpl;
import vo.AdminVO;
import vo.FaqVO;

/**
 *FAQ 목록을 보여주는 페이지(회원용) 
 * @author 송 지은
 */
public class FaqListHandler implements CommonHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/faq/faq.jsp";
	
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
