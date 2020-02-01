package com.example.soap.coursemanagement;

import org.example.courses.CourseDetails;
import org.example.courses.GetCourseDetailsRequest;
import org.example.courses.GetCourseDetailsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CourseDetailsEndpoint {
	
	//input --GetCourseDetailsRequest
	//output---GetCourseDetailsResponse
	
	//namespace---http://www.example.org/courses
	//GetCourseDetailsRequest
	
	@PayloadRoot(namespace="http://www.example.org/courses",localPart="GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processRequest(@RequestPayload GetCourseDetailsRequest req){
		GetCourseDetailsResponse response=new GetCourseDetailsResponse();
		CourseDetails courseDet=new CourseDetails();
		courseDet.setId(req.getId());
		courseDet.setName("Microservices");
		courseDet.setDescription("i dont know");
		response.setCourseDetails(courseDet);
		
		return response;
	}

}
