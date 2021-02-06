package serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import dao.CareerDAO;
import daoImpl.CareerDAOImpl;
import service.CareerService;
import util.SqlMapClientFactory;
import vo.CareerVO;

/**
 * 경력 서비스 구현부
 * @author ksy
 */
public class CareerServiceImpl implements CareerService {
	private static CareerService careerService;
	private CareerDAO careerDao;
	private SqlMapClient smc;
	
	/**
	 * 경력 서비스 객체 생성
	 * @return 존재하면 현재 객체를 반환하고 존재하지 않으면 새로 생성
	 */
	public static CareerService getInstance() {
		if(careerService==null) {
			careerService = new CareerServiceImpl();
		}
		return careerService;
	}
	
	public CareerServiceImpl() {
		careerDao = CareerDAOImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}

	/**
	 * 경력 전체 조회
	 */
	@Override
	public List<CareerVO> ResumeCareerSelect(CareerVO cv) {
		List<CareerVO> careerList = Collections.EMPTY_LIST;
		try {
			careerList = careerDao.ResumeCareerSelect(smc, cv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return careerList;
	}

	/**
	 * 경력 등록
	 */
	@Override
	public int ResumeCareerInsert(CareerVO cv) {
		int resCnt = 0;
		try {
			smc.startTransaction();
			resCnt = careerDao.ResumeCareerInsert(smc, cv);
			smc.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				smc.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resCnt;
	}

	/**
	 * 경력 수정
	 */
	@Override
	public int ResumeCareerUpdate(CareerVO cv) {
		int resCnt = 0;
		try {
			resCnt = careerDao.ResumeCareerUpdate(smc, cv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resCnt;
	}

	/**
	 * 경력 삭제
	 */
	@Override
	public int ResumeCareerDelete(String careerCode) {
		int resCnt = 0;
		try {
			resCnt = careerDao.ResumeCareerDelete(smc, careerCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resCnt;
	}
}
