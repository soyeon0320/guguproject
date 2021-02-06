package service;

import java.util.List;

import vo.PagingVO;
import vo.SuccessReviewVO;

public interface SuccessReviewService {

	public int SuccessReviewAllSelectCount();

	List<SuccessReviewVO> SuccessReviewAllSelect(PagingVO pageVO);

	SuccessReviewVO getSuccessReview(String successReviewCode);

	int insert(SuccessReviewVO successReviewVO);

	int update(SuccessReviewVO successReviewVO);

	int delete(String successReviewCode);

}
