package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//프로세스 로직이 일관성있게 됨
public class NullHandler implements CommonHandler{

	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//에러 정보 전송
		res.sendError(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}

}
