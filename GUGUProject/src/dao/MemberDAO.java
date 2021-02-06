package dao;

import java.sql.SQLException;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import vo.MemberVO;
import vo.PagingVO;

public interface MemberDAO {
	
	public int insertMember(SqlMapClient smc, MemberVO vo) throws SQLException;
	
	public List<MemberVO> memberAllSelect(SqlMapClient smc, PagingVO pv) throws SQLException;
	
	public int memberAllSelectCount(SqlMapClient smc) throws SQLException;
	
	public List<MemberVO> memberSelect(SqlMapClient smc, MemberVO mv) throws SQLException;
	
	public List<MemberVO> getMember(SqlMapClient smc) throws SQLException;
	
	public int memberUpdate(SqlMapClient smc, MemberVO mv) throws SQLException;
	
	public int memberDelete(SqlMapClient smc, String memberId) throws SQLException;

	public int memberForgive(SqlMapClient smc, String memberId) throws SQLException;
}
