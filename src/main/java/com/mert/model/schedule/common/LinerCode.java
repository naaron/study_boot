package com.mert.model.schedule.common;

import com.mert.model.schedule.LinerSchedule;
import com.mert.model.schedule.LinerSchedule.Builder;

public class LinerCode {
	
	private final String linercode;
	private final String orgcode;
	private final String comcode;

	
	public LinerCode(String linercode, String orgcode, String comcode) {
		this.linercode = linercode;
		this.orgcode = orgcode;
		this.comcode = comcode;
	}
	public String  getLinerCode() {
		return linercode;
	}
	public String getOrgCode() {
		return orgcode;
	}
	public String getComCode() {
		return comcode;
	}
	//builder 패턴 적용
	static public class Builder{
		private  String linercode;
		private  String orgcode;
		private  String comcode;
		
		public Builder(LinerCode linercode) {
			this.linercode = linercode.linercode;
			this.orgcode = linercode.orgcode;
			this.comcode = linercode.comcode;
		}
		
		public Builder linercode(String linercode) {
			this.linercode = linercode;
			return this;
		}
		public Builder orgcode(String orgcode) {
			this.orgcode = orgcode;
			return this;
		}
		public Builder comcode(String comcode) {
			this.comcode = comcode;
			return this;
		}
	
		
		public LinerCode build() {
			return new LinerCode(linercode,orgcode,comcode);
		}
	}

}
