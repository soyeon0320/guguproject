package serviceImpl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.SurveyDAO;
import daoImpl.SurveyDAOImpl;
import service.SurveyService;
import util.SqlMapClientFactory;
import vo.QuestionItemVO;
import vo.SurveyQuestionVO;
import vo.SurveyVO;
import vo.SurveyResultVO;


public class SurveyServiceImpl implements SurveyService{
	private static SurveyService surveyService;
	private SurveyDAO surveyDao;
	private SqlMapClient smc;
	
	public SurveyServiceImpl() {
		surveyDao = SurveyDAOImpl.getInstance();
		smc=SqlMapClientFactory.getInstance();
	}
	
	public static SurveyService getInstance() {
		if(surveyService==null) {
			surveyService = new SurveyServiceImpl();
		}
		return surveyService;
	}	
	
	//list
	@Override
	public List<SurveyVO> surveyAllSelect() {
		List<SurveyVO> surveyList = Collections.emptyList();
		try {
			surveyList = surveyDao.surveyAllSelect(smc);
		}catch(SQLException e) {
			throw new RuntimeException("전체 게시글 조회 중 예외 발생!!!", e);
		}
		return surveyList;
	}
	
	//등록
	@Override
	public int surveyInsert(SurveyVO jv) {
		int cnt = 0;
		
		try {
			smc.startTransaction();
			
			cnt = surveyDao.surveyInsert(smc, jv);
			smc.commitTransaction();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				smc.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return cnt;
	}
	
	//삭제
	@Override
	public int surveyDelete (String surveyCode) {
		int cnt = 0;
		try {
		cnt = surveyDao.surveyDelete(smc, surveyCode); 
		}catch (Exception e) {
			throw new RuntimeException("삭제중 예외 발생", e);
		}
		return cnt;
	}
	
	//상세조회
	@Override
	public List<SurveyVO> getSearchSurvey(SurveyVO mv) {
		
		List<SurveyVO> surveyList = Collections.emptyList();
		
		try {
			surveyList = surveyDao.getSearchSurvey(smc, mv);
			
		} catch (SQLException e) {
			throw new RuntimeException("검색중 예외발생", e);
		} 
				
		return surveyList;
	}

	//수정
	@Override
	public int surveyUpdate(SurveyVO jv) {
		int cnt = 0;
		
		try {
			
			cnt = surveyDao.surveyUpdate(smc, jv);
			
		} catch(SQLException e) {
			throw new RuntimeException("정보 수정중 예외발생", e);
		}
		return cnt;
	}

	
	
	
	
	@Override
	public List<SurveyQuestionVO> getSurveyQuestionList(SurveyVO mv) {
		
		List<SurveyQuestionVO> questionList = Collections.emptyList();
		
		try {
			questionList = surveyDao.getSurveyQuestionList(smc, mv);
			
		} catch (SQLException e) {
			throw new RuntimeException("검색중 예외발생", e);
		} 
				
		return questionList;
	}	
	
	@Override
	public List<QuestionItemVO> getQuestionItemList(String sqCode) {
		
		List<QuestionItemVO> questionItemList = Collections.emptyList();
		
		try {
			questionItemList = surveyDao.getQuestionItemList(smc, sqCode);
			
		} catch (SQLException e) {
			throw new RuntimeException("검색중 예외발생", e);
		} 
				
		return questionItemList;
	}	
	
	@Override
	public int surveyAnswerInsert(SurveyResultVO srvo) {
		int cnt = 0;
		
		cnt = surveyDao.surveyAnswerInsert(smc, srvo);
		return cnt;
	}	
	
	
}