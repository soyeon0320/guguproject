package serviceImpl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.FindAccountDAO;
import dao.LoginDAO;
import daoImpl.FindAccountDAOImpl;
import daoImpl.LoginDAOImpl;
import service.FindAccountService;
import service.LoginService;
import util.SqlMapClientFactory;
import vo.MemberVO;

public class FindAccountServiceImpl implements FindAccountService {
	
	private static FindAccountService findAccountService;
	
	private FindAccountDAO findAccountDAO;
	private SqlMapClient smc;
	
	public FindAccountServiceImpl() {
		findAccountDAO = FindAccountDAOImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	

	public static FindAccountService getInstance() {
		if(findAccountService == null) {
			findAccountService = new FindAccountServiceImpl();
		}
		return findAccountService;
	}


	@Override
	public int findPwInputId(String memberId) {
		
		int cnt = 0; 
		
		
		try {
			cnt = findAccountDAO.findPwInputId(smc, memberId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}


	@Override
	public MemberVO findPwInputEmail(String memberEmail) {
		
		MemberVO result = null;
		try {
			result = findAccountDAO.findPwInputEmail(smc, memberEmail);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	@Override
	public MemberVO findId(MemberVO memberVO) {
		
		MemberVO result = null;
		
		try {
			result = findAccountDAO.findId(smc, memberVO);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
		
	}


	
	
	
	
	
}
