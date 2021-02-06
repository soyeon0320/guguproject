package service;

import java.util.List;

import vo.FaqVO;

public interface FaqService {
	
	/**
	 * FAQ 목록을 보여주는 메서드
	 * @author 송 지은
	 */
	public List<FaqVO> faqList();
	
	/**
	 * FAQ 등록을 하는 메서드
	 * @param vo 사용자로부터 메서드를 받아 DB에 저장한다.
	 * @return 등록 성공 시 1 반환, 실패 시 0 반환
	 * @author 송 지은
	 */
	public int InsertFaq(FaqVO vo);
	
	/**
	 * FAQ 정보를 검색하는 메서드
	 * @param vo 사용자로 부터 받은 code값을 받아 정보 검색을 한다.
	 * @return 해당되는 정보를 받아 List로 받아 온다.
	 * @author 송 지은
	 */
	public List<FaqVO> searchCode(FaqVO vo);
	
	/**
	 * FAQ 정보를 수정하는 메서드
	 * @param vo 사용자로 부터 수정된 데이터를 받아 DB에 저장한다.
	 * @return 수정 성공 시 1을 반환, 실패 시 0 반환
	 * @author 송 지은
	 */
	public int update(FaqVO vo);
	
	/**
	 * FAQ 정보를 삭제하는 메서드
	 * @param code 해당 정보의 code를 받아 삭제한다.
	 * @return 삭제 성공 시 1을 반환, 실패 시 0을 반환
	 * @author 송 지은
	 */
	public int delete(String code);
	
}
