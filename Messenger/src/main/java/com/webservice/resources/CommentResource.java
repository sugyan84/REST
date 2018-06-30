package com.webservice.resources;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webservice.modal.Message;
import com.webservice.services.MessageService;

@Component
@Path("/")
public class CommentResource {

	@Autowired
	private MessageService msgService2;
	
	@GET
	@Path("/test")
	public String getMessages(/*@PathParam("msgId") int id*/) {
		return "Target Hit! ";
	}
	
	
	@GET
	@Path("/testing")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Message> getMessagesTest() {
		return msgService2.getAllMessages();
	}
}
