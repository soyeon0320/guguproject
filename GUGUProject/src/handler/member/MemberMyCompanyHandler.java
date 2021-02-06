package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;

/**
 * 회원, 스크랩한 기업 목록 페이지 
 * @author 송 지은
 */
public class MemberMyCompanyHandler implements CommonHandler {

	private static final String VIEW_PAGE = "/WEB-INF/view/member/myCompany.jsp";
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		return VIEW_PAGE;
	}

}
