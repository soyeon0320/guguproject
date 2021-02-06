package handler.jobfair;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.JobfairService;
import serviceImpl.JobfairServiceImpl;
import vo.JobfairVO;

public class JobfairUpdateHandler implements CommonHandler{
	
	private static final String VIEW_PAGE = "/WEB-INF/view/jobfair/jobfairUpdate.jsp";

	JobfairService jobfairService = JobfairServiceImpl.getInstance();
	
	
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
		String redirectUrl="";
		if(req.getMethod().equals("GET")) {
			String jobfairCode = req.getParameter("jobfairCode");
			
			//1.채용설명회 정보 조회
			JobfairVO jv = new JobfairVO();
			jv.setJobfairCode(jobfairCode);
			
			List<JobfairVO> jobfList = jobfairService.getSearchJobfair(jv);
			
			//2. request객체에 정보 저장
			req.setAttribute("jobfairVo", (JobfairVO)jobfList.get(0));
			
			return VIEW_PAGE;
			
			//1. 요청 파라미터 정보 가져오기
		}else if(req.getMethod().equals("POST")) {
			
			//1. 요청 파라미터 정보 가져오기
			String jobfairCode = req.getParameter("jobfairCode");//코드
			String jobfairGroup = req.getParameter("jobfairGroup");//분류
			String jobfairTitle = req.getParameter("jobfairTitle"); //제목
			String jobfairStartdate = req.getParameter("jobfairStartdate");//일시(시작일)
			String jobfairEnddate = req.getParameter("jobfairEnddate");//일시(종료일)
			String jobfairPlace = req.getParameter("jobfairPlace"); //장소
			String companyName = req.getParameter("companyName"); //기업명
			
			//2. 서비스 객체 생성하기
			JobfairService jobfairService = JobfairServiceImpl.getInstance();
		
			//3. 정보 등록
			JobfairVO jv = new JobfairVO();

			jv.setJobfairCode(jobfairCode);
			jv.setJobfairGroup(jobfairGroup);
			jv.setJobfairTitle(jobfairTitle);
			jv.setJobfairStartdate(jobfairStartdate);
			jv.setJobfairPlace(jobfairPlace);
		    jv.setJobfairEnddate(jobfairEnddate);
		    jv.setCompanyName(companyName);
		    jv.setCompanyCode("J0001");
			
		
			int cnt =jobfairService.jobfairUpdate(jv);
		
			String msg = "";
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}

			//4. 목록조회 화면으로 이동
			redirectUrl = "/GUGUProject/jobfair/managerlist.do?msg =" + URLEncoder.encode(msg,"UTF-8");
		}	
		return redirectUrl;
	
	}
}