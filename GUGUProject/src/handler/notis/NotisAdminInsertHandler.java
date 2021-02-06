package handler.notis;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.NotisService;
import serviceImpl.NotisServiceImpl;
import vo.NotisVO;

/**
 * 공지사항 등록 페이지
 * @author 송 지은
 *
 */
public class NotisAdminInsertHandler implements CommonHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/notis/notisAdminInsert.jsp";
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equals("GET")) {
			return VIEW_PAGE;
		}else if(req.getMethod().equals("POST")) {
			NotisService ns = NotisServiceImpl.getInstance();
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String adminId = req.getParameter("adminId");
			String regDate = req.getParameter("regDate");
			
			NotisVO vo = new NotisVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setAdminId(adminId);
			vo.setRegDate(regDate);
			
			int cnt = ns.insert(vo);
			
			String msg = "";
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			String url = req.getContextPath()+"/notis/notisAdminList.do?msg="+URLEncoder.encode(msg,"UTF-8");
			return url;
		}
		return null;
	}
	
}