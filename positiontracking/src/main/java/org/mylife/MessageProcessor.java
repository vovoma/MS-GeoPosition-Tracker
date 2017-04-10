package org.mylife;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

// Message driven POJO, connects to ActiveMQ
// A spring bean
@Component
public class MessageProcessor {
	
	@Autowired
	private Data data;
	
	/*
	 This method responds to one message being received to QUEUE
	 We are getting MAP message. Destination is hard coded, not good in Microservice
	 Spring will convert to Java Map like a Hashmap
	 It consumes the data from QUEUE nd update the Hash MAP
	 * */
	 
	@JmsListener(destination="positionQueue")
	public void processPositionMessageFromQueue(Map<String, String> incomingMessage ) 
	{
		data.updatePosition(incomingMessage);
		//System.out.println("received message " + incomingMessage);
	}

}
