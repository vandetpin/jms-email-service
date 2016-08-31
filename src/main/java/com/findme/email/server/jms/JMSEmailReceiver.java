package com.findme.email.server.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findme.domain.Email;
import com.findme.email.service.MailerService;

@Service("jmsEmailReceiver")
public class JMSEmailReceiver implements MessageListener {
	private Logger LOG = Logger.getLogger(JMSEmailReceiver.class);
	
	@Autowired
	private MailerService mailService;
	
    public void onMessage(Message message){
    	ObjectMessage objmessage = (ObjectMessage)message;
    	try {
			Email email = (Email)objmessage.getObject();
			LOG.info(String.format(">>>>> %s receives a message >>>>>>>>", this.getClass().getSimpleName()));
	        LOG.info(String.format("Send email to=%s, subject=%s", email.getToEmail(), email.getSubject()));
	        
	        mailService.sendMail(email.getToEmail(), email.getSubject(), email.getBody());
		} catch (JMSException e) {
			LOG.error(e);
		}
    }
}

