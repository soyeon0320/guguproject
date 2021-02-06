//package common;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.FileInputStream;
//import java.net.URLEncoder;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import dao.ImgDAO;
//import daoImpl.ImgDAOImpl;
//
//public class FileDownloadHandler implements CommonHandler{
//	private ImgDAO imgDao = ImgDAOImpl.getInstance();
//	
//	@Override
//	public boolean RedirectYn(HttpServletRequest req) {
//		return false;
//	}
//
//	@Override
//	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//		//파일 id 여부 확인
//		//id와 sn만 가져오면 파일 정보를 알 수 있음 = id와 sn으로 파일을 구별
//		//파일이 존재하면 id와 sn을 대입해줌 <-> 파일이 존재하지 않는다면 기본 값으로 대입
//		//1.요쳥받은 데이터 중에서 파일이 존재하는 것을 걸러내기
//		long fileId = req.getParameter("fileId") != null ? Long.parseLong(req.getParameter("fileId")) : -1;
//		int fileSn = req.getParameter("fileSn") != null ? Integer.parseInt(req.getParameter("fileSn")) : 1;
//					
//		//파일 정보 조회
//		AtchFileVO fileVO = new AtchFileVO();
//		//2.데이터가 있는 파일들을 셋팅
//		fileVO.setAtchFileId(fileId);
//		fileVO.setFileSn(fileSn);
//		
//		//3.2번에서 수행한 데이터들 중에서 where에 만족하는 데이터를 가져온 후 대입
//		fileVO = fileDao.getAtchFileDetail(fileVO);
//		
//		resp.setContentType("application/octet-stream");
//		//내가 원하는 최종 파일은 getOrignFlileNm이다.
//		//replaceAll : 공백을 처리하는 것
//		resp.setHeader("Content-Disposition", "attachment; filename=\"" 
//					+ URLEncoder.encode(fileVO.getOrignFlileNm(), "UTF-8").replaceAll("\\+", "%20")+"\""); 
//		
//		//getFileStreCours : 파일 저장 경로
//		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileVO.getFileStreCours()));
//		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
//		
//		//읽은 바이트 수
//		int bytes = 0;
//		while((bytes = bis.read()) != -1) {
//			bos.write(bytes);
//		}
//		
//		bis.close();
//		bos.close();
//		
//		//view가 있는 경우 리턴함
//		//여기서는 아웃스트림을 사용하기 때문에 null이어도 됨
//		return null;
//	}
//}
