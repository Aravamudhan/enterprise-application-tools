package com.amudhan.springcore.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventListeners {
	@EventListener
	public DisplayEvent blackListEvent(BlackListEvent event){
		System.out.println("EventsListener for  "+event);
		DisplayEvent displayEvent = new DisplayEvent(event.toString());
		return displayEvent;
	}
	@EventListener
	public void displayEventListener(DisplayEvent event){
		System.out.println("Display event triggered for "+event);
	}
}
