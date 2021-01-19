package com.mert.service.schedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mert.model.schedule.common.CommonCode;
import com.mert.repository.schedule.JdbcScheduleComRepository;

@Service("ScheduleComService")
public class ScheduleComService {
	@Autowired
	private JdbcScheduleComRepository jdbcscheduleComRepository;
	
	public ScheduleComService(JdbcScheduleComRepository jdbcscheduleComRepository) {
		 this.jdbcscheduleComRepository = jdbcscheduleComRepository;
	}
	
	
	
	  public List<CommonCode> findSchedule(CommonCode commoncode) {
	        List<CommonCode> schedulecommon = new ArrayList<>();
	        schedulecommon = jdbcscheduleComRepository.findBySchedule(commoncode);
	        return schedulecommon;
	    }

}
