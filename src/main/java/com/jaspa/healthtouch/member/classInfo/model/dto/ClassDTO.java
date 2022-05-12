package com.jaspa.healthtouch.member.classInfo.model.dto;

import com.jaspa.healthtouch.common.model.dto.CommonDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassDTO extends CommonDTO {
	private int no;
	private String content;
	private int rsvNo;
	private String memberId;

	private ReservationDTO reservation;
	private MemberDTO member;
	
	@Override
	public String toString() {
		return "ClassDTO [no=" + no + ", content=" + content + ", rsvNo=" + rsvNo + ", memberId=" + memberId
				+ ", reservation=" + reservation + ", member=" + member + "]";
	}
}
