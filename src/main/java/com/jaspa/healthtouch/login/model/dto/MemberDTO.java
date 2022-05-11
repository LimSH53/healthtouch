package com.jaspa.healthtouch.login.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.jaspa.healthtouch.common.model.dto.CommonDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO extends CommonDTO {
	private String id;
	private String pwd;
	private String name;
	private String contact;
	private int num;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private int age;
	private String gender;
	private String address;
	private String status;
		
	private MemberRoleDTO memberRole;
}
