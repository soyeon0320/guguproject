package handler.apply;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonHandler;

public class GetfileDownloadHandler implements CommonHandler {

	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession(false);
		String memberId = (String)session.getAttribute("memberId");
		
		res.setContentType("application/pdf");
		
		ServletOutputStream out = res.getOutputStream();
		
		String filePath = "d:/gugusystem/";
		String fileName = memberId+"Applydoc.pdf";
		
		File file = new File(filePath,fileName);
		
		res.setHeader("Content-Disposition","attachment;filename="+file.getName()+";");
        res.setHeader("Content-Length",""+file.length());
		
		
		FileInputStream fis = new FileInputStream(file);
		
		BufferedInputStream bis = new BufferedInputStream(fis);
	    BufferedOutputStream bos = new BufferedOutputStream(out);
	    
	    int readBytes = 0;
	    while((readBytes = bis.read()) != -1) {
	      bos.write(readBytes);
	    }

	    bis.close();
	    bos.close();
		
		
		
		return null;
	}

}
