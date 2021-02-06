package handler.survey;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.SurveyService;
import serviceImpl.SurveyServiceImpl;
import vo.SurveyVO;

public class SurveyListHandler implements CommonHandler{

	private SurveyService surveyService = new SurveyServiceImpl();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String url = "/WEB-INF/view/survey/surveyList.jsp";
		
		List<SurveyVO> surveyList = surveyService.surveyAllSelect();

		req.setAttribute("surveyList", surveyList);		
		
		return url;
	}

}
