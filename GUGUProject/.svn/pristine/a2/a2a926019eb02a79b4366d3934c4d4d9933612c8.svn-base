package handler.faq;

import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.CommonHandler;
import service.FaqService;
import serviceImpl.FaqServiceImpl;
import vo.FaqVO;

/**
 * FAQ 정보를 등록하는 페이지
 * @author 송 지은
 */
public class FaqInsertHandler implements CommonHandler{
	
	private static final String VIEW_PAGE = "/WEB-INF/view/faq/faqInsert.jsp";
	
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
			String question = req.getParameter("question");
			String answer = req.getParameter("answer");
			String adminId = req.getParameter("adminId");

			FaqService fs = FaqServiceImpl.getInstance();
			FaqVO vo = new FaqVO();
			vo.setQuestion(question);
			vo.setAnswer(answer);
			vo.setAdminId(adminId);
			
			int cnt = fs.InsertFaq(vo);
			
			String msg = "";
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			String readUrl = req.getContextPath()+"/faq/faqList.do?msg="+URLEncoder.encode(msg,"UTF-8");
			return readUrl;
		}
		return null;
	}

}