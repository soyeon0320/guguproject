package vo;

public class MemberPagingVO {
	private String memberId; // 아이디
	private int pageCount = 10; // 페이지 목록 게시되는 페이지 수 (초기값: 10)
	private int countPerPage = 10; // 한 페이지당 게시되는 게시물 건 수(초기값: 10)
	private int currentPageNo; // 현재 페이지 번호
	private int totalCount; // 전체 게시물 건 수

	private int totalPageCount; // 전체 페이지 수
	private int firstPageNo; // 현재 페이지 목록의 첫 페이지 번호
	private int lastPageNo; // 현재 페이지 목록의 마지막 페이지 번호
	private int firstRectNo; // 첫번째 레코드 번호
	private int lastRectNo;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	// 전체 페이지 수
	public int getTotalPageCount() {
		totalPageCount = ((getTotalCount() - 1) / getCountPerPage()) + 1;
		return totalPageCount;
	}

	// 시작페이지 번호
	public int getFirstPageNo() {
		firstPageNo = ((getCurrentPageNo() - 1) / getPageSize()) * getPageSize() + 1;
		return firstPageNo;
	}

	// 마지막 페이지 번호
	public int getLastPageNo() {
		lastPageNo = getFirstPageNo() + getPageSize() - 1;
		if (lastPageNo > getTotalPageCount()) {
			lastPageNo = getTotalPageCount();
		}
		return lastPageNo;
	}

	// 첫번째 레코드 번호
	public int getFirstRectNo() {
		firstRectNo = (getCurrentPageNo() - 1) * getCountPerPage() + 1;
		return firstRectNo;
	}

	// 마지막 레코드 번호
	public int getLastRectNo() {
		lastRectNo = getCurrentPageNo() * getCountPerPage();
		return lastRectNo;
	}
	
    public int getPageSize() {
        return pageCount;
    }

    public void setPageSize(int pageSize) {
        this.pageCount = pageSize;
    }

	@Override
	public String toString() {
		return "MemberPagingVO [memberId=" + memberId + ", pageCount=" + pageCount + ", countPerPage=" + countPerPage
				+ ", currentPageNo=" + currentPageNo + ", totalCount=" + totalCount + ", totalPageCount="
				+ totalPageCount + ", firstPageNo=" + firstPageNo + ", lastPageNo=" + lastPageNo + ", firstRectNo="
				+ firstRectNo + ", lastRectNo=" + lastRectNo + "]";
	}

}
