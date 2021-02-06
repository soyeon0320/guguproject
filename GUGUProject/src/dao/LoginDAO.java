package dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import vo.AdminVO;
import vo.MemberVO;

public interface LoginDAO {

	MemberVO login(SqlMapClient smc, MemberVO memberVO) throws SQLException;

	AdminVO adminLogin(SqlMapClient smc, AdminVO adminVO) throws SQLException;
	
	
}
