package handler.company;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.CompanyService;
import serviceImpl.CompanyServiceImpl;
import vo.CompanyVO;

/**
 * 기업 정보 상세 보는 페이지(회원&비회원용)
 * @author 송 지은
 *
 */
public class CompanyMemberSelectHandler implements CommonHandler{

	private static final String VIEW_PAGE="/WEB-INF/view/company/companyMemberSelect.jsp";
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String code = req.getParameter("code");

		CompanyVO vo = new CompanyVO();
		vo.setCode(code);
		
		CompanyService sc = CompanyServiceImpl.getInstance();
		List<CompanyVO> list = sc.select(vo);
		
		req.setAttribute("CompanyVO", list.get(0));
		return VIEW_PAGE;
	}

}
