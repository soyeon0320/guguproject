package util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonResolver {
	
	public static void view(HttpServletResponse response, Object target) throws Exception {
		
		// 출력
		ObjectMapper mapper = new ObjectMapper();
		
		// content-Type 결정
		// (※주의 get.Writer 꺼내기 전에 content-Type을 설정해줘야 먹힌다)
		// 항상 content-Type 먼저 세팅
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 내보내기
		out.print(mapper.writeValueAsString(target));
		
		// out객체를 종료하고 환원
		out.close();
	}
	
}
