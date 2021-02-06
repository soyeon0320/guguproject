package dao;

import java.sql.SQLException;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import vo.CareerVO;

/**
 * 경력 DAO
 * @author ksy
 */
public interface CareerDAO {
	/**
	 * 경력 전체 조회
	 * @param smc 쿼리를 수행하기 위한 객체
	 * @param cv 경력 정보가 담긴 객체
	 * @return 경력 리스트
	 * @throws SQLException 예외 처리
	 */
	public List<CareerVO> ResumeCareerSelect(SqlMapClient smc, CareerVO cv) throws SQLException;
	
	/**
	 * 경력 등록
	 * @param smc 쿼리를 수행하기 위한 객체
	 * @param cv 경력 정보가 담긴 객체
	 * @return 0:실패 1:성공
	 * @throws SQLException 예외 처리
	 */
	public int ResumeCareerInsert(SqlMapClient smc, CareerVO cv) throws SQLException;
	
	/**
	 * 경력 수정
	 * @param smc 쿼리를 수행하기 위한 객체
	 * @param cv 경력 정보가 담긴 객체
	 * @return 0:실패 1:성공
	 * @throws SQLException 예외 처리
	 */
	public int ResumeCareerUpdate(SqlMapClient smc, CareerVO cv) throws SQLException;
	
	/**
	 * 경력 삭제
	 * @param smc 쿼리를 수행하기 위한 객체
	 * @param careerCode 경력을 구분하기 위한 코드
	 * @return 0:실패 1:성공
	 * @throws SQLException 예외 처리
	 */
	public int ResumeCareerDelete(SqlMapClient smc, String careerCode) throws SQLException;
}
