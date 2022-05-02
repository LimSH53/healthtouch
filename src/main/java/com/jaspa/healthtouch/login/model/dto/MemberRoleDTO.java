package com.jaspa.healthtouch.login.model.dto;

import lombok.Data;

@Data
public class MemberRoleDTO {
	private String memberId;
	private int authorityCode;
	
	private AuthorityDTO authority;
}
