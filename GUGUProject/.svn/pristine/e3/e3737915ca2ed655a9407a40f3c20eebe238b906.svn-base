package handler.jobfair;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.JobfairService;
import serviceImpl.JobfairServiceImpl;

public class JobfairDeleteHandler implements CommonHandler{

	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		  //1. 요청파라미터 정보가져오기
		  String jobfairCode = req.getParameter("jobfairCode");
	      
		  //2. 서비스 객체 생성하기
	      JobfairService jobfairService = JobfairServiceImpl.getInstance();
	      
	      //3. 정보 삭제
	      int cnt = jobfairService.jobfairDelete(jobfairCode);
	      String msg = "";
	      if (cnt > 0) {
	         msg = "성공";
	      }else {
	         msg = "실패";
	      }
	      
	      // 목록조회화면으로 이동
	      String redirectUrl = "/GUGUProject/jobfair/managerlist.do?msg=" + URLEncoder.encode(msg,"UTF-8");
		
	      return redirectUrl;
	}

}
