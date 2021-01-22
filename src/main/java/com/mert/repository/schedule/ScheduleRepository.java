package com.mert.repository.schedule;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mert.model.schedule.LinerSchedule;

@Repository("ScheduleRepository")
public interface ScheduleRepository {
	List<LinerSchedule> findBySchedule(LinerSchedule linerSchedule);
}
