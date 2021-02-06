package handler.apply;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

import service.CareerService;
import service.IntroductionService;
import service.LicenseService;
import service.MemberService;
import service.ResumeService;
import serviceImpl.CareerServiceImpl;
import serviceImpl.IntroductionServiceImpl;
import serviceImpl.LicenseServiceImpl;
import serviceImpl.MemberServiceImpl;
import serviceImpl.ResumeServiceImpl;
import vo.CareerVO;
import vo.IntroductionVO;
import vo.LicenseVO;
import vo.MemberVO;
import vo.ResumeVO;

public class GetPDF {
	private ResumeService resumeService = ResumeServiceImpl.getInstance();
	private MemberService memberService = MemberServiceImpl.getInstance();
	private LicenseService licenseService = LicenseServiceImpl.getInstance();
	private CareerService careerService = CareerServiceImpl.getInstance();
	private IntroductionService introductionService = IntroductionServiceImpl.getInstance();
	
	public void printPdf(String memberId, String introCode, String resumeCode) throws IOException, DocumentException {
		Document document = new Document(PageSize.A4, 50, 50, 50, 50); // 용지 및 여백 설정
	    
		// PdfWriter 생성
		//PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("d:/test.pdf")); // 바로 다운로드.
//		PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
		
		String storePath = "d:/gugusystem/"+memberId+"Applydoc.pdf";
		
		File file = new File("d:/gugusystem");
		if(file.mkdirs()) {
			System.out.println("디렉토리생성");
		}
		
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(storePath));
		writer.setInitialLeading(12.5f);
		 
		// 파일 다운로드 설정
//		response.setContentType("application/pdf");
//		String fileName = URLEncoder.encode("한글파일명", "UTF-8"); // 파일명이 한글일 땐 인코딩 필요
//		response.setHeader("Content-Transper-Encoding", "binary");
//		response.setHeader("Content-Disposition", "inline; filename=" + fileName + ".pdf");
		 
		// Document 오픈
		document.open();
		XMLWorkerHelper helper = XMLWorkerHelper.getInstance();
		     
		// CSS
		CSSResolver cssResolver = new StyleAttrCSSResolver();
		CssFile cssFile = helper.getCSS(new FileInputStream("D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\GUGUProject\\WebContent\\assets\\css\\pdf.css"));
		cssResolver.addCss(cssFile);
		     
		// HTML, 폰트 설정
		XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
		fontProvider.register("D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\GUGUProject\\src\\handler\\apply\\malgun.ttf", "MalgunGothic"); // MalgunGothic은 alias,
		CssAppliers cssAppliers = new CssAppliersImpl(fontProvider);
		 
		HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
		htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
		 
