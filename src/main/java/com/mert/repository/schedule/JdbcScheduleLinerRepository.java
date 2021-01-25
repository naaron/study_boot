package com.mert.repository.schedule;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mert.model.schedule.common.LinerCode;

@Repository("JdbcScheduleLinerRepository")
public class JdbcScheduleLinerRepository implements ScheduleLinerRepository{
	private final JdbcTemplate jdbcTemplate;

	  public JdbcScheduleLinerRepository(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	  }
	  
	  @Override
	  public List<LinerCode> findByLinerSchedule(LinerCode linercode) {
	    return jdbcTemplate.query("select * from liner_code where liner_code = ?",
	      new Object[]{linercode.getLinerCode()},
	      (rs, rowNum) -> new LinerCode(
	    		  rs.getString("liner_code"),
	    		  rs.getString("org_port_code"),
	    		  rs.getString("com_port_code")
	      )
	    );
	  }
}
