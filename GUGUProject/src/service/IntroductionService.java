package service;

import java.util.List;

import vo.IntroductionVO;
import vo.MemberPagingVO;
import vo.PagingVO;

public interface IntroductionService {

	int introductionAllSelectCount();

	List<IntroductionVO> introductionAllSelect(PagingVO pageVO);

	IntroductionVO getIntoduction(String introductionCode);

	int insert(IntroductionVO introductionVO);

	int update(IntroductionVO introductionVO);

	int delete(String introductionCode);

	int memberIntroductionAllSelectCount(String memberId);

	List<IntroductionVO> memberIntroductionAllSelect(MemberPagingVO memberPageVO);

}
