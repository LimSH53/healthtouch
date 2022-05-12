package com.jaspa.healthtouch.common.paging;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class PaginationInfo {
	private Criteria criteria;
	private int totalRecordCount;		// 전체 데이터 개수 
	private int totalPageCount;			// 전체 페이지 개수 
	private int firstPage;				// 페이지 리스트의 첫 페이지 번호 
	private int lastPage;				// 페이지 리스트의 마지막 페이지 번호 
	private int firstRecordIndex;		// sql 조건절에 사용되는 첫 rnum
	private int lastRecordIndex;		// sql 조건절에 사용되는 마지막 rnum
	private boolean hasPreviousPage;	// 이전 페이지 존재 여부 
	private boolean hasNextPage;		// 다음 페이지 존재 여부 
	
	public PaginationInfo(Criteria criteria) {
		if(criteria.getCurrentPageNo() < 1) {
			criteria.setCurrentPageNo(1);
		}
		if(criteria.getRecordsPerPage() < 1 || criteria.getRecordsPerPage() > 100) {
			criteria.setRecordsPerPage(10);
		}
		if(criteria.getPageSize() < 5 || criteria.getPageSize() > 20) {
			criteria.setPageSize(5);
		}

		this.criteria = criteria;
	}
	
	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
		
		if(totalRecordCount > 0) {
			calculation();
		}
	}
	
	public void calculation() {
		// 전체 페이지 수 
		totalPageCount = ((totalRecordCount - 1) / criteria.getRecordsPerPage()) + 1;
		if(criteria.getCurrentPageNo() > totalPageCount) {
			criteria.setCurrentPageNo(totalPageCount);
		}
		
		// 페이지 리스트의 첫 페이지 번호 
		firstPage = ((criteria.getCurrentPageNo() - 1) / criteria.getPageSize()) * criteria.getPageSize() + 1;
		
		// 페이지 리스트의 마지막 페이지 번호 
		lastPage = firstPage + criteria.getPageSize() - 1;
		if(lastPage > totalPageCount) {
			lastPage = totalPageCount;
		}
		 
		// sql 조건절에 사용되는 첫 rnum
		firstRecordIndex = (criteria.getCurrentPageNo() - 1) * criteria.getRecordsPerPage();
		
		// sql 조건절에 사용되는 마지막 rnum
		lastRecordIndex = criteria.getCurrentPageNo() * criteria.getRecordsPerPage();
		
		// 이전 페이지 존재 여부 
		hasPreviousPage = firstPage == 1 ? false : true;
		
		// 다음 페이지 존재 여부 
		hasNextPage = (lastPage * criteria.getRecordsPerPage()) >= totalRecordCount ? false : true;
	}

	@Override
	public String toString() {
		return "PaginationInfo [criteria=" + criteria + ", totalRecordCount=" + totalRecordCount + ", totalPageCount="
				+ totalPageCount + ", firstPage=" + firstPage + ", lastPage=" + lastPage + ", firstRecordIndex="
				+ firstRecordIndex + ", lastRecordIndex=" + lastRecordIndex + ", hasPreviousPage=" + hasPreviousPage
				+ ", hasNextPage=" + hasNextPage + "]";
	}
}
