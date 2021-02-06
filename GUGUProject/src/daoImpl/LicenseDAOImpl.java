package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import dao.LicenseDAO;
import util.SqlMapClientFactory;
import vo.LicenseVO;

/**
 * 자격증 DAO 구현부
 * @author ksy
 */
public class LicenseDAOImpl implements LicenseDAO{
	private static LicenseDAO licenseDao;
	
	public LicenseDAOImpl() {
		
	}
	
	/**
	 * 자격증 DAO 객체 생성
	 */
	public static LicenseDAO getInstance() {
		if (licenseDao==null) {
			licenseDao = new LicenseDAOImpl();
		}
		return licenseDao;
	}

	/**
	 * 자격증 전체 조회
	 */
	@Override
	public List<LicenseVO> ResumeLicenseSelect(SqlMapClient smc, LicenseVO lv) throws SQLException {
		List<LicenseVO> licenseList = new ArrayList<LicenseVO>();
		licenseList = smc.queryForList("resume.ResumeLicenseSelect", lv);
		return licenseList;
	}

	/**
	 * 자격증 등록
	 */
	@Override
	public int ResumeLicenseInsert(SqlMapClient smc, LicenseVO lv) throws SQLException {
		int resCnt = 0;
		Object obj = smc.insert("resume.ResumeLicenseInsert", lv);
		if(obj==null) {
			resCnt = 1;
		}
		return resCnt;
	}

	/**
	 * 자격증 수정
	 */
	@Override
	public int ResumeLicenseUpdate(SqlMapClient smc, LicenseVO lv) throws SQLException {
		int resCnt = smc.update("resume.ResumeLicenseUpdate", lv);
		return resCnt;
	}

	/**
	 * 자격증 삭제
	 */
	@Override
	public int ResumeLicenseDelete(SqlMapClient smc, String licenseCode) throws SQLException {
		int resCnt = smc.delete("resume.ResumeLicenseDelete", licenseCode);
		return resCnt;
	}
	
}
