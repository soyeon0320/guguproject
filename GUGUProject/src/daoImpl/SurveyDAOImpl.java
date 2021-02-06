package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.SurveyDAO;
import vo.SurveyVO;
import vo.QuestionItemVO;
import vo.SurveyQuestionVO;
import vo.SurveyResultVO;


public class SurveyDAOImpl  implements SurveyDAO{
static SurveyDAO surveyDao;

private SurveyDAOImpl() {
		
	}
public static SurveyDAO getInstance() {
	if(surveyDao==null) {
		surveyDao = new SurveyDAOImpl();
	}
	return surveyDao;
}
	//survey리스트 전체조회
	@Override
	public List<SurveyVO> surveyAllSelect(SqlMapClient smc) throws SQLException {
		List<SurveyVO> surveyList = new ArrayList<SurveyVO>();
		surveyList = smc.queryForList("survey.SurveyAllSelect");
		return surveyList;
	}
	
	//survey 등록
	@Override
	public int surveyInsert(SqlMapClient smc, SurveyVO jv) throws SQLException {

		int cnt = 0;
		
		Object obj = smc.insert("survey.surveyInsert",jv);
		
		if(obj==null) {
			cnt=1;
		}
		return cnt;
	}

	//survey 삭제
	@Override
	public int surveyDelete(SqlMapClient smc, String surveyCode) throws SQLException {
		int resCnt = 0;
		resCnt = smc.delete("survey.surveyDelete", surveyCode);
		return resCnt;
	}
	
	//survey 상세검색(상세조회)=>select
	@Override
	public List<SurveyVO> getSearchSurvey (SqlMapClient smc, SurveyVO jv) throws SQLException {
		List<SurveyVO> surveyList = new ArrayList<>();
		surveyList = smc.queryForList("survey.getSearchSurvey", jv);
		return surveyList;
	}
	
	//survey 수정
	@Override
	public int surveyUpdate(SqlMapClient smc, SurveyVO jv) throws SQLException {
		
		int cnt = 0;

		cnt = smc.update("survey.updateSurvey", jv);
		
		return cnt;
		
	}

	@Override
	public boolean getSurvey(SqlMapClient smc, String surveyCode) throws SQLException {
		return false;
	}

	

	
	
	@Override
	public List<SurveyQuestionVO> getSurveyQuestionList (SqlMapClient smc, SurveyVO jv) throws SQLException {
		List<SurveyQuestionVO> questionList = new ArrayList<>();
		questionList = smc.queryForList("survey.getSurveyQuestionList", jv);
		return questionList;
	}	
	
	@Override
	public List<QuestionItemVO> getQuestionItemList (SqlMapClient smc, String sqCode) throws SQLException {
		List<QuestionItemVO> questionItemList = new ArrayList<>();
		questionItemList = smc.queryForList("survey.getQuestionItemList", sqCode);
		return questionItemList;
	}		
	
	@Override
	public int surveyAnswerInsert(SqlMapClient smc, SurveyResultVO srvo){
		int cnt = 0;

		try {
			cnt = (int)smc.insert("survey.surveyAnswerInsert", srvo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}	
		
	
}


