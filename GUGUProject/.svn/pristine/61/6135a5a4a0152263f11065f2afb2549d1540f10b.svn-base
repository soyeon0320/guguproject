package serviceImpl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.FaqDAO;
import daoImpl.FaqDAOImpl;
import service.FaqService;
import util.SqlMapClientFactory;
import vo.AdminVO;
import vo.FaqVO;

public class FaqServiceImpl implements FaqService{

	private static FaqService fs;
	private FaqDAO dao;
	private SqlMapClient smc;
	
	public FaqServiceImpl() {
		dao = FaqDAOImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static FaqService getInstance() {
		if(fs == null) {
			fs = new FaqServiceImpl();
		}
		return fs;
	}
	
	@Override
	public List<FaqVO> faqList() {
		List<FaqVO> list = Collections.emptyList();
		try {
			list = dao.faqList(smc);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("전체 회원 조회 중 오류",e);
		}
		return list;
	}

	
	@Override
	public int InsertFaq(FaqVO vo) {
		int cnt = 0;
		try {
			smc.startTransaction();
			cnt = dao.InsertFaq(smc,vo);
			smc.commitTransaction();
		}catch (SQLException e) {
			try {
				smc.endTransaction();
			}catch (Exception e1) {
				e1.printStackTrace();
				throw new RuntimeException("등록 에러",e);
			}finally {
				try {
					smc.endTransaction();
				}catch (SQLException e2) {
					e.printStackTrace();
				}
			}
		}
		return cnt;
	}
	
	@Override
	public List<FaqVO> searchCode(FaqVO vo) {
		List<FaqVO> list = Collections.emptyList();
		
		try {
			
			list = dao.searchCode(smc,vo);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int update(FaqVO vo) {
		int cnt = 0;
		
		try {
			cnt = dao.update(smc,vo);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("업데이트 중 오류",e);
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
