package com.jaspa.healthtouch.login.model.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.login.model.dao.MemberMapper;
import com.jaspa.healthtouch.login.model.dto.AuthorityDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.login.model.dto.MemberRoleDTO;
import com.jaspa.healthtouch.login.model.dto.UserImpl;

@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper memberMapper;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public MemberServiceImpl(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
		this.memberMapper = memberMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberDTO member = memberMapper.findMemberById(username);
		
		if(member == null) member = new MemberDTO();
		
		// 리스트는 아니긴 한데 일단 넣어 봅니다...
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if(member != null && member.getMemberRole() != null) {
			MemberRoleDTO role = member.getMemberRole();
			AuthorityDTO authority = role.getAuthority();
			
			if(authority != null) {
				authorities.add(new SimpleGrantedAuthority(authority.getName()));
			}
		}
		
		UserImpl user = new UserImpl(member.getId(), member.getPwd(), authorities);
		user.setDetails(member);
		
		return user;
	}

	@Transactional
	@Override
	public void regist(MemberDTO member) {
		member.setPwd(passwordEncoder.encode(member.getPwd()));
		// 연락처 뒤 4자리가 출석번호 
		member.setNum(member.getContact() % 10000);
		// 만 나이 계산 
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String birthday = dateFormat.format(member.getBirthday());
		String today = dateFormat.format(new Date());
		int birthYear = Integer.parseInt(birthday.substring(0, 4));
		int birthMD = Integer.parseInt(birthday.substring(4, 8));
		int currentYear = Integer.parseInt(today.substring(0, 4));
		int currentMD = Integer.parseInt(birthday.substring(4, 8));
		
		if(birthMD < currentMD) {
			member.setAge(currentYear - birthYear);
		} else {
			member.setAge(currentYear - birthYear - 1);
		}
		
		memberMapper.insertMember(member);
		
		MemberRoleDTO memberRole = new MemberRoleDTO();
		memberRole.setAuthorityCode(1);
		memberRole.setMemberId(member.getId());
		memberMapper.insertMemberRole(memberRole);
	}

	@Override
	public int checkId(String memberId) {
		return memberMapper.checkId(memberId);
	}

}
