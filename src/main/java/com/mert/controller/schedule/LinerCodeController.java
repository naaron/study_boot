package com.mert.controller.schedule;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mert.model.schedule.common.LinerCode;
import com.mert.service.schedule.ScheduleLinerService;

@RestController
@RequestMapping("/api/schedule")
public class LinerCodeController {
	
	private ScheduleLinerService scheduleLinerService;
	public LinerCodeController(ScheduleLinerService scheduleLinerService) {
		this.scheduleLinerService = scheduleLinerService;
	}

	@RequestMapping(value = "/liner", method = RequestMethod.GET)
	@ResponseBody
	  public List<LinerCode> findSeheduleCommon(LinerCode linercode) {
		 
		 System.out.println(linercode.getLinerCode());
		 List<LinerCode> liner_schedule  = scheduleLinerService.findSchedule(linercode);
		 System.out.println("user/me 실행");
		 System.out.println(liner_schedule.get(0));
		 return liner_schedule;
	    
	  }
}




