package handler.resume;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.LicenseService;
import serviceImpl.LicenseServiceImpl;

/**
 * 자격증 삭제 핸들러
 * @author ksy
 */
public class LicenseDeleteHandler implements CommonHandler {

	/**
	 * 리다이렉트 여부
	 */
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	/**
	 * 작업을 처리할 메소드
	 */
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String licenseCode = req.getParameter("licenseCode");
		
		LicenseService licenseService = LicenseServiceImpl.getInstance();
		
		licenseService.ResumeLicenseDelete(licenseCode);
		
		return null;
	}

}
