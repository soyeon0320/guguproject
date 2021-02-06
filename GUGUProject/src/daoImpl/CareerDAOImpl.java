package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import dao.CareerDAO;
import vo.CareerVO;

/**
 * 경력 DAO 구현부
 * @author ksy
 */
public class CareerDAOImpl implements CareerDAO{
	private static CareerDAO careerDao;
	
	public CareerDAOImpl() {
		
	}
	
	/**
	 * 경력 DAO 객체 생성
	 */
	public static CareerDAO getInstance() {
		if(careerDao==null) {
			careerDao = new CareerDAOImpl();
		}
		return careerDao;
	}

	/**
	 * 경력 전체 조회
	 */
	@Override
	public List<CareerVO> ResumeCareerSelect(SqlMapClient smc, CareerVO cv) throws SQLException {
		List<CareerVO> careerList = new ArrayList<CareerVO>();
		careerList = smc.queryForList("resume.ResumeCareerSelect", cv);
		return careerList;
	}

	/**
	 * 경력 등록
	 */
	@Override
	public int ResumeCareerInsert(SqlMapClient smc, CareerVO cv) throws SQLException {
		int resCnt = 0;
		Object obj = smc.insert("resume.ResumeCareerInsert", cv);
		if(obj==null) {
			resCnt = 1;
		}
		return resCnt;
	}

	/**
	 * 경력 수정
	 */
	@Override
	public int ResumeCareerUpdate(SqlMapClient smc, CareerVO cv) throws SQLException {
		int resCnt = smc.update("resume.ResumeCareerUpdate", cv);
		return resCnt;
	}

	/**
	 * 경력 삭제
	 */
	@Override
	public int ResumeCareerDelete(SqlMapClient smc, String careerCode) throws SQLException {
		int resCnt = smc.delete("resume.ResumeCareerDelete", careerCode);
		return resCnt;
	}
}
