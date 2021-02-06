package handler.resume;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.CommonHandler;
import service.CareerService;
import service.LicenseService;
import service.MemberService;
import service.ResumeService;
import serviceImpl.CareerServiceImpl;
import serviceImpl.LicenseServiceImpl;
import serviceImpl.MemberServiceImpl;
import serviceImpl.ResumeServiceImpl;
import vo.AdminVO;
import vo.CareerVO;
import vo.LicenseVO;
import vo.MemberVO;
import vo.ResumeVO;

/**
 * 이력서 등록 핸들러
 * @author ksy
 */
public class ResumeInsertHandler implements CommonHandler {
	//이동할 페이지
	private static final String VIEW_PAGE_GO = "/WEB-INF/view/resume/resumeInsert.jsp";
	
	/**
	 * 리다이렉트 여부
	 */
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			return false;
		}else {
			return true;
		}
	}

	/**
	 * 작업을 처리할 메소드
	 */
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equals("GET")) {
			memberInfo(req, res);
			return VIEW_PAGE_GO;
		}else if(req.getMethod().equals("POST")) {
			memberInfo(req, res);
			
			/**
			 * 이력서 등록
			 */
			String title = req.getParameter("title");
			String schoolSection = req.getParameter("schoolSection");
			String schoolName = req.getParameter("schoolName");
			String schoolMajor = req.getParameter("schoolMajor");
			if (schoolMajor=="" || schoolMajor.trim().equals("")) {
				schoolMajor = " ";
			}
			double schoolScore = 0;
			try {
				schoolScore = Double.parseDouble(req.getParameter("schoolScore"));
			}catch(Exception e) {
				e.printStackTrace();
			}
			String schoolStartDate = req.getParameter("schoolStartDate");
			String schoolEndDate = req.getParameter("schoolEndDate");
			String schoolEndYn = req.getParameter("schoolEndYn");
			String imgSrc = req.getParameter("imgSrc");
			String imgName = req.getParameter("imgName");
			String memberId = req.getParameter("memberId");
			
			ResumeVO rv = new ResumeVO();
			
			rv.setTitle(title);
			rv.setSchoolSection(schoolSection);
			rv.setSchoolName(schoolName);
			rv.setSchoolMajor(schoolMajor);
			rv.setSchoolScore(schoolScore);
			rv.setSchoolStartDate(schoolStartDate);
			rv.setSchoolEndDate(schoolEndDate);
			rv.setSchoolEndYn(schoolEndYn);
			rv.setImgSrc(imgSrc);
			rv.setImgName(imgName);
			rv.setMemberId(memberId);
			
			ResumeService resumeService = ResumeServiceImpl.getInstance();
			
			resumeService.ResumeInsert(rv);

			/**
			 * 자격증 등록
			 */
			LicenseService licenseService = LicenseServiceImpl.getInstance();
			
			LicenseVO lv = new LicenseVO();
			lv.setResumeCode(rv.getCode());
			
			String[] licenNmArr = req.getParameterValues("licenseName");
			String[] licenDtArr =  req.getParameterValues("licenseGetDate");
			
			if(licenNmArr != null && licenDtArr != null) {
				for(int idx=0; idx<licenNmArr.length; idx++) {
					lv.setName(licenNmArr[idx]);
					lv.setGetDate(licenDtArr[idx]);
					
					licenseService.ResumeLicenseInsert(lv);
				}
			}
			
			/**
			 * 경력 등록
			 */
			String[] comNmArr = req.getParameterValues("companyName");
			String[] deNmArr = req.getParameterValues("departName");
			String[] posNmArr = req.getParameterValues("positionName");
			String[] stDtArr = req.getParameterValues("startDate");
			String[] endDtArr = req.getParameterValues("endDate");
			String[] jobNmArr = req.getParameterValues("jobName");
			
			CareerVO cv = new CareerVO();
			cv.setResumeCode(rv.getCode());
			
			CareerService careerService = CareerServiceImpl.getInstance();
			
			if(comNmArr != null && deNmArr != null && stDtArr != null && endDtArr != null) {
				for(int idx=0; idx<comNmArr.length; idx++) {
					cv.setCompanyName(comNmArr[idx]);
					cv.setDepartName(deNmArr[idx]);
					cv.setStartDate(stDtArr[idx]);
					cv.setEndDate(endDtArr[idx]);
					if(posNmArr[idx] == null || posNmArr[idx].equals("")) {
						cv.setPositionName(" ");
					}else {
						cv.setPositionName(posNmArr[idx]);
					}
					if(jobNmArr[idx] == null || jobNmArr[idx].equals("")) {
						cv.setJobName(" ");
					}else {
						cv.setJobName(jobNmArr[idx]);
					}
					careerService.ResumeCareerInsert(cv);
				}
			}
			
			return req.getContextPath() + "/resume/list.do";
		}
		return null;
	}
	
	//접속중인 회원 정보
	public void memberInfo(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(false);			
		MemberVO mv = new MemberVO();
		mv.setMemberId((String)session.getAttribute("memberId"));
		
		MemberService memberService = MemberServiceImpl.getInstance();
		List<MemberVO> memberInfo = memberService.memberSelect(mv);
		req.setAttribute("memberInfo", memberInfo.get(0));
	}
}