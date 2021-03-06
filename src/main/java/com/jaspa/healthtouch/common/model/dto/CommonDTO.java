package com.jaspa.healthtouch.common.model.dto;

import com.jaspa.healthtouch.common.paging.Criteria;
import com.jaspa.healthtouch.common.paging.PaginationInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonDTO extends Criteria {
	private PaginationInfo paginationInfo;
}
