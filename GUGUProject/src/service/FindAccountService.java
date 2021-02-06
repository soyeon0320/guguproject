package service;

import vo.MemberVO;

public interface FindAccountService {

	int findPwInputId(String memberId);

	MemberVO findPwInputEmail(String memberEmail);

	MemberVO findId(MemberVO memberVO);
	
}
