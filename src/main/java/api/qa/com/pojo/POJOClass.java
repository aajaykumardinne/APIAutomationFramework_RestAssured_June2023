package api.qa.com.pojo;

import java.util.List;

public class POJOClass {
	
	//private class vars
	private String name;
	private String job;
	
	private List<String> jobs;
	
	public List<String> getJobs() {
		return jobs;
	}

	public void setJobs(List<String> jobs) {
		this.jobs = jobs;
	}

	//constructor
	public POJOClass(String name, String job) {
		this.name = name;
		this.job = job;
	}
	
	//getter and setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}


}
