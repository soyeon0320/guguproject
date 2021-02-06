package handler.notis;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.NotisService;
import serviceImpl.NotisServiceImpl;
import vo.NotisVO;
/**
 * 공지사항 목록 페이지(회원&비회원용)
 * @author 송 지은
 */
public class NotisListHandler implements CommonHandler {

	private static final String VIEW_PAGE ="/WEB-INF/view/notis/notisList.jsp";
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		NotisService ns = NotisServiceImpl.getInstance();
		List<NotisVO> list = ns.notisList();
		
		req.setAttribute("list", list);
		return VIEW_PAGE;
	}

}
