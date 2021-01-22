package com.mert.repository.schedule;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mert.model.schedule.LinerSchedule;
import com.mert.model.schedule.common.LinerCode;

@Repository("JdbcScheduleRepository")
public class JdbcScheduleRepository implements ScheduleRepository{
	private final JdbcTemplate jdbcTemplate;

	  public JdbcScheduleRepository(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	  }
	
	  @Override
	  public List<LinerSchedule> findBySchedule(LinerSchedule linerSchedule) {
	    return jdbcTemplate.query("select * from liner_schedule where pol = ? and pod = ?",
	      new Object[]{linerSchedule.getPol(),linerSchedule.getPod()},
	      (rs, rowNum) -> new LinerSchedule(
	    		  rs.getString("liner_code"),
	    		  rs.getString("vessel_name"),
	    		  rs.getString("pol"),
	    		  rs.getString("pod"),
	    		  rs.getString("ETD"),
	    		  rs.getString("ETA"),
	    		  rs.getString("REMARK")
	      )
	    );
	  }
}
