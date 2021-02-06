package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import vo.IntroductionVO;
import vo.MemberPagingVO;
import vo.PagingVO;

public interface IntroductionDAO {

	int introductionAllSelectCount(SqlMapClient smc) throws SQLException;

	List<IntroductionVO> introductionSelect(SqlMapClient smc, PagingVO pageVO) throws SQLException;

	IntroductionVO getIntroduction(SqlMapClient smc, String introductionCode) throws SQLException;

	int insert(SqlMapClient smc, IntroductionVO introductionVO) throws SQLException;

	int update(SqlMapClient smc, IntroductionVO introductionVO) throws SQLException;

	int delete(SqlMapClient smc, String introductionCode) throws SQLException;

	int memberIntroductionAllSelectCount(SqlMapClient smc, String memberId) throws SQLException;

	List<IntroductionVO> memberIntroductionSelect(SqlMapClient smc, MemberPagingVO memberPageVO) throws SQLException;

}
