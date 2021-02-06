package serviceImpl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import dao.LicenseDAO;
import daoImpl.LicenseDAOImpl;
import service.LicenseService;
import util.SqlMapClientFactory;
import vo.LicenseVO;

/**
 * 자격증 서비스 구현부
 * @author ksy
 */
public class LicenseServiceImpl implements LicenseService{
	private static LicenseService licenseService;
	private LicenseDAO licenseDao;
	private SqlMapClient smc;
	
	/**
	 * 자격증 서비스 객체 생성
	 * @return 현존하면 반환하고 현존하지 않으면 생성
	 */
	public static LicenseService getInstance() {
		if(licenseService==null) {
			licenseService = new LicenseServiceImpl();
		}
		return licenseService;
	}
	
	public LicenseServiceImpl() {
		licenseDao = LicenseDAOImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}

	/**
	 * 자격증 전체 조회
	 */
	@Override
	public List<LicenseVO> ResumeLicenseSelect(LicenseVO lv) {
		List<LicenseVO> licenseList = Collections.EMPTY_LIST;
		try {
			licenseList = licenseDao.ResumeLicenseSelect(smc, lv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return licenseList;
	}

	/**
	 * 자격증 등록
	 */
	@Override
	public int ResumeLicenseInsert(LicenseVO lv) {
		int resCnt = 0;
		try {
			smc.startTransaction();
			resCnt = licenseDao.ResumeLicenseInsert(smc, lv);
			smc.commitTransaction();
		} catch (SQLException e) {
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
	 * 자격증 수정
	 */
	@Override
	public int ResumeLicenseUpdate(LicenseVO lv) {
		int resCnt = 0;
		try {
			resCnt = licenseDao.ResumeLicenseUpdate(smc, lv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resCnt;
	}

	/**
	 * 자격증 삭제
	 */
	@Override
	public int ResumeLicenseDelete(String licenseCode) {
		int resCnt = 0;
		try {
			resCnt = licenseDao.ResumeLicenseDelete(smc, licenseCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resCnt;
	}
	
	
}
