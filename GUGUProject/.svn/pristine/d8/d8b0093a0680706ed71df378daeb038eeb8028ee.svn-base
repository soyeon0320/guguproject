package handler.faq;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.FaqService;
import serviceImpl.FaqServiceImpl;

/**
 * FAQ 정보를 삭제하는 페이지
 * @author 송 지은
 */
public class FaqDeleteHandler implements CommonHandler {


	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
//		String[] dateBox = req.getParameterValues("dateBox");
//		String checkBox = "";
		
//		if(dateBox == null) {
//			System.out.println("값없음");
//			System.out.println("진짜 아무것도 없냐?"+dateBox);
//		}else if(dateBox.length == 1){
//			checkBox = req.getParameterValues("dateBox")[0];
//			System.out.println("한 개일 경우"+ dateBox);
//		}else{
//			for(int i =0; i < dateBox.length; i++) {
//				System.out.println(dateBox[i]);
//			}
//		}
		
		FaqService fs = FaqServiceImpl.getInstance();
		String code = req.getParameter("code");
		int cnt = fs.delete(code);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		String url = "/faq/faqList.do?msg="+URLEncoder.encode("UTF-8");
		return url;
	}

}
