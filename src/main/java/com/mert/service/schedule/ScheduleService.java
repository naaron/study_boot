package com.mert.service.schedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mert.model.schedule.LinerSchedule;
import com.mert.model.schedule.common.LinerCode;
import com.mert.repository.schedule.JdbcScheduleRepository;

@Service("ScheduleService")
public class ScheduleService {
	@Autowired
	private JdbcScheduleRepository jdbcscheduleRepository;
	
	public ScheduleService(JdbcScheduleRepository jdbcscheduleRepository) {
		 this.jdbcscheduleRepository = jdbcscheduleRepository;
	}
	
	
	
	  public List<LinerSchedule> findSchedule(LinerSchedule linerSchedule) {
	        List<LinerSchedule> schedule = new ArrayList<>();
	        schedule = jdbcscheduleRepository.findBySchedule(linerSchedule);
	        return schedule;
	    }

}
