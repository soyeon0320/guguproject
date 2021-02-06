package handler.login;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonHandler;
import service.LoginService;
import serviceImpl.LoginServiceImpl;
import vo.MemberVO;

public class LoginHandler implements CommonHandler  {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/login/login.jsp";
	private LoginService loginService = LoginServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		
			return true;
		
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// 1. 사용자 입력 값 받아오기
		String memberId = req.getParameter("memId");
		String memberPw = req.getParameter("password");
		
		String rememberId = req.getParameter("rememberId");
		System.out.println(rememberId);
		
		
		 if(rememberId != null){
             // null값이 아니라면 id값을 쿠키로 저장
             Cookie cookie = new Cookie("memberId", memberId);
             cookie.setMaxAge(60*60*240); // 10일동안 쿠키 저장
             cookie.setPath("/");
             res.addCookie(cookie);
         }else{ // 그 외의 경우 쿠키 삭제
        	 Cookie cookie = new Cookie("memberId", null);
        	 cookie.setMaxAge(0);
             cookie.setPath("/");
             res.addCookie(cookie);
         }
		
				
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMemberId(memberId);
		memberVO.setMemberPw(memberPw);
		
		// 2. 서비스 객체 생성
		
		MemberVO result = loginService.Login(memberVO);
		if(result != null && result.getMemberQuit().equals("Y")) {
			return req.getContextPath() + "/login.do?msg=quit";
		}
		
		
		HttpSession session = null;
		
		// 회원이름 req 변수 설정
		String memberName = null;
		if(result != null) {
			
			memberId = result.getMemberId();
			memberPw = result.getMemberPw();
			memberName = result.getMemberName();

			
			session = req.getSession(true);
			session.setAttribute("memberVO", result);
			session.setAttribute("memberId", memberId);
			session.setAttribute("memberPw", memberPw);
			session.setAttribute("memberName", memberName);
			
		}
		
//		System.out.println(memberName);
		
		// msg파라미터 값 설정
		String msg = "";
		if(result == null) {
			msg = "fail";
		}else {
			msg = "success";
		}
		// view 페이지 넘기는건 forward방식, 로그인시 주소값이 바뀌니까 redirect방식으로 쏴줘야 한다.
		return req.getContextPath() + "/login.do?msg=" + URLEncoder.encode(msg, "UTF-8");
	}
	
}
