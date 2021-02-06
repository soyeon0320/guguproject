package handler.jobnews;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.JobNewsService;
import serviceImpl.JobNewsServiceImpl;
import vo.JobNewsVO;

public class JobnewsInsertHandler implements CommonHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/jobnews/jobnewsInsert.jsp";
	
	private JobNewsService jobnewsService = new JobNewsServiceImpl();
	
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
		
		if(req.getMethod().equals("GET")) {	//GET방식인 경우..
			return VIEW_PAGE;
		}else if(req.getMethod().equals("POST")) {
		
			System.out.println("--------------parameterName:"+req.getParameterMap().get(0));
			
			//1. 요청 파라미터 정보 가져오기
			String jobnewsCode = req.getParameter("jobnewsCode");//코드 
			String jobnewsTitle = req.getParameter("jobnewsTitle");//제목
			String jobnewsContent = req.getParameter("jobnewsContent"); //내용
			String jobnewsUrl = req.getParameter("jobnewsUrl"); //이미지URL
			String jobnewsRegname = req.getParameter("jobnewsRegName"); //작성자
			String jobnewsEditor = req.getParameter("jobnewsEditor"); //기자명
			String jobnewsCopyright = req.getParameter("jobnewsCopyright"); //출처
			String jobnewsRegdate  = req.getParameter("jobnewsRegDate"); //작성일
			String jobnewsGubun  = req.getParameter("jobnewsGubun"); //구분
			String adminId = req.getParameter("adminId"); //관리자아이디
			
			System.out.println("--------------jobnewsTitle:"+jobnewsTitle);
			
			//2. 서비스 객체 생성하기
			JobNewsService jobnewsService = JobNewsServiceImpl.getInstance();
		
			//3. 정보 등록
			JobNewsVO jv = new JobNewsVO();

			jv.setJobNewsCode(jobnewsCode);
			jv.setJobNewsTitle(jobnewsTitle);
			jv.setJobNewsContent(jobnewsContent);
			jv.setJobNewsUrl(jobnewsUrl);
		    jv.setJobNewsRegName(jobnewsRegname);
		    jv.setJobNewsEditor(jobnewsEditor);
		    jv.setJobNewsCopyright(jobnewsCopyright);
		    jv.setJobNewsRegDate(jobnewsRegdate);
		    jv.setJobNewsGubun(jobnewsGubun);
		    jv.setAdminId(adminId);
			
			
			int cnt =jobnewsService.jobnewsInsert(jv);
		
			String msg = "";
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			//4. 목록조회 화면으로 이동
			redirectUrl = "/GUGUProject/jobnews/managerlist.do?msg =" + URLEncoder.encode(msg,"UTF-8");

		}	
		return redirectUrl;
	}
}