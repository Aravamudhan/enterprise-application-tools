package com.amudhan.springcore.events;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements ApplicationEventPublisherAware {

	@Resource
	private List<String> blackList;
    private ApplicationEventPublisher publisher;
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
	public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }
	public void sendEmail(String address, String text) {
        if (blackList.contains(address)) {
            BlackListEvent event = new BlackListEvent(this, address, text);
            publisher.publishEvent(event);
            return;
        }
        System.out.println("Email sent to "+address);
    }

	

}
