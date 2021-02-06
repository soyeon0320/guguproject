package service;

import java.sql.SQLException;
import java.util.List;

import dao.SurveyDAO;
import vo.SurveyResultVO;
import vo.QuestionItemVO;
import vo.SurveyQuestionVO;
import vo.SurveyVO;

public interface SurveyService {

	public List<SurveyVO> surveyAllSelect();

	public int surveyInsert(SurveyVO jv);

	public int surveyDelete(String surveyCode);

	public List<SurveyVO> getSearchSurvey(SurveyVO jv);

	public int surveyUpdate(SurveyVO jv);

	public List<SurveyQuestionVO> getSurveyQuestionList(SurveyVO mv);

	public List<QuestionItemVO> getQuestionItemList(String sqCode);

	public int surveyAnswerInsert(SurveyResultVO srvo);

	
	

	}



	
	

