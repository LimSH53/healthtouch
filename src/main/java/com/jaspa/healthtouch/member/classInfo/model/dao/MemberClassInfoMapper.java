package com.jaspa.healthtouch.member.classInfo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.member.classInfo.model.dto.ClassDTO;

@Mapper
public interface MemberClassInfoMapper {

	int findAllClassTotalCount(ClassDTO params);

	List<ClassDTO> findAllClass(ClassDTO params);

	List<ClassDTO> getDetail(int no);

}
