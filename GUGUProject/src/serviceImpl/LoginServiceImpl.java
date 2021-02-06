package serviceImpl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.LoginDAO;
import daoImpl.LoginDAOImpl;
import service.LoginService;
import util.SqlMapClientFactory;
import vo.AdminVO;
import vo.MemberVO;

public class LoginServiceImpl implements LoginService {

	private static LoginService loginService;
	
	private LoginDAO loginDAO;
	private SqlMapClient smc;
	
	public LoginServiceImpl() {
		loginDAO = LoginDAOImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	

	public static LoginService getInstance() {
		if(loginService == null) {
			loginService = new LoginServiceImpl();
		}
		return loginService;
	}
	
	



	@Override
	public MemberVO Login(MemberVO memberVO) {
		
		MemberVO result = null;
		
		try {
			smc.startTransaction();
			
			result = loginDAO.login(smc, memberVO);
			
			smc.commitTransaction(); // 커밋..
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				smc.endTransaction(); // 커밋이 됐으면 커밋.. 커밋에 실패하면 자동으로 롤백
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return result;
		// => 서비스 단에서 트렌젝션처리 가능한 비즈니스 로직을 구현..
	}


	@Override
	public AdminVO adminLogin(AdminVO adminVO) {
		
		AdminVO result = null;
		
		try {
			smc.startTransaction();
			
			result = loginDAO.adminLogin(smc, adminVO);
			
			smc.commitTransaction(); // 커밋..
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				smc.endTransaction(); // 커밋이 됐으면 커밋.. 커밋에 실패하면 자동으로 롤백
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return result;
	}

}
