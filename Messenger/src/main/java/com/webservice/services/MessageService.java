package com.webservice.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.webservice.modal.Message;

@Service
public class MessageService {
	
	static Map<Integer, Message> map = new HashMap<>();
	static int highestId=0;
	
	public MessageService()
	{
		
	}
	
	static
	{
		Message m1 = new Message(1, "Msg-1", "Sugyan");
		Message m2 = new Message(2, "Msg-2", "Somesh");
		
		map.put(1, m1);
		map.put(2, m2);
		
		highestId = 3;
		
	}
	public Collection<Message> getAllMessages()
	{
		return map.values();
	}
	
	public Message getMessage(int id)
	{
		if(map.containsKey(id))
		{
			return map.get(id);
		}
		else
			return null;
	}
	
	public void addMessage(Message m)
	{
		m.setId(highestId);
		map.put(highestId++, m);
	}

}