		// Pipelines
		PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
		HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
		CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);
		 
		XMLWorker worker = new XMLWorker(css, true);
		XMLParser xmlParser = new XMLParser(worker, Charset.forName("UTF-8"));
		 
		// 폰트 설정에서 별칭으로 줬던 "MalgunGothic"을 html 안에 폰트로 지정한다.
		String htmlStr = getString(introCode, resumeCode);
		 
		StringReader strReader = new StringReader(htmlStr);
		xmlParser.parse(strReader);
		 
		document.close();
		writer.close();
	}
	
	
	private String getString(String introCode, String resumeCode) {
		
		//회원 기본정보 가져오기
		// 이력서 코드 세팅
		ResumeVO rv = new ResumeVO();
		rv.setCode(resumeCode);
		
		List<ResumeVO> resumeList = resumeService.ResumeSelect(rv);
		
		rv = resumeList.get(0);
		
		MemberVO mv = new MemberVO();
		mv.setMemberId(resumeList.get(0).getMemberId());
		
		List<MemberVO> memberList = memberService.memberSelect(mv);
		
		// 회원정보 추출
		mv = memberList.get(0);
		String memberId = mv.getMemberId();
		String memberName = mv.getMemberName(); 
		String memberBirth = mv.getMemberBirth();
		String memberGender = mv.getMemberGender();
		String memberPhone = mv.getMemberPhone();
		String memberEmail = mv.getMemberEmail();
		String memberAddr1 = mv.getMemberAddr1();
		String memberAddr2 = mv.getMemberAddr2();
		
		// 이력서 정보 추출
		String resumeTitle = rv.getTitle();
		String schoolSection = rv.getSchoolSection();
		String schoolName = rv.getSchoolName();
		String schoolMajor = rv.getSchoolMajor();
		double schoolScore = rv.getSchoolScore();
		String schoolStartDate = rv.getSchoolStartDate();
		String schoolEndDate = rv.getSchoolEndDate();
		String schoolEndYn = rv.getSchoolEndYn();
		
		// 자격증 리스트 추출
		LicenseVO lv = new LicenseVO();
		lv.setResumeCode(resumeCode);
		List<LicenseVO> licenseList = licenseService.ResumeLicenseSelect(lv);
		
		String licenseStr = "";
				for (LicenseVO lvo : licenseList) {
					licenseStr +=
				"		<tr>" + 
				"			<th>자격증명</th>" + 
				"			<td colspan='2'>"+lvo.getName()+"</td>" + 
				"			<th>취득일</th>" + 
				"			<td colspan='2'>"+lvo.getGetDate().substring(0, 11)+"</td>" + 
				"		</tr>"; 	
				}
				
		// 경력사항 추출		
		CareerVO cv = new CareerVO();
		cv.setResumeCode(resumeCode);
		List<CareerVO> careerList = careerService.ResumeCareerSelect(cv);
		String careerStr = "";
		for (CareerVO cvo : careerList) {
			careerStr += 
				"		<tr>" + 
				"			<th>회사명</th>" + 
				"			<td colspan='2'>"+cvo.getCompanyName()+"</td>" + 
				"			<th>부서명</th>" + 
				"			<td colspan='2'>"+cvo.getDepartName()+"</td>" + 
				"		</tr>" + 
				"		<tr>" + 
				"			<th>입사일</th>" + 
				"			<td colspan='2'>"+cvo.getStartDate().substring(0, 11)+"</td>" + 
				"			<th>퇴사일</th>" + 
				"			<td colspan='2'>"+cvo.getEndDate().substring(0, 11)+"</td>" + 
				"		</tr>" + 
				"		<tr>" + 
				"			<th>직무명</th>" + 
				"			<td colspan='2'>"+cvo.getJobName()+"</td>" + 
				"			<th>직책명</th>" + 
				"			<td colspan='2'>"+cvo.getPositionName()+"</td>" + 
				"		</tr>";				
		}
		
		// 자기소개서 추출
		String introductionCode = introCode;
		IntroductionVO introductionVO =  introductionService.getIntoduction(introductionCode);
		
		
		String finalStr =
				"<html>" + 
				"<head>" + 
				"<style type='text/css'>" + 
				".card-title {" + 
				"	font-size: 25px;" + 
				"}" + 
				"table{" + 
				"    width: 100%;" + 
				"    border: 1px solid #444444;" + 
				"    border-collapse: collapse;" + 
				"    margin-left: auto;" + 
				"    margin-right: auto;" +
				"    margin-top: 50px;" + 
				"}" + 
				"th, td{" + 
				"	border: 1px solid #444444;"+
				"   padding: 3px;" +
				"   height: 40px;" + 
				"}" + 
				"th{" + 
				"   width: 40px;" + 
				"   text-align: center;" + 
				"}" + 
				"</style>" + 
				"</head>" + 
				"<body style='font-family: MalgunGothic;'>" + 
				"	<h3 class='card-title' style='text-align: center;'>"+resumeTitle+"</h3>" + 
				"	<table>" + 
				"		<tr>" + 
				"			<th colspan='6' style='text-align: center; color: #007acc;'>인적사항</th>" + 
				"		</tr>" + 
				"		<tr>" + 
				"			<th>이름</th>" + 
				"			<td>"+memberName+"</td>" + 
				"			<th>성별</th>" + 
				"			<td colspan='3'>"+memberGender+"</td>" + 
				"		</tr>" + 
				"		<tr>" + 
				"			<th>생년월일</th>" + 
				"			<td>"+memberBirth+"</td>" + 
				"			<th>연락처</th>" + 
				"			<td colspan='3'>"+memberPhone+"</td>" + 
				"		</tr>" + 
				"		<tr>" + 
				"			<th>이메일</th>" + 
				"			<td>"+memberEmail+"</td>" + 
				"			<th>주소</th>" + 
				"			<td colspan='3'>"+memberAddr1+" "+memberAddr2+"</td>" + 
				"		</tr>" + 
				"		<tr>" + 
				"			<th colspan='6' style='text-align: center; color: #007acc;'>최종학력</th>" + 
				"		</tr>" + 
				"		<tr>" + 
				"			<th>학교구분</th>" + 
				"			<td>"+schoolSection+"</td>" + 
				"			<th>학교명</th>" + 
				"			<td>"+schoolName+"</td>" + 
				"			<th>전공명</th>" + 
				"			<td>"+schoolMajor+"</td>" + 
				"		</tr>" + 
				"		<tr>" + 
				"			<th>기간</th>" + 
				"			<td>"+schoolStartDate.substring(0, 11)+" - "+schoolEndDate.substring(0, 11)+"</td>" + 
				"			<th>학점</th>" + 
				"			<td>"+schoolScore+"</td>" + 
				"			<th>졸업여부</th>" + 
				"			<td>"+schoolEndYn+"</td>" + 
				"		</tr>" + 
				"		<tr>" + 
				"			<th colspan='6' style='text-align: center; color: #007acc;'>자격증</th>" + 
				"		</tr>" + 
							licenseStr +
				"		<tr>" + 
				"			<th colspan='6' style='text-align: center; color: #007acc;'>경력</th>" + 
				"		</tr>" + 
							careerStr +
				"		<tr>" + 
				"			<td colspan='6' style='font-size: 20px; text-align: center;'>자기소개서</td>" + 
				"		</tr>" + 
				"		<tr>" + 
				"			<th>지원동기</th>" + 
				"			<td colspan='5'>"+introductionVO.getReason()+"</td>" + 
				"		</tr>" + 
				"		<tr>" + 
				"			<th>성장배경</th>" + 
				"			<td colspan='5'>"+introductionVO.getGrowth()+"</td>" + 
				"		</tr>" + 
				"		<tr>" + 
				"			<th>경력사항</th>" + 
				"			<td colspan='5'>"+introductionVO.getCareer()+"</td>" + 
				"		</tr>" + 
				"	</table>" + 
				"</body>" + 
				"</html>";		
		
		return finalStr;
	}
	
}
