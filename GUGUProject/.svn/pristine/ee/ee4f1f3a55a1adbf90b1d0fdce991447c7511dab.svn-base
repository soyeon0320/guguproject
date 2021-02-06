package service;

import java.util.List;
import vo.MemberVO;
import vo.PagingVO;

public interface MemberService {
	
	/**
	 * 회원 가입 메서드
	 * @param vo 사용자로 부터 값을 받아 DB에 저장한다.
	 * @return 회원 가입 성공 시 1을 반환, 실패 시 0 반환
	 * @author 송 지은
	 */
	public int insertMember(MemberVO vo); 
	
	/**
	 * 회원 가입 시 아이디 체크를 위한 메서드
	 * @return DB에 저장된 ID를 list에 담아 반환 한 다음 member.jsp에서 비교한다.
	 * @author 송 지은
	 */
	public List<MemberVO> getMember();

	//회원 목록
	public List<MemberVO> memberAllSelect(PagingVO pv);
	
	//회원 전체 조회
	public int memberAllSelectCount();
	
	//회원 상세 조회
	public List<MemberVO> memberSelect(MemberVO mv);
	
	
	//회원 수정
	public int memberUpdate(MemberVO mv);
	
	//회원 삭제
	public int memberDelete(String memberId);

	// 회원 탈퇴 여부
	public int memberForgive(String memberId);
	
}
