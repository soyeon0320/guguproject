package handler.inquery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocket {
	
	private static List<Session> sessionUsers = Collections.synchronizedList(new ArrayList<>()); 
	
	@OnOpen
	public void handleOpen(Session userSession) throws IOException {
		if(sessionUsers.size() >= 2) {
			userSession.getBasicRemote().sendText("overConnect");
			handleClose(userSession);
		}
		
		System.out.println(userSession);
		sessionUsers.add(userSession);
		System.out.println("클라이언트 접속");
		
		
	}
	
	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException {
		System.out.println("receive msg : " + message);
		
		for (Session session : sessionUsers) {
			if (session == userSession) {
				continue; // 메시지를 보내온 곳으로는 메시지를 보내지 않음
			}else {
				try {
					session.getBasicRemote().sendText(message);
				} catch (IOException e) {
					System.out.println("메시지 전송중 에러 발생!");
					e.printStackTrace();
				}
			}
		}
		
	}
	
	@OnClose
	public void handleClose(Session userSession) {
		sessionUsers.remove(userSession);
		System.out.println("클라이언트 접속해제");
	}
	
	@OnError
	public void handleError(Throwable e) {
		System.out.println("소켓 핸들링 중 에러 발생");
		e.printStackTrace();
	}
}
