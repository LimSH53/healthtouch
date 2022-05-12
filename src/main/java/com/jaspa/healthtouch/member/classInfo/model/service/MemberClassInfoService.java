package com.jaspa.healthtouch.member.classInfo.model.service;

import java.util.List;

import com.jaspa.healthtouch.member.classInfo.model.dto.ClassDTO;

public interface MemberClassInfoService {

	List<ClassDTO> findAllClass(ClassDTO params);

	List<ClassDTO> getDetail(int no);

}
