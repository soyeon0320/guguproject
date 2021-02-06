package handler.findaccount;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import com.sun.xml.internal.ws.message.EmptyMessageImpl;

import vo.MemberVO;

public class SendPwToEmail {
	
	public static void sendPwToEmail(MemberVO result) {
		
		String memberId = result.getMemberId();
		String memberPw = result.getMemberPw();
		String memberEmail = result.getMemberEmail();
		
		try {

		Properties props = System.getProperties();
		
		String host = "smtp.naver.com";
		int port = 465;
		String recipient = memberEmail;
		String subject = "GuGuSystem에서 보낸 회원 비밀번호 찾기 메일입니다.";
		String body = memberId + "회원 님의 비밀번호는 [	" + memberPw + "	] 입니다.";
		
		props.setProperty("mail.transport.protocol", "smtp");
		
		props.put("mail.smtp.host", host); 
		props.put("mail.smtp.port", port); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.ssl.enable", "true"); 
		props.put("mail.smtp.ssl.trust", host);
		
		Session session = Session.getDefaultInstance(props, new Authenticator() { 
			protected PasswordAuthentication getPasswordAuthentication() { 
				return new PasswordAuthentication("gugusystem", "gugujava1!"); 
			} 
		});
		session.setDebug(true);
		
		Message mimeMessage = new MimeMessage(session);
		
			mimeMessage.setFrom(new InternetAddress("gugusystem@naver.com"));
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(body);
			
			Transport.send(mimeMessage);
			
		} catch (MessagingException e) {
			System.out.println("메일전송실패");
			e.printStackTrace();
		}
	}
	
}
