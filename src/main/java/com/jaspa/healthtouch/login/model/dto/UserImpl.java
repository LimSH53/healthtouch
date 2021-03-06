package com.jaspa.healthtouch.login.model.dto;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.jaspa.healthtouch.member.product.model.dto.OrderDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserImpl extends User {
	private String id;
	private String pwd;
	private String name;
	private String contact;
	private int num;
	private Date birthday;
	private int age;
	private String gender;
	private String address;
	private String status;
	
	private MemberRoleDTO memberRole;
	private List<OrderDTO> orderList;
	
	public UserImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public void setDetails(MemberDTO member) {
		this.id = member.getId();
		this.pwd = member.getPwd();
		this.name = member.getName();
		this.contact = member.getContact();
		this.num = member.getNum();
		this.birthday = member.getBirthday();
		this.age = member.getAge();
		this.gender = member.getGender();
		this.address = member.getAddress();
		this.status = member.getStatus();
		this.memberRole = member.getMemberRole();
	}
	
}
