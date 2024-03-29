package serviceImpl;

import java.util.Collections;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.CompanyDAO;
import daoImpl.CompanyDAOImpl;
import service.CompanyService;
import util.SqlMapClientFactory;
import vo.CompanyVO;

public class CompanyServiceImpl implements CompanyService{


	private static CompanyService cs;
	private CompanyDAO dao;
	private SqlMapClient smc;
	
	public CompanyServiceImpl() {
		dao = CompanyDAOImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static CompanyService getInstance() {
		if(cs == null) {
			cs = new CompanyServiceImpl();
		}
		return cs;
	}
	
	@Override
	public List<CompanyVO> companyList() {
		
		List<CompanyVO> list = Collections.emptyList();
		
		try {
			list = dao.companyList(smc);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("전체 회원 조회 중 오류",e);
		}
		return list;
	}

	@Override
	public List<CompanyVO> select(CompanyVO vo) {
		List<CompanyVO> list = Collections.emptyList();
		
		try {
			list = dao.select(smc, vo);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("상세 검색 중 오류",e);
		}
		return list;
	}

	@Override
	public int insert(CompanyVO vo) {
		int cnt = 0;
		
		try {
			smc.startTransaction();
			cnt = dao.insert(smc,vo);
			smc.commitTransaction();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("기업 등록 중 오류",e);
		}
		return cnt;
	}

	@Override
	public int modify(CompanyVO vo) {
int cnt =0;
		
		try {
			cnt = dao.modify(smc,vo);
			
		} catch (Exception e) {
			throw new RuntimeException("회원정보 수정 중 예외 발생", e);
		}
		
		return cnt;
	}

	@Override
	public int delete(String code) {
		int cnt = 0;
		try {
			cnt = dao.delete(smc,code);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("삭제 오류",e);
		}
		return cnt;
	}
}

















