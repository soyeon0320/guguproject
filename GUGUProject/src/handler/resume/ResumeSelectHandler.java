package handler.resume;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.CareerService;
import service.LicenseService;
import service.MemberService;
import service.ResumeService;
import serviceImpl.CareerServiceImpl;
import serviceImpl.LicenseServiceImpl;
import serviceImpl.MemberServiceImpl;
import serviceImpl.ResumeServiceImpl;
import vo.CareerVO;
import vo.LicenseVO;
import vo.MemberVO;
import vo.ResumeVO;

/**
 * 이력서 상세 조회 핸들러
 * @author ksy
 */
public class ResumeSelectHandler implements CommonHandler {
	//이동할 페이지
	private static final String VIEW_PAGE_GO = "/WEB-INF/view/resume/resumeSelect.jsp";
	
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
		String code = req.getParameter("code");
		ResumeVO rv = new ResumeVO();
		rv.setCode(code);
		
		ResumeService resumeService = ResumeServiceImpl.getInstance();
		
		List<ResumeVO> resumeList = resumeService.ResumeSelect(rv);
		req.setAttribute("resumeVO", resumeList.get(0));
		
		MemberService memberService = MemberServiceImpl.getInstance();
		
		MemberVO mv = new MemberVO();
		mv.setMemberId(resumeList.get(0).getMemberId());
		
		String memberName = req.getParameter("memberName");
		String memberGender = req.getParameter("memberGender");
		String memberBirth = req.getParameter("memberBirth");
		String memberPhone = req.getParameter("memberPhone");
		String memberEmail = req.getParameter("memberEmail");
		String memberAddr1 = req.getParameter("memberAddr1");
		String memberAddr2 = req.getParameter("memberAddr2");
		mv.setMemberName(memberName);
		mv.setMemberGender(memberGender);
		mv.setMemberBirth(memberBirth);
		mv.setMemberPhone(memberPhone);
		mv.setMemberEmail(memberEmail);
		mv.setMemberAddr1(memberAddr1);
		mv.setMemberAddr2(memberAddr2);
		
		List<MemberVO> memberList = memberService.memberSelect(mv);
		req.setAttribute("memberVO", memberList.get(0));
		
		LicenseService licenseService = LicenseServiceImpl.getInstance();
		
		LicenseVO lv = new LicenseVO();
		lv.setResumeCode(resumeList.get(0).getCode());
		
		String name = req.getParameter("name");
		String getDate = req.getParameter("getDate");
		lv.setName(name);
		lv.setGetDate(getDate);
		
		List<LicenseVO> licenseList = licenseService.ResumeLicenseSelect(lv);
		req.setAttribute("licenseList", licenseList);
		
		CareerService careerService = CareerServiceImpl.getInstance();
		
		CareerVO cv = new CareerVO();
		cv.setResumeCode(resumeList.get(0).getCode());
		
		String careerCode = req.getParameter("careerCode");
		String companyName = req.getParameter("companyName");
		String departName = req.getParameter("departName");
		String positionName = req.getParameter("positionName");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		String jobName = req.getParameter("jobName");
		cv.setCareerCode(careerCode);
		cv.setCompanyName(companyName);
		cv.setDepartName(departName);
		cv.setPositionName(positionName);
		cv.setStartDate(startDate);
		cv.setEndDate(endDate);
		cv.setJobName(jobName);
		
		List<CareerVO> careerList = careerService.ResumeCareerSelect(cv);
		req.setAttribute("careerList", careerList);
		
		return VIEW_PAGE_GO;
	}

}
