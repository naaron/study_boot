package com.mert.repository.schedule;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mert.model.schedule.common.CommonCode;

@Repository
public class JdbcScheduleComRepository implements ScheduleComRepository{
	
	private final JdbcTemplate jdbcTemplate;

	  public JdbcScheduleComRepository(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	  }
	
	  @Override
	  public List<CommonCode> findBySchedule(CommonCode commoncode) {
	    // TODO 이름 프로퍼티 처리
	    return jdbcTemplate.query("select * from common_code where country_code = ?",
	      new Object[]{commoncode.getCountryCode()},
	      (rs, rowNum) -> new CommonCode(
	    		  rs.getString("country_code"),
	    		  rs.getString("port_codE")
	      )
	    );
	  }

}
