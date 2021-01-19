package com.mert.repository.schedule;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mert.model.schedule.common.CommonCode;

@Repository("SchedulecomRepository")
public interface ScheduleComRepository {
	List<CommonCode> findBySchedule(CommonCode commoncode);

}
