package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import dao.MemberDAO;
import vo.MemberVO;
import vo.PagingVO;

public class MemberDAOImpl implements MemberDAO{
	
	private static MemberDAO memberDAO;
	public MemberDAOImpl() {}
	
	public static MemberDAO getInstance() {
		if(memberDAO == null) {
			memberDAO = new MemberDAOImpl();
		}
		return memberDAO;	
	}

	@Override
	public int insertMember(SqlMapClient smc, MemberVO vo) throws SQLException {
		
		int cnt = 0;
		Object obj = smc.insert("member.insertMember",vo);
		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public List<MemberVO> memberAllSelect(SqlMapClient smc, PagingVO pv) throws SQLException {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		memberList = smc.queryForList("member.memberAllSelect", pv);
		return memberList;
	}

	@Override
	public int memberAllSelectCount(SqlMapClient smc) throws SQLException {
		int resCnt = (int)smc.queryForObject("member.memberAllSelectCount");
		return resCnt;
	}

	@Override
	public List<MemberVO> memberSelect(SqlMapClient smc, MemberVO mv) throws SQLException {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		memberList = smc.queryForList("member.memberSelect", mv);
		return memberList;
	}

	@Override
	public List<MemberVO> getMember(SqlMapClient smc) throws SQLException {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		list = smc.queryForList("member.getMember");
		return list;
	}

	@Override
	public int memberUpdate(SqlMapClient smc, MemberVO mv) throws SQLException {
		int resCnt = (int)smc.update("member.memberUpdate", mv);
		return resCnt;
	}

	@Override
	public int memberDelete(SqlMapClient smc, String memberId) throws SQLException {
		int resCnt = smc.update("member.memberDelete", memberId);
		return resCnt;
	}

	@Override
	public int memberForgive(SqlMapClient smc, String memberId) throws SQLException {
		int resCnt = smc.update("member.memberForgive", memberId);
		return resCnt;
	}
	
}