package handler.funboard;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.CommonHandler;
import service.CommentService;
import service.FunBoardService;
import serviceImpl.CommentServiceImpl;
import serviceImpl.FunBoardServiceImpl;
import vo.CommentVO;
import vo.FunBoardVO;

/**
 * 댓글 상세보기 핸들러
 * @author ksy
 */
public class FunBoardSelectHandler implements CommonHandler{
	//이동할 페이지
	private static final String VIEW_PAGE_GO = "/WEB-INF/view/funboard/funboardSelect.jsp";

	//리다이렉트 여부
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	//처리할 메소드
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String funBoardCode = req.getParameter("funBoardCode");
		
		FunBoardVO fbv = new FunBoardVO();
		fbv.setCode(funBoardCode);
		
		FunBoardService funBoardService = FunBoardServiceImpl.getInstance();
		List<FunBoardVO> funBoardList = funBoardService.FunBoardSelect(fbv);
		
		req.setAttribute("funBoardVO", funBoardList.get(0));
		
		CommentService commentService = CommentServiceImpl.getInstance();
		
		//자유게시판 데이터가 존재할 때
		if(funBoardList.get(0).getCode() != null || funBoardList.get(0).getCode() != "") {
			CommentVO cv = new CommentVO();
			//현재 필요한 자유게시판 데이터 중에서 pk를 댓글 fk에 추가
			cv.setFunBoardCode(funBoardList.get(0).getCode());
			
			List<CommentVO> commentList = commentService.CommentAllSelect(cv);
			req.setAttribute("commentList", commentList);
		}
		return VIEW_PAGE_GO;
	}

}
