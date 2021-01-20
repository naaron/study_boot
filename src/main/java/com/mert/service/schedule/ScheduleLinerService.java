package com.mert.service.schedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mert.model.schedule.common.LinerCode;
import com.mert.repository.schedule.JdbcScheduleLinerRepository;

@Service("ScheduleLinerService")
public class ScheduleLinerService {
	@Autowired
	private JdbcScheduleLinerRepository jdbcscheduleLinerRepository;
	
	public ScheduleLinerService(JdbcScheduleLinerRepository jdbcscheduleLinerRepository) {
		 this.jdbcscheduleLinerRepository = jdbcscheduleLinerRepository;
	}
	
	
	
	  public List<LinerCode> findSchedule(LinerCode linercode) {
	        List<LinerCode> scheduleLiner = new ArrayList<>();
	        scheduleLiner = jdbcscheduleLinerRepository.findByLinerSchedule(linercode);
	        return scheduleLiner;
	    }

}
