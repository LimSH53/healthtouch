package com.jaspa.healthtouch.login.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberDTO {
	private String id;
	private String pwd;
	private String name;
	private int contact;
	private int num;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private int age;
	private String gender;
	private String address;
	private String type;
	private String status;
	
	private MemberRoleDTO memberRole;
}
