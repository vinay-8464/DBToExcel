package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) throws IOException {
		
		response.setContentType("application/octet-stream");
		String headerKey= "Content-Disposition";
		String headerValue= "attachment;filename=courses.xlsx";
		response.setHeader(headerKey,headerValue);
		
		courseService.generateExcel(response);
		response.flushBuffer();
	}
}
