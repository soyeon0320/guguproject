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

public class PdfDownloadHandler implements CommonHandler {

	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession(false);
		
		String introCode = req.getParameter("introCode");
		String resumeCode = req.getParameter("resumeCode");
		String memberId = (String)session.getAttribute("memberId");
		
		GetPDF getPdf = new GetPDF();
		getPdf.printPdf(memberId, introCode, resumeCode); // pdf저장완료 d:/gugusystem/+memberId+Applydoc.pdf
		
		
		
		return null;
	}

}
