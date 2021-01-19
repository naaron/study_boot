package com.mert.model.schedule.common;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

public class CommonCode {

	private final String countrycode;
	private final String portcode;
	
	
	public CommonCode(String countrycode, String portcode) {
		this.countrycode = countrycode;
		this.portcode = portcode;
	}

	public String getCountryCode() {
		return countrycode;
	}
	public String getPortCode() {
		return portcode;
	}
	//builder 패턴 적용
	static public class Builder{
		private  String countrycode;
		private  String portcode;

		public Builder(CommonCode commoncode) {
			this.countrycode = commoncode.countrycode;
			this.portcode = commoncode.portcode;
	
		}
		
		public Builder counrtycode(String countrycode) {
			this.countrycode = countrycode;
			return this;
		}
		public Builder portcode(String portcode) {
			this.portcode = portcode;
			return this;
		}

		
		public CommonCode build() {
			return new CommonCode(countrycode,portcode);
		}
	}
	
}
