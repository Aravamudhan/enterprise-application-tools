package com.amudhan.springcore.events;

public class DisplayEvent {
	private String event;

	
	public String getEvent() {
		return event;
	}

	@Override
	public String toString() {
		return "DisplayEvent [event=" + event + "]";
	}

	public DisplayEvent(String event) {
		super();
		this.event = event;
	}
}
