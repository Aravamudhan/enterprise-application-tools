package com.amudhan.springcore.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

	@Override
	public void onApplicationEvent(BlackListEvent event) {
		System.out.println("The mail id is in black list "+event);
	}

	@EventListener
	@Order(2)
	public void blackListEventPublisher(BlackListEvent event){
		System.out.println("The blacklist event listener annotation");
	}
	@EventListener(condition="#event.address=='test2@mail.com'")
	@Order(1)
	public void anotherBlackListEventPublisher(BlackListEvent event){
		System.out.println("Another blacklist event listener annotation");
	}
}
