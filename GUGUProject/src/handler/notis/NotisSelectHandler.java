package handler.notis;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.NotisService;
import serviceImpl.NotisServiceImpl;
import vo.NotisVO;
/**
 * 공지사항 정보 상세 보기 페이지(검색)
 * @author 송 지은
 */
public class NotisSelectHandler implements CommonHandler{

	private static final String VIEW_PAGE ="/WEB-INF/view/notis/notisSelect.jsp";
	NotisService ns = NotisServiceImpl.getInstance();
	
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
			String code = req.getParameter("code");
			
			NotisVO vo = new NotisVO();
			vo.setCode(code);
			List<NotisVO> list = ns.searchCode(code);
			req.setAttribute("list", list);
			return VIEW_PAGE;
		
		}else if(req.getMethod().equals("POST")) {
			String code = req.getParameter("code");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String adminId = req.getParameter("adminId");
			String regDate = req.getParameter("regDate");
			
			System.out.println(title);
			System.out.println(content);
			System.out.println(adminId);
			System.out.println(regDate);
			
			NotisVO vo = new NotisVO();
			vo.setCode(code);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setAdminId(adminId);
			vo.setRegDate(regDate);
			
			int cnt = ns.update(vo);
			
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
