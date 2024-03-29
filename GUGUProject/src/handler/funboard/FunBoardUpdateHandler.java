package handler.funboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.CommonHandler;
import service.FunBoardService;
import serviceImpl.FunBoardServiceImpl;
import vo.FunBoardVO;
import java.util.List;

/**
 * 자유게시판 수정 핸들러
 * @author ksy
 */
public class FunBoardUpdateHandler implements CommonHandler{
	//이동할 페이지
	private static final String VIEW_PAGE_GO = "/WEB-INF/view/funboard/funboardUpdate.jsp";
	//객체 생성
	FunBoardService funBoardService = FunBoardServiceImpl.getInstance();
	
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
			String funBoardCode = req.getParameter("funBoardCode");
			
			FunBoardVO fbv = new FunBoardVO();
			fbv.setCode(funBoardCode);
			
			List<FunBoardVO> funBoardList = funBoardService.FunBoardSelect(fbv);
			
			req.setAttribute("funBoardVO", funBoardList.get(0));
			return VIEW_PAGE_GO;
		}else if(req.getMethod().equals("POST")) {
			String funBoardCode = req.getParameter("funBoardCode");
			String funBoardTitle = req.getParameter("funBoardTitle");
			String funBoardContent = req.getParameter("funBoardContent");
			
			FunBoardVO fbv = new FunBoardVO();
			fbv.setCode(funBoardCode);
			fbv.setTitle(funBoardTitle);
			fbv.setContent(funBoardContent);
			
			int resCnt = funBoardService.FunBoardUpdate(fbv);
			
			String message = "";
			if(resCnt > 0) {
				message = "success";
			}else {
				message = "fail";
			}
			
			String redirectUrl = req.getContextPath() + "/funboard/list.do?message=" + message;
			return redirectUrl;
		}
		return null;
	}

}
