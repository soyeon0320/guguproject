package dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import vo.MemberVO;

public interface FindAccountDAO {

	int findPwInputId(SqlMapClient smc, String memberId) throws SQLException;

	MemberVO findPwInputEmail(SqlMapClient smc, String memberEmail) throws SQLException;

	MemberVO findId(SqlMapClient smc, MemberVO memberVO) throws SQLException;

}
