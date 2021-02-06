package handler.company;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.CompanyService;
import serviceImpl.CompanyServiceImpl;
import vo.CompanyVO;

/**
 * 기업 정보를 등록하는 페이지
 * @author 송 지은
 *
 */
public class CompanyInsertHandler implements CommonHandler{

	private static final String VIEW_PAGE ="/WEB-INF/view/company/companyInsert.jsp";
	
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
			
			String title= req.getParameter("title");
			String name= req.getParameter("name");
			String career= req.getParameter("career");
			String educstion= req.getParameter("educstion");
			String employment= req.getParameter("employment");
			String salary= req.getParameter("salary");
			String area= req.getParameter("area");
			String business= req.getParameter("business");
			String employees= req.getParameter("employees");
			String estab= req.getParameter("estab");
			String homepage= req.getParameter("homepage");
			String regdate= req.getParameter("regdate");
			String lastdate= req.getParameter("lastdate");
			
			CompanyService cs = CompanyServiceImpl.getInstance();
			CompanyVO vo = new CompanyVO();
			vo.setTitle(title);
			vo.setName(name);
			vo.setCareer(career);
			vo.setEducstion(educstion);
			vo.setEmployment(employment);
			vo.setSalary(salary);
			vo.setArea(area);
			vo.setBusiness(business);
			vo.setEmployees(employees);
			vo.setEstab(estab);
			vo.setHomepage(homepage);
			vo.setRegdate(regdate);
			vo.setLastdate(lastdate);
			
			System.out.println(lastdate);
			
			int cnt = cs.insert(vo);
			
			String msg = "";
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			String readUrl = req.getContextPath()+"/company/adminList.do?msg="+URLEncoder.encode(msg,"UTF-8");
			return readUrl;
			
		}
		return null;
	}

}