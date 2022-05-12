package com.jaspa.healthtouch.member.classInfo.model.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaspa.healthtouch.common.paging.PaginationInfo;
import com.jaspa.healthtouch.member.classInfo.model.dao.MemberClassInfoMapper;
import com.jaspa.healthtouch.member.classInfo.model.dto.ClassDTO;

@Service("memberClassInfoService")
public class MemberClassInfoServiceImpl implements MemberClassInfoService {
	private final MemberClassInfoMapper memberClassInfoMapper;
	
	@Autowired
	public MemberClassInfoServiceImpl(MemberClassInfoMapper memberClassInfoMapper) {
		this.memberClassInfoMapper = memberClassInfoMapper;
	}

	@Override
	public List<ClassDTO> findAllClass(ClassDTO params) {
		List<ClassDTO> classList = Collections.emptyList();
		
		int classTotalCount = memberClassInfoMapper.findAllClassTotalCount(params);
		
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(classTotalCount);
		
		params.setPaginationInfo(paginationInfo);
		
		if(classTotalCount > 0) {
			classList = memberClassInfoMapper.findAllClass(params);
		}
		
		return classList;
	}

	@Override
	public List<ClassDTO> getDetail(int no) {
		List<ClassDTO> list = memberClassInfoMapper.getDetail(no);
		
		return list;
	}

}
