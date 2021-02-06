package handler.member;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.sun.mail.iap.Response;

import common.CommonHandler;
import service.MemberService;
import serviceImpl.MemberServiceImpl;
import vo.MemberVO;

public class GetMemberInfoHandler implements CommonHandler{
	MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String memberId = req.getParameter("memberId");
		System.out.println(memberId);
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId(memberId);
		List<MemberVO> memberList = memberService.memberSelect(memberVO);
		memberVO = memberList.get(0);
		
		JSONObject JSONObject = new JSONObject();
		
		JSONObject.put("memberId", memberVO.getMemberId());
		JSONObject.put("memberName", memberVO.getMemberName());
		JSONObject.put("memberGender", memberVO.getMemberGender());
		JSONObject.put("memberBirth", memberVO.getMemberBirth());
		JSONObject.put("memberEmail", memberVO.getMemberEmail());
		JSONObject.put("memberPhone", memberVO.getMemberPhone());
		JSONObject.put("memberAddr1", memberVO.getMemberAddr1());
		JSONObject.put("memberAddr2", memberVO.getMemberAddr2());
		JSONObject.put("memberPw", memberVO.getMemberPw());
		
		PrintWriter out = res.getWriter();
		out.println(JSONObject);
		out.close();
		
		
		// 회원 아이디정보 받아와서 회원정보 json으로 내보내기
		
		
		return null;
	}

}
