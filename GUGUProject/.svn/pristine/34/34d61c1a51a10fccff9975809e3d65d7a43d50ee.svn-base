package serviceImpl;

import java.util.Collections;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.BoardManagerDAO;
import daoImpl.BoardManagerDAOImpl;
import service.BoardManagerService;
import util.SqlMapClientFactory;
import vo.BoardManagerVO;

public class BoardManagerServiceImpl implements BoardManagerService {

	private static BoardManagerService bms;
	private BoardManagerDAO dao;
	private SqlMapClient smc;
	
	public BoardManagerServiceImpl() {
		dao = BoardManagerDAOImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static BoardManagerService getInstance() {
		if(bms == null) {
			bms = new BoardManagerServiceImpl();
		}
		return bms;
	}

	
	@Override
	public List<BoardManagerVO> searchList(String searchName) {
		List<BoardManagerVO> list = Collections.emptyList();
		System.out.println("1차 검증"+searchName);
		
		try{
			list = dao.searchList(smc, searchName);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("통합 검색 중 오류",e);
		}
		return list;
	}
}













