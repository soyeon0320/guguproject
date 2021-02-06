package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import vo.PagingVO;
import vo.SuccessReviewVO;

public interface SuccessReviewDAO {

	int successReviewAllSelectCount(SqlMapClient smc) throws SQLException;

	List<SuccessReviewVO> successReviewSelect(SqlMapClient smc, PagingVO pageVO) throws SQLException;

	SuccessReviewVO getSuccessReview(SqlMapClient smc, String successReviewCode) throws SQLException;

	int insert(SqlMapClient smc, SuccessReviewVO successReviewVO) throws SQLException;

	int update(SqlMapClient smc, SuccessReviewVO successReviewVO) throws SQLException;

	int delete(SqlMapClient smc, String successReviewCode) throws SQLException;
	

}
