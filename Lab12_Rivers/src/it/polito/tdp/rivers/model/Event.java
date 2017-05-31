package it.polito.tdp.rivers.model;

public class Event implements Comparable<Event>{
	
	public enum EventType{IN};
	
	private Flow flow;
	private EventType type;

	
	
	
	
	
	
	public Event(Flow flow, EventType type) {
		super();
		this.flow = flow;
		this.type = type;
	}
	
	







	public Flow getFlow() {
		return flow;
	}









	public void setFlow(Flow flow) {
		this.flow = flow;
	}









	public EventType getType() {
		return type;
	}









	public void setType(EventType type) {
		this.type = type;
	}









	public int compareTo(Event other) {
		if(this.flow.getDay().isAfter(other.getFlow().getDay()))
		    return 1;
		else{
			if(this.flow.getDay().isBefore(other.getFlow().getDay()))
				return -1;
			else
				return 0;
		}
	}
	
	
	

}
