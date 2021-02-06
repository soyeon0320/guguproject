package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import vo.SurveyResultVO;
import vo.QuestionItemVO;
import vo.SurveyQuestionVO;
import vo.SurveyVO;

public interface SurveyDAO {
	
	/**DB의 survey테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드*/
	public List<SurveyVO> surveyAllSelect(SqlMapClient smc) throws SQLException;
	/**SurveyVO에 담긴 데이터를 이용하여 회원을 검색하는 메서드*/
	public List<SurveyVO> getSearchSurvey(SqlMapClient smc, SurveyVO mv) throws SQLException;
	/**
	 * 주어진 surveyCode가 존재하는지 여부를 알아내는 메서드
	 * @param conn SqlMapClient 객체
	 * @param SurveyCode 검색할 SurveyCode
	 * @return 해당 SurveyCode가 있으면 true, 없으면 false
	 * @throws SQLException JDBC관련 예외객체
	 */
	public boolean getSurvey(SqlMapClient smc, String surveyCode) throws SQLException;

	
	public int surveyInsert(SqlMapClient smc, SurveyVO mv) throws SQLException;
	
	public int surveyUpdate(SqlMapClient smc,SurveyVO mv) throws SQLException; 
	
	public int surveyDelete(SqlMapClient smc, String surveyCode) throws SQLException;

	public List<SurveyQuestionVO> getSurveyQuestionList(SqlMapClient smc, SurveyVO jv) throws SQLException;
	public List<QuestionItemVO> getQuestionItemList(SqlMapClient smc, String sqCode) throws SQLException;
	int surveyAnswerInsert(SqlMapClient smc, SurveyResultVO srvo);


}

