package com.jaspa.healthtouch.trainer.classInfo.model.service;

import java.util.List;

import com.jaspa.healthtouch.member.classInfo.model.dto.ClassDTO;

public interface TrainerClassInfoService {

	List<ClassDTO> findAllClass(ClassDTO params);

	List<ClassDTO> getDetail(int no);

	int registClassInfo(String rsvNo, String content, String id);

	int modifyClassInfo(String no, String content);

}
