package handler.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.MemberService;
import serviceImpl.MemberServiceImpl;
import vo.MemberVO;

/**
 * 회원 가입 페이지
 * @author 송 지은
 *
 */
public class MemberHandler implements CommonHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/member/member.jsp";
	MemberService memberSerive = MemberServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			return false;
		}else{ 
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equals("GET")) {
			List<MemberVO> list = memberSerive.getMember();
			req.setAttribute("list", list);
			
			return VIEW_PAGE;
		}else if(req.getMethod().equals("POST")) {
			
			String id = req.getParameter("memberId");
			String name = req.getParameter("name");
			String yy = req.getParameter("yy");
			String mm = req.getParameter("mm");
			String dd = req.getParameter("dd");
			String birth = yy + mm + dd;

			String pswd1 = req.getParameter("pswd1");
			String gender = req.getParameter("gender");
			String mobile = req.getParameter("mobile");
			String email = req.getParameter("email");
			String memberAddr1 = req.getParameter("address");
			String memberAddr2 = req.getParameter("detailAddress");

			
			MemberVO vo = new MemberVO();
			vo.setMemberId(id);
			vo.setMemberName(name);
			vo.setMemberBirth(birth);
			vo.setMemberPw(pswd1);
			vo.setMemberGender(gender);
			vo.setMemberPhone(mobile);
			vo.setMemberEmail(email);
			vo.setMemberAddr1(memberAddr1);
			vo.setMemberAddr2(memberAddr2);
			
			int cnt = memberSerive.insertMember(vo);
			
			String msg = "";

			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			String redirectUrl = req.getContextPath()+ "/login.do";
			return redirectUrl;
		}
		return null;
	}
}