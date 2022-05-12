package com.jaspa.healthtouch.trainer.classInfo.model.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.common.paging.PaginationInfo;
import com.jaspa.healthtouch.member.classInfo.model.dto.ClassDTO;
import com.jaspa.healthtouch.trainer.classInfo.model.dao.TrainerClassInfoMapper;

@Service("trainerClassInfoService")
public class TrainerClassInfoServiceImpl implements TrainerClassInfoService {
	private final TrainerClassInfoMapper trainerClassInfoMapper;
	
	@Autowired
	public TrainerClassInfoServiceImpl(TrainerClassInfoMapper trainerClassInfoMapper) {
		this.trainerClassInfoMapper = trainerClassInfoMapper;
	}

	@Override
	public List<ClassDTO> findAllClass(ClassDTO params) {
		List<ClassDTO> classList = Collections.emptyList();
		
		int classTotalCount = trainerClassInfoMapper.findAllClassTotalCount(params);
		
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(classTotalCount);
		
		params.setPaginationInfo(paginationInfo);
		
		if(classTotalCount > 0) {
			classList = trainerClassInfoMapper.findAllClass(params);
		}
		
		return classList;
	}

	@Override
	public List<ClassDTO> getDetail(int no) {
		List<ClassDTO> list = trainerClassInfoMapper.getDetail(no);
		
		return list;
	}

	@Transactional
	@Override
	public int registClassInfo(String rsvNo, String content, String id) {
		return trainerClassInfoMapper.registClassInfo(rsvNo, content, id);
	}

	@Override
	public int modifyClassInfo(String no, String content) {
		return trainerClassInfoMapper.modifyClassInfo(no, content);
	}
}
