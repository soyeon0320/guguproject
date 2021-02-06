package handler.faq;

import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.CommonHandler;
import service.FaqService;
import serviceImpl.FaqServiceImpl;
import vo.FaqVO;

/**
 * FAQ 정보를 수정하는 페이지
 * @author 송 지은
 */
public class FaqUpdateHandler implements CommonHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/faq/faqUpdate.jsp";
	
	FaqService fs = FaqServiceImpl.getInstance();
	
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
		
		int cnt = 0;
		
		if(req.getMethod().equals("GET")) {
			String code = req.getParameter("code");
			
			FaqVO vo = new FaqVO();
			vo.setCode(code);
			
			List<FaqVO> list = fs.searchCode(vo);
			req.setAttribute("list", list);
			return VIEW_PAGE;
			
		}else if(req.getMethod().equals("POST")) {
			
			// 수정 시작
			String question = req.getParameter("question");
			String answer = req.getParameter("answer");
			String adminId = req.getParameter("adminId");
			String code =req.getParameter("code");
			
			FaqVO vo = new FaqVO();
			vo.setCode(code);
			vo.setQuestion(question);
			vo.setAnswer(answer);
			vo.setAdminId(adminId);
			
			cnt = fs.update(vo);
			
			String msg = "";
			
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			
			String url = req.getContextPath()+"/faq/faqList.do?msg="+URLEncoder.encode("UTF-8");
			return url;
		}
		return null;
	}
}
