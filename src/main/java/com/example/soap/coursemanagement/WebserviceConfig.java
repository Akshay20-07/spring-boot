package com.example.soap.coursemanagement;


import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//Enables Webservices
@EnableWs
//Spring Configuration
@Configuration
public class WebserviceConfig {
	//MessageDispatcherServlet
		//ApplicationContext
	//url -->/ws/*
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context){
		MessageDispatcherServlet msgDispatcherServlet= new MessageDispatcherServlet();
		msgDispatcherServlet.setApplicationContext(context);
		msgDispatcherServlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean(msgDispatcherServlet,"/ws/*");
	}
	
	// /ws/courses.wsdl
	//PortType -CoursePort
	//NameSpace--http://www.example.org/courses
	//course-details.xsd
	
	@Bean(name="courses")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema courseSchema){
		DefaultWsdl11Definition definition=new DefaultWsdl11Definition();
		definition.setPortTypeName("CoursePort");
		definition.setTargetNamespace("http://www.example.org/courses");
		definition.setLocationUri("/ws");
		definition.setSchema(courseSchema);
		
		
		return definition;
		
	}
	
	@Bean
	public XsdSchema courseSchema(){
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
	}
	
	

}
