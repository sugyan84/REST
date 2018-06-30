package com.webservice.resources;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webservice.modal.Message;
import com.webservice.services.MessageService;

@Component
@Path("/messages")
public class MessageResource {

	@Autowired
	private MessageService msgService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Message> getMessages() {
		return msgService.getAllMessages();
	}
	
	
	@GET
	@Path("{msgId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("msgId") int id) {
		return msgService.getMessage(id);
	}
	

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addMessage(Message msg) {
		 msgService.addMessage(msg);
	}
	
	@GET
	@Path("/filter")
	@Produces(MediaType.TEXT_PLAIN)
	public String paginationTest(@QueryParam("mon") String month,
								@QueryParam("year") String yr) {
		 return "Month: "+month+", Year: "+yr;
	}
	
	@GET
	@Path("/context")
	@Produces(MediaType.TEXT_PLAIN)
	public String contextTest(@Context UriInfo uriInfo) {
		 String uri = uriInfo.getAbsolutePath().toString();
		 
		 return "Path is: "+uri;
	}	
	

	@Path("{msgId}/comments")
	public CommentResource getMessageWithComments() {
		return new CommentResource();
	}
	
	@Path("{msgId}/comments/testHello")
	public String getMessageWithCommentsTest() {
		return "Hello";
	}
}
