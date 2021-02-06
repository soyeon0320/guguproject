package handler.login;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonHandler;
import service.LoginService;
import serviceImpl.LoginServiceImpl;
import vo.AdminVO;

public class AdminLoginHandler implements CommonHandler {
	private static final String VIEW_PAGE = "/WEB-INF/view/login/adminlogin.jsp";
	private LoginService loginService = LoginServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String adminId = req.getParameter("adminId");
		String adminPw = req.getParameter("adminPw");
		String rememberId = req.getParameter("rememberId");

		System.out.println(adminId);
		System.out.println(adminPw);
		System.out.println(rememberId);
		
		if(rememberId != null){
             // null값이 아니라면 id값을 쿠키로 저장
             Cookie cookie = new Cookie("adminId", adminId);
             cookie.setMaxAge(60*60*240); // 10일동안 쿠키 저장
             cookie.setPath("/");
             res.addCookie(cookie);
        }else{ // 그 외의 경우 쿠키 삭제
       	 Cookie cookie = new Cookie("adminId", null);
       	 cookie.setMaxAge(0);
            cookie.setPath("/");
            res.addCookie(cookie);
        }
		
		AdminVO adminVO = new AdminVO();
		adminVO.setAdminId(adminId);
		adminVO.setAdminPw(adminPw);
		
		AdminVO result = loginService.adminLogin(adminVO);
		
		HttpSession session = null;
		
		
		if(result != null) {
			
			adminId = result.getAdminId();
			adminPw = result.getAdminPw();
			String adminName = result.getAdminName();
			
			session = req.getSession(true);
			session.setAttribute("adminVO", result);
			session.setAttribute("adminId", adminId);
			session.setAttribute("adminPw", adminPw);
			session.setAttribute("adminName", adminName);
			
		}
		
		
		// msg파라미터 값 설정
		String msg = "";
		if(result == null) {
			msg = "fail";
		}else {
			msg = "success";
		}
		// view 페이지 넘기는건 forward방식, 로그인시 주소값이 바뀌니까 redirect방식으로 쏴줘야 한다.
		return req.getContextPath() + "/adminLogin.do?msg=" + URLEncoder.encode(msg, "UTF-8");
	}

}
