package com.jaspa.healthtouch.login.model.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
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
import com.jaspa.healthtouch.login.model.dto.LoginLogDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.login.model.dto.MemberRoleDTO;
import com.jaspa.healthtouch.login.model.dto.UserImpl;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

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
		member.setNum(Integer.parseInt(member.getContact()) % 10000);
		
		// 나이 계산 
		int age = 0;
		
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthDayFormat = new SimpleDateFormat("MMdd");
		
		Date birthday = member.getBirthday();
		Date today = new Date();
		
		int birthdayYear = Integer.parseInt(yearFormat.format(birthday));
		int birthdayMonthDay = Integer.parseInt(monthDayFormat.format(birthday));
		
		int todayYear = Integer.parseInt(yearFormat.format(today));
		int todayMonthDay = Integer.parseInt(monthDayFormat.format(today));
		
		if(birthdayMonthDay < todayMonthDay) {
			age = todayYear - birthdayYear;
		} else {
			age = todayYear - birthdayYear - 1;
		}
		
		member.setAge(age);
		
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

	@Override
	public void certifiedPhoneNumnber(String phoneNumber, String numStr) {
		String api_key = "NCSP5NWYHNBUTMSK";
		String api_secret = "P4TYH6AJIKFQXS7IUSEHXY7TWKE9NIMZ";
		Message coolsms = new Message(api_key, api_secret);
		
		HashMap<String, String> params = new HashMap<>();
		params.put("to", phoneNumber);
		// 테스트용으로 박서영 번호 넣음...
		params.put("from", "010-9961-3357");
		params.put("type", "SMS");
		params.put("text", "헬스터치 연락처 인증 테스트 메시지 : 인증번호는 [" + numStr + "]입니다.");
		params.put("app_version", "test app 1.2");
		
		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch(CoolsmsException e) {
			e.getMessage();
		}
	}

	@Override
	public int isExistContact(String phoneNumber) {
		return memberMapper.isExistContact(phoneNumber);
	}

	@Override
	public String searchId(MemberDTO member) {
		String result = memberMapper.searchId(member);
		
		if(result == "" || result == null) {
			return "fail";
		} else {
			return result;
		}
	}

	@Transactional
	@Override
	public void createLoginLog(LoginLogDTO loginLog) {
		memberMapper.insertLoginLog(loginLog);
	}

	@Override
	public int searchPwd(MemberDTO member) {
		return memberMapper.searchPwd(member);
	}

	@Override
	public void sendTempPwd(MemberDTO member, StringBuffer sb) {
		String api_key = "NCSP5NWYHNBUTMSK";
		String api_secret = "P4TYH6AJIKFQXS7IUSEHXY7TWKE9NIMZ";
		Message coolsms = new Message(api_key, api_secret);
		
		HashMap<String, String> params = new HashMap<>();
		params.put("to", member.getContact());
		// 테스트용으로 박서영 번호 넣음...
		params.put("from", "010-9961-3357");
		params.put("type", "SMS");
		params.put("text", "헬스터치 비밀번호 찾기 테스트 메시지 : 임시 비밀번호는 [" + sb + "]입니다.");
		params.put("app_version", "test app 1.2");
		
		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch(CoolsmsException e) {
			e.getMessage();
		}
	}

	@Transactional
	@Override
	public void setTempPwd(MemberDTO member, StringBuffer sb) {
		member.setPwd(passwordEncoder.encode(sb));
		memberMapper.modifyPwd(member);
	}

}
