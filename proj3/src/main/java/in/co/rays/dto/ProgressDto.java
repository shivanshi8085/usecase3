package in.co.rays.dto;

import java.util.Date;

public class ProgressDto {
	
	private int id;
	private String name;
	private String work;
	private Date reportingDate;
	private String target;
	private String lastWeek;
	private String currentWeek;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public Date getReportingDate() {
		return reportingDate;
	}
	public void setReportingDate(Date reportingDate) {
		this.reportingDate = reportingDate;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getLastWeek() {
		return lastWeek;
	}
	public void setLastWeek(String lastWeek) {
		this.lastWeek = lastWeek;
	}
	public String getCurrentWeek() {
		return currentWeek;
	}
	public void setCurrentWeek(String currentWeek) {
		this.currentWeek = currentWeek;
	}
	
	

}
