package com.mert.controller.schedule;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mert.model.schedule.LinerSchedule;
import com.mert.model.schedule.common.LinerCode;
import com.mert.service.schedule.ScheduleService;


@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
	
	private ScheduleService scheduleService;
	public ScheduleController(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	@ResponseBody
	  public List<LinerSchedule> findSehedule(LinerSchedule linerSchedule) {
		 
		 List<LinerSchedule> schedule  = scheduleService.findSchedule(linerSchedule);
		 return schedule;
	    
	  }
}




