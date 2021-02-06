package service;

import java.util.List;
import vo.CompanyVO;

public interface CompanyService {
	
	/**
	 * 기업 목록 을 보여주는 메서드
	 * @return 기업 목록을 List로 받아 보여준다.
	 * @author 송 지은
	 */
	public List<CompanyVO> companyList();
	
	/**
	 * 기업 정보 상세보기 메서드
	 * @param vo 해당 되는 값을 받아 DB에서 검색을 한다.
	 * @return code값으로 자료 검색을 한 후, 해당 데이터를 반환한다.
	 * @author 송 지은
	 */
	public List<CompanyVO> select(CompanyVO vo);
	
	/**
	 * 기업 정보 등록 메서드
	 * @param vo 사용자로부터 입력받은 값을 vo에 담아 DB에 저장한다.
	 * @return DB에 등록이 완료되면 1을 반환, 실패하면 0을 반환한다.
	 * @author 송 지은 
	 */
	public int insert(CompanyVO vo);
	
	/**
	 * 기업 정보 수정 메서드
	 * @param vo 사용자로부터 값을 입력받고 해당 되는 code를 검색해서 값을 변경해준다.
	 * @return 수정을 성공하면 1을 반환, 실패하면 0을 반환한다.
	 */
	public int modify(CompanyVO vo);
	
	/**
	 * 기업 정보 삭제 메서드
	 * @param code 코드(PK)를 받아 해당 정보를 찾아 삭제한다.
	 * @return 삭제에 성공하면 1을 반환, 실패하면 0 을 반환한다.
	 */
	public int delete(String code);
}
