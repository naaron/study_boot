package com.mert.repository.schedule;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mert.model.schedule.common.LinerCode;

@Repository("ScheduleLinerRepository")
public interface ScheduleLinerRepository { 
	List<LinerCode> findByLinerSchedule(LinerCode linercode);
}
 