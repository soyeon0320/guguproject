package dao;

import java.sql.SQLException;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import vo.LicenseVO;

/**
 * 자격증 DAO
 * @author ksy
 */
public interface LicenseDAO{
	/**
	 * 자격증 전체 조회
	 * @param smc 쿼리를 수행하기 위한 객체
	 * @param lv 자격증 정보가 담긴 객체
	 * @return 자격증 리스트
	 * @throws SQLException 예외 처리
	 */
	public List<LicenseVO> ResumeLicenseSelect(SqlMapClient smc, LicenseVO lv) throws SQLException;
	
	/**
	 * 자격증 등록
	 * @param smc 쿼리를 수행하기 위한 객체
	 * @param lv 자격증 정보가 담긴 객체
	 * @return 0:등록 실패 1:등록 성공
	 * @throws SQLException 예외 처리
	 */
	public int ResumeLicenseInsert(SqlMapClient smc, LicenseVO lv) throws SQLException;
	
	/**
	 * 자격증 수정
	 * @param smc 쿼리를 수행하기 위한 객체
	 * @param lv 자격증 정보가 담긴 객체
	 * @return 0:수정 실패 1:수정 성공
	 * @throws SQLException 예외 처리
	 */
	public int ResumeLicenseUpdate(SqlMapClient smc, LicenseVO lv) throws SQLException;
	
	/**
	 * 자격증 삭제
	 * @param smc 쿼리를 수행하기 위한 객체
	 * @param licenseCode 자격증을 구분할 수 있는 코드
	 * @return 0:삭제 실패 1:삭제 성공
	 * @throws SQLException 예외 처리
	 */
	public int ResumeLicenseDelete(SqlMapClient smc, String licenseCode) throws SQLException;
}
