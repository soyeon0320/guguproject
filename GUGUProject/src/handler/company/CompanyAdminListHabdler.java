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
 * 관리자 기업 목록 페이지(관리자용)
 * @author 송 지은
 *
 */
public class CompanyAdminListHabdler implements CommonHandler{
	private static final String VIEW_PAGE ="/WEB-INF/view/company/companyAdminList.jsp";

	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		CompanyService cs = CompanyServiceImpl.getInstance();
		List<CompanyVO> list = cs.companyList();
		req.setAttribute("list", list);
		return VIEW_PAGE;
	}
	
	
}
