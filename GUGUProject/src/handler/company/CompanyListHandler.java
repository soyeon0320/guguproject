package handler.company;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.CompanyService;
import service.FaqService;
import serviceImpl.CompanyServiceImpl;
import serviceImpl.FaqServiceImpl;
import vo.CompanyVO;
import vo.FaqVO;

/**
 * 기업 목록을 보여주는 페이지 (회원&비회원 용)
 * @author 송 지은
 *
 */
public class CompanyListHandler implements CommonHandler{
	private static final String VIER_PAGE ="/WEB-INF/view/company/companyList.jsp";

	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		CompanyService cs = CompanyServiceImpl.getInstance();
		List<CompanyVO> list = cs.companyList();
		req.setAttribute("list", list);
		
		return VIER_PAGE;
	}
	
	
}
