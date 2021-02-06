package service;

import java.util.List;
import vo.NotisVO;

public interface NotisService {
	
	/**
	 * 공지사항 목록 메서드
	 * @return 공지사항 정보를 list로 반환한다.
	 * @author 송 지은
	 */
	public List<NotisVO> notisList();
	
	/**
	 * 공지사항 등록 메서드
	 * @param vo 사용자로 부터 받은 값을 DB에 저장한다.
	 * @return 등록 성공 시 1 반환, 실패 시 0반환
	 * @author 송 지은
	 */
	public int insert(NotisVO vo);
	
	/**
	 * 공지사항 수정 메서드
	 * @param vo 사용자로 부터 받은 값을 받아 DB에 저장한다.
	 * @return 수정 성공 시 1 반환, 실패 시 0 반환
	 * @author 송 지은
	 */
	public int update(NotisVO vo);
	
	/**
	 * 공지사항 정보 검색 메서드
	 * @param code 검색 할 code(PK)값으로 DB에서 검색을 한다.
	 * @return 검색 된 정보를 list에 담아 반환한다.
	 * @author 송 지은
	 */
	public List<NotisVO> searchCode(String code);
	
	/**
	 * 공지사항 정보 삭제 메서드
	 * @param code 삭제할 정보의 code(PK)를 받아 삭제한다.
	 * @return 삭제 성공 시 1을 반환, 실패 시 0 반환
	 * @author 송 지은
	 */
	public int delete(String code);
}
