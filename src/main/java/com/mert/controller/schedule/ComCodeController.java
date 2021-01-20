package com.mert.controller.schedule;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mert.model.schedule.common.CommonCode;
import com.mert.service.schedule.ScheduleComService;


@RestController
@RequestMapping("/api/schcom")
public class ComCodeController {
	private static Logger logger = Logger.getLogger(ComCodeController.class);
	
	private ScheduleComService scheduleCommonService;
	public ComCodeController(ScheduleComService scheduleCommonService) {
		this.scheduleCommonService= scheduleCommonService;
	}
	
	@RequestMapping(value = "/common", method = RequestMethod.GET)
	@ResponseBody
	  public List<CommonCode> findSeheduleCommon(CommonCode commonCode) {
		logger.info(commonCode.getCountryCode() + "---------------log");
		 List<CommonCode> common_schedule  = scheduleCommonService.findSchedule(commonCode);

		 return common_schedule;
	    
	  }

}
