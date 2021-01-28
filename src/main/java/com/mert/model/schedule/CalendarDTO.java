package com.mert.model.schedule;

public class CalendarDTO {
	  String title;
	  String start;
	  String end;
	  String category;
	  
	  public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public   CalendarDTO(String title, String start,String end,String category) {
			this.title = title;
			this.start = start;
			this.end = end;
			this.category = category;
		}
	  
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}

}
