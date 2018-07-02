package com.webservice.filterBean;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

public class ContextFilterBean {

	@Context UriInfo uriInfo;
	@Context Request httpRequest;
	@QueryParam("trial") String trial;
	String uri;
	
	public String getURI()
	{
		if(uri==null)
		{
			String completeURL = uriInfo.getRequestUri().toString();
			
			String baseURI = uriInfo.getBaseUri().toString();
			
			String finalStr = completeURL.substring(baseURI.length()-1);
			
			this.uri = finalStr;
		}
		
		
		return uri;
	}
	
	public String getHttpMethod()
	{
		return httpRequest.getMethod();
	}
	
	public String getQuery()
	{
		return trial;
	}
}
