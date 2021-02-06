package serviceImpl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import dao.NotisDAO;
import daoImpl.NotisDAOImpl;
import service.NotisService;
import util.SqlMapClientFactory;
import vo.NotisVO;

public class NotisServiceImpl implements NotisService{
	
	private static NotisService ns;
	private NotisDAO dao;
	private SqlMapClient smc;
	
	public NotisServiceImpl() {
		dao = NotisDAOImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static NotisService getInstance() {
		if(ns == null) {
			ns = new NotisServiceImpl();
		}
		return ns;
	}
	@Override
	public List<NotisVO> notisList() {
		List<NotisVO> list = Collections.emptyList();
		try {
			list = dao.notisList(smc);
		}catch (Exception e) {
			e.printStackTrace();
			throw new  RuntimeException();
		}
		return list;
	}

	@Override
	public int insert(NotisVO vo) {
		int cnt = 0;
		try {
			smc.startTransaction();
			cnt = dao.insert(smc, vo);
			smc.commitTransaction();
		}catch (SQLException e) {
			try {
				smc.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException("등록 중 오류",e1);
			}finally {
				try {
					smc.endTransaction();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		}
		return cnt;
	}

	@Override
	public List<NotisVO> searchCode(String code) {
		List<NotisVO> list = Collections.emptyList();
		try {
			list = dao.searchCode(smc,code);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("정보 조회중 오류",e);
		}
		return list;
	}
	
	@Override
	public int update(NotisVO vo) {
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
