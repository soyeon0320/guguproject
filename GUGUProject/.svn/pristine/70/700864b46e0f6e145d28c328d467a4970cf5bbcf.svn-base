package daoImpl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.LoginDAO;
import vo.AdminVO;
import vo.MemberVO;

public class LoginDAOImpl implements LoginDAO {
	
	private static LoginDAO loginDao;
	
	private LoginDAOImpl() {
		
	}
	
	public static LoginDAO getInstance() {
		if(loginDao == null) {
			loginDao = new LoginDAOImpl();
		}
		return loginDao;
	}

	@Override
	public MemberVO login(SqlMapClient smc, MemberVO memberVO) throws SQLException {
		
		MemberVO result = (MemberVO) smc.queryForObject("login.memberLogin", memberVO);

		return result;
	}

	@Override
	public AdminVO adminLogin(SqlMapClient smc, AdminVO adminVO) throws SQLException {
		
		AdminVO result = (AdminVO) smc.queryForObject("login.adminLogin", adminVO);

		return result;
				
	}
	
}
