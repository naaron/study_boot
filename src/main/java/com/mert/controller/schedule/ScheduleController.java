package com.mert.controller.schedule;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mert.model.schedule.CalendarDTO;
import com.mert.model.schedule.LinerSchedule;
import com.mert.model.schedule.common.CommonCode;
import com.mert.service.schedule.ScheduleService;


@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
	private static Logger logger = Logger.getLogger(ComCodeController.class);
	
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
	
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	@ResponseBody
	  public List<CalendarDTO>  searchCalendar(CommonCode commonCode) {
		 LinerSchedule linerSchedule = null;
	
		 List<LinerSchedule> schedule  = scheduleService.findSchedule(linerSchedule);
		 logger.info(schedule.get(0).getLinercode());
		
		 List<CalendarDTO> events = new ArrayList<CalendarDTO>();
		logger.info(commonCode.getCountryCode() + "---------------log");
	
		 CalendarDTO event = new CalendarDTO("TEST","2021-01-23","2021-01-23","time");
		              events.add(event);
	                 event = new CalendarDTO("TEST2","2021-01-23","2021-01-23","time");
	                 events.add(event);
	                 event = new CalendarDTO("TEST2","2021-01-13","2021-01-13","time");
	                 events.add(event);
      
	       return events;
	  }
}




