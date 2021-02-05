package com.mert.controller.schedule;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mert.model.User;
import com.mert.model.schedule.CalendarDTO;
import com.mert.model.schedule.LinerSchedule;
import com.mert.model.schedule.common.CommonCode;
import com.mert.service.RoleService;
import com.mert.service.UserService;
import com.mert.service.schedule.ScheduleService;


@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
	private static Logger logger = Logger.getLogger(ComCodeController.class);
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
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
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView allUsers() {
		System.out.println("all실행");
		ModelAndView modelAndView = new ModelAndView();
		//POINT=7 http://stackoverflow.com/questions/22364886/neither-bindingresult-nor-plain-target-object-for-bean-available-as-request-attr
		modelAndView.addObject("users", userService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getUser().getRole().getRole());
		modelAndView.setViewName("calendar");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	@ResponseBody
	  public List<CalendarDTO>  searchCalendar(CommonCode commonCode) {
		 LinerSchedule linerSchedule = null;
	
		 List<LinerSchedule> schedule  = scheduleService.findSchedule(linerSchedule);
		 logger.info(schedule.get(0).getLinercode());
		
		 List<CalendarDTO> events = new ArrayList<CalendarDTO>();
		logger.info(commonCode.getCountryCode() + "---------------log");
	
		 CalendarDTO event = new CalendarDTO("TEST","2021-02-23","2021-02-23","time");
		              events.add(event);
	                 event = new CalendarDTO("TEST2","2021-02-23","2021-02-23","time");
	                 events.add(event);
	                 event = new CalendarDTO("TEST2","2021-02-13","2021-02-13","time");
	                 events.add(event);
      
	       return events;
	  }
	
	private User getUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		return user;
	}
}




