package handler.findaccount;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import common.CommonHandler;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import service.FindAccountService;
import serviceImpl.FindAccountServiceImpl;
import vo.MemberVO;


public class GetAuthenticationkeyHandler implements CommonHandler {
	
	private FindAccountService findAccountService = FindAccountServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String memberName = req.getParameter("memberName");
		String memberPhone = req.getParameter("phoneNum");
		memberPhone = memberPhone.replace("-", ""); // 사용자 입력번호
		String memberId = "";
		
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberName(memberName);
		memberVO.setMemberPhone(memberPhone);
		
		MemberVO result = findAccountService.findId(memberVO);
		
		String msg = "";
		if(result != null) {
			
			String api_key = "NCSTF0JR7M0UPSJP";
			String api_secret = "LEFLHTTOTRMA1HL4UDGTX5X5SNWMT3OH";
			
			Message coolsms = new Message(api_key, api_secret);
			
			String Authenticationkey = makeKey(); // 인증번호
			
			HashMap<String, String> set = new HashMap<String, String>();
			
			set.put("to", memberPhone);
			set.put("from", "01065683890");
			set.put("text", "안녕하세요 GuGuSystem입니다. 인증번호는 ["+ Authenticationkey +"]입니다.");
			set.put("type", "sms");
			
			try {
				JSONObject obj = (JSONObject) coolsms.send(set);
				System.out.println(obj.toString()); // 전송결과 확인
			} catch (CoolsmsException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getCode());
		    }
			
			memberId = result.getMemberId();

			JSONObject JSONobj = new JSONObject();
			JSONobj.put("msg", "success");
			JSONobj.put("key", Authenticationkey);
			JSONobj.put("memberId", memberId);
			
			PrintWriter out = res.getWriter();
			out.println(JSONobj);
			
			System.out.println(Authenticationkey);
			
		}else {
			JSONObject JSONobj = new JSONObject();
			JSONobj.put("msg", "fail");
			
			PrintWriter out = res.getWriter();
			out.println(JSONobj);
		}
		
		return null;
	}

	
	private String makeKey() {
		
		String key = "";
		for (int i = 0; i < 6; i++) {
			int ran = (int)(Math.random()*10);
			key += ran;
		}
		return key;
	}
}
