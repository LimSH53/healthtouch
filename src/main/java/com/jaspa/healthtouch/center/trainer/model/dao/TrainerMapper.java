package com.jaspa.healthtouch.center.trainer.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.center.trainer.model.dto.AttendanceDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.HolidayDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.TrainerInfoDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.TrainerSalaryDTO;
import com.jaspa.healthtouch.common.paging.Criteria;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;

@Mapper
public interface TrainerMapper {
 
	int selectAllTrainerTotalCount(TrainerInfoDTO params);

	List<TrainerInfoDTO> selectAllTrainer(TrainerInfoDTO params);	

	TrainerInfoDTO detailTrainerById(String trId);


	void deleteTrainer(String id);


	void deleteTrainerMStatus(String id);


	List<TrainerSalaryDTO> selectAllSalary();


	List<AttendanceDTO> selectAllAttendance();

	int selectAllHolidayTotalCount(HolidayDTO params);

	List<HolidayDTO> selectAllHodlidayRequest(HolidayDTO params);

	void approvalHoliday(String id);

	


	



	

}
