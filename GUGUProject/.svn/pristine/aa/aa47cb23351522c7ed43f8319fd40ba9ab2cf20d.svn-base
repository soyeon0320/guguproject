package handler.company;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.CompanyService;
import serviceImpl.CompanyServiceImpl;

/**
 * 기업 정보를 삭제하는 페이지
 * @author 송 지은
 *
 */
public class CompanyDeleteHandler implements CommonHandler {

	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		CompanyService cs = CompanyServiceImpl.getInstance();
		String code = req.getParameter("code");
		System.out.println(code);
		int cnt = cs.delete(code);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		String url = "/company/adminList.do?msg="+URLEncoder.encode("UTF-8");
		return url;
	}

}
