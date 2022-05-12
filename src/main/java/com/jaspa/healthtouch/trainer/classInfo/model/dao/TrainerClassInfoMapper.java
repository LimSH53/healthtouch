package com.jaspa.healthtouch.trainer.classInfo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.member.classInfo.model.dto.ClassDTO;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationDTO;

@Mapper
public interface TrainerClassInfoMapper {

	int findAllClassTotalCount(ClassDTO params);

	List<ClassDTO> findAllClass(ClassDTO params);

	List<ClassDTO> getDetail(int no);

	int registClassInfo(String rsvNo, String content, String id);

	int modifyClassInfo(String no, String content);

}
