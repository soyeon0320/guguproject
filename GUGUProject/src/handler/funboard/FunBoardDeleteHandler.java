package handler.funboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.CommonHandler;
import service.FunBoardService;
import serviceImpl.FunBoardServiceImpl;

/**
 * 자유게시판 삭제 핸들러
 * @author ksy
 */
public class FunBoardDeleteHandler implements CommonHandler{

	/**
	 * 리다이렉트 여부
	 */
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return true;
	}

	/**
	 * 작업을 처리할 메소드
	 */
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String funBoardCode = req.getParameter("funBoardCode");
		
		FunBoardService funBoardService = FunBoardServiceImpl.getInstance();
		
		int resCnt = funBoardService.FunBoardDelete(funBoardCode);
		
		String message = "";
		if(resCnt > 0) {
			message = "success";
		}else {
			message = "fail";
		}
		
		String redirectUrl = req.getContextPath() + "/funboard/list.do?message=" + message;
		return redirectUrl;
	}

}
