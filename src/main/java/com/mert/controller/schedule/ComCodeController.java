package com.mert.controller.schedule;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mert.model.schedule.common.CommonCode;
import com.mert.service.schedule.ScheduleComService;

@RestController
@RequestMapping("/api/schedulecommon")
public class ComCodeController {
	
	private ScheduleComService scheduleCommonService;
	public ComCodeController(ScheduleComService scheduleCommonService) {
		this.scheduleCommonService= scheduleCommonService;
	}
	
	@RequestMapping(value = "/common", method = RequestMethod.GET)
	@ResponseBody
	  public List<CommonCode> findSeheduleCommon(CommonCode commonCode) {
		 
		 System.out.println(commonCode.getCountryCode());
		 List<CommonCode> common_schedule  = scheduleCommonService.findSchedule(commonCode);
		 System.out.println("user/me 실행");
		 System.out.println(common_schedule.get(0));
		 return common_schedule;
	    
	  }

}
