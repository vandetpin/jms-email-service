package com.findme.email.server.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class JMSEmailReceiverApp {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		System.out.println("JMS Email service is running ...");
	}

}
