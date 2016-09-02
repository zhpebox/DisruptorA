package com.testDisruptor.translator2;

/**
 * disruptor2 event
 * @author Administrator
 */
public class Step2Event {
	
	private int id;
	private String name; 
	private String message;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "id = "+id+"; name="+name+"; message="+message+"";
	}
}
