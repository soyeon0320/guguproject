package handler.survey;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonHandler;
import service.SurveyService;
import serviceImpl.SurveyServiceImpl;
import vo.QuestionItemVO;
import vo.SurveyQuestionVO;
import vo.SurveyResultVO;
import vo.SurveyVO;

public class SurveyDetailHandler implements CommonHandler{

	private SurveyService surveyService = new SurveyServiceImpl();
	
	@Override
	public boolean RedirectYn(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			return false;
			}else {
				return true;
			}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String url = "/WEB-INF/view/survey/surveyDetail.jsp";
		
		String surveyState = req.getParameter("surveyState");
		if(surveyState==null) surveyState="START";
		
		if(surveyState.equals("END")) { //설문조사완료처리
			
			
			
			
			//String sqSizeStr=req.getParameter("sqSize").toString();
			//int sqSize = Integer.parseInt(sqSizeStr);
			//String answer[] = req.getParameterValues("answer");
		
			Enumeration<String> names = req.getParameterNames();

			do{
				String name = names.nextElement();
				System.out.println("-----"+name);
				
				if(name.indexOf("answer")==-1) continue;
				System.out.println("-----111111111");
				
				String answer = req.getParameter(name);
				
				String sqCode = answer.split(";")[0];
				String surveyresultMostselect = answer.split(";")[1];
				
				SurveyResultVO srvo = new SurveyResultVO();
				srvo.setSqCode(sqCode);
				srvo.setSurveyresultMostselect(surveyresultMostselect);
//				srvo.setMemberId(memId); 
				
				int cnt =surveyService.surveyAnswerInsert(srvo);
			}while(names.hasMoreElements());
			

			
			return "/GUGUProject/survey/list.do";
			
			
		}else { //상세조회(설문조사)
		
			
			String surveyCode = req.getParameter("surveyCode");		
			
			SurveyVO sv = new SurveyVO();
			sv.setSurveyCode(surveyCode);
			
			List<SurveyVO> surveyList = surveyService.getSearchSurvey(sv);
			
			List<SurveyQuestionVO> questionList;
			List<SurveyQuestionVO> surveyQuestionList = surveyService.getSurveyQuestionList(sv);
			for(int i=0;i<surveyQuestionList.size();i++) {
				SurveyQuestionVO sq = (SurveyQuestionVO)surveyQuestionList.get(i);
				
				String sqCode = surveyQuestionList.get(i).getSqCode();
				
				List<QuestionItemVO> questionItemList = surveyService.getQuestionItemList(sqCode);
				
				surveyQuestionList.get(i).setQuestionItemList(questionItemList);
				
			}
	
			
			surveyList.get(0).setQuestionList(surveyQuestionList);
			req.setAttribute("surveyList", surveyList);		
		}
		return url;
	}

}
