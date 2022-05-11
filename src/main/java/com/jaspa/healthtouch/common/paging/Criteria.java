package com.jaspa.healthtouch.common.paging;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {
	private int currentPageNo;		// 현재 페이지 번호 
	private int recordsPerPage;		// 페이지 당 출력할 데이터 개수 
	private int pageSize;			// 화면 하단에 출력할 페이지 사이즈 
	private String searchKeyword;	// 검색 키워드 
	private String searchType;		// 검색 유형 
	
	public Criteria() {
		this.currentPageNo = 1;
		this.recordsPerPage = 10;
		this.pageSize = 5;
	}
	
	public String makeQueryString(int pageNo) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
										.queryParam("currentPageNo", pageNo)
										.queryParam("recordsPerPage", recordsPerPage)
										.queryParam("pageSize", pageSize)
										.queryParam("searchType", searchType)
										.queryParam("searchKeyword", searchKeyword)
										.build()
										.encode();
		
		return uriComponents.toUriString();
	}

	@Override
	public String toString() {
		return "Criteria [currentPageNo=" + currentPageNo + ", recordsPerPage=" + recordsPerPage + ", pageSize="
				+ pageSize + ", searchKeyword=" + searchKeyword + ", searchType=" + searchType + "]";
	}
}
