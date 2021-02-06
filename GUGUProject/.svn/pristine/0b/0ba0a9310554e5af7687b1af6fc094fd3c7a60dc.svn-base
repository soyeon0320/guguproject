package controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import common.NullHandler;

public class WebController extends HttpServlet{
	
	private Map<String, CommonHandler> commonHandlerMap = new HashMap<String, CommonHandler>();
	
	
	/** 
	 * WebController 서블릿이 호출될때 commonHandlerMap에 handler.properties설정정보 저장하는 로직
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		// configFilePath = /WEB-INF/handler.properties
		String configFilePath = config.getInitParameter("handler-config"); 
		
		Properties handlerProp = new Properties();
		
		// handler.properties 파일을 읽어서 설정정보를 commonHandlerMap에 key(url), value(handlerInstance)로 등록하려고함..
		// handler.properties 파일을 읽기 위해 절대경로 추출
		String configFileRealPath = config.getServletContext().getRealPath(configFilePath);
		
		FileReader fr;
		
		try {
			// 파일리더 객체 생성하여 handler.properties 파일정보 읽기
			fr = new FileReader(configFileRealPath);
			
			handlerProp.load(fr);
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		for (Object key : handlerProp.keySet()) {
			String reqUrl = (String) key;
			
			try {
				
				// key값(reqURl : ~~.do)에 대응되는 핸들러 클래스의 인스턴스 생성하여 맵에 저장하기
				Class<?> klass = Class.forName(handlerProp.getProperty(reqUrl));
				CommonHandler handlerInstance = (CommonHandler) klass.newInstance(); // 핸들러 인스턴스 생성
				commonHandlerMap.put(reqUrl, handlerInstance);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException();
			}
			
		}
		// => commonHandlerMap 에 handler.properties 설정정보 저장 완료...
		
		
		// 콘솔창에 확인
		Set<Map.Entry<String, CommonHandler>> entrySet = commonHandlerMap.entrySet();
		for (Map.Entry<String, CommonHandler> entry : entrySet) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//	요청 URI가져오기 URI 는 파라미터를 제외한 주소를 말한다.. req자체에는 파라미터가 들어있음..
		String reqURI = req.getRequestURI(); 
		
		// ContextPath 부분을 제거한 URL 가져오기
		// ex) Project1/insert.do => /insert.do
		if(reqURI.indexOf(req.getContextPath()) == 0) {
			reqURI = reqURI.substring(req.getContextPath().length());
		}
		
		System.out.println("reqURI : " + reqURI);
//		System.out.println("commonHandlerMap : " + commonHandlerMap);
		
		
		
		// reqURI 를 키값으로 하는 밸류(해당 핸들러 객체) 꺼내기
		CommonHandler handler = commonHandlerMap.get(reqURI);
		
		if (handler == null) {
			handler = new NullHandler();
		}
		
		
		String viewPage = ""; // 뷰화면 정보
		try {
			viewPage = handler.process(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		System.out.println("viewPage : " + viewPage);
		
		// VIEW 화면 처리
		if(viewPage != null) { // 뷰페이지가 존재하면..
			if (handler.RedirectYn(req)) {
				resp.sendRedirect(viewPage); //리스폰스에 뷰페이지 주소로 리다이렉트 처리..(주소값이 바뀜)
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage); // (주소값이 그대로)
				dispatcher.forward(req, resp);
			}
		}
	}
	
}
