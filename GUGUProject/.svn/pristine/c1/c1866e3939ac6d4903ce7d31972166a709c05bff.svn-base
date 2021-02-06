package handler.jobnews;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.JobNewsService;
import serviceImpl.JobNewsServiceImpl;

public class JobnewsDeleteHandler implements CommonHandler{

	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		  //1. 요청파라미터 정보가져오기
		  String jobnewsCode = req.getParameter("jobNewsCode");
	      
		  //2. 서비스 객체 생성하기
	      JobNewsService jobnewsService = JobNewsServiceImpl.getInstance();
	      
	      //3. 정보 삭제
	      int cnt = jobnewsService.jobnewsDelete(jobnewsCode);
	      String msg = "";
	      if (cnt > 0) {
	         msg = "성공";
	      }else {
	         msg = "실패";
	      }
	      
	      // 목록조회화면으로 이동
	      String redirectUrl = "/GUGUProject/jobnews/managerlist.do?msg=" + URLEncoder.encode(msg,"UTF-8");
		
	      return redirectUrl;
	}

}
