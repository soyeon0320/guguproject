package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommonHandler {
	/**
	 * 해당 화면에 대해 forward 및 redirect 여부를 결정하기 위한 메소드
	 * Y : redirect
	 * N : forward
	 * @param req
	 * @return
	 */
	public boolean RedirectYn(HttpServletRequest req);
	
	/**
	 * 요청한 내용을 실제 처리하는 메소드
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
