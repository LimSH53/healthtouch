package com.jaspa.healthtouch.center.trainer.model.service;

import java.util.List;

import com.jaspa.healthtouch.center.trainer.model.dto.AttendanceDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.HolidayDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.TrainerInfoDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.TrainerSalaryDTO;
import com.jaspa.healthtouch.common.paging.Criteria;

public interface TrManagementService {

	List<TrainerInfoDTO> selectAllTrainer(TrainerInfoDTO params);

	TrainerInfoDTO trainerDetail(String trId);

	void deleteTrainer(String id);

	List<TrainerSalaryDTO> selectAllSalary();

	List<HolidayDTO> selectAllHdayRequest(HolidayDTO params);

	List<AttendanceDTO> selectAllAttendanceList();

	void approvalHoliday(String id);

	void rejectHoliday(String id);

	List<HolidayDTO> holidayCalendar();

	List<HolidayDTO> findAllHoliday();




	



	

	

  
} 
