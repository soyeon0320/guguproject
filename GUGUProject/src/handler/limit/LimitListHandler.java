package handler.limit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.CommonHandler;

/**
 * 글자 수 체크 페이지
 * @author 송 지은
 *
 */
public class LimitListHandler implements CommonHandler{
	private static final String VIEW_PAGE_GO = "/WEB-INF/view/limit/limitList.jsp";
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return VIEW_PAGE_GO;
	}
	
}
