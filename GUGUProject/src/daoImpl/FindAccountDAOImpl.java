package daoImpl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.FindAccountDAO;
import vo.MemberVO;

public class FindAccountDAOImpl implements FindAccountDAO {

	private static FindAccountDAO findAccountDAO;
	
	public static FindAccountDAO getInstance() {
		if(findAccountDAO == null) {
			findAccountDAO = new FindAccountDAOImpl();
		}
		return findAccountDAO;
	}

	@Override
	public int findPwInputId(SqlMapClient smc, String memberId) throws SQLException {
		
		MemberVO memberVO = (MemberVO) smc.queryForObject("findAccount.findPwInputId", memberId);
		
		int cnt = 0;
		if(memberVO != null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public MemberVO findPwInputEmail(SqlMapClient smc, String memberEmail) throws SQLException {
		
		MemberVO result = (MemberVO) smc.queryForObject("findAccount.findPwInputEmail", memberEmail);
		
		return result;
	}

	@Override
	public MemberVO findId(SqlMapClient smc, MemberVO memberVO) throws SQLException {
		
		MemberVO result = (MemberVO) smc.queryForObject("findAccount.findId", memberVO);
		
		return result;
	}

	

}
