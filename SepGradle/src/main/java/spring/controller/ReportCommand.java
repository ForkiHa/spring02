package spring.controller;

import org.springframework.web.multipart.MultipartFile;

public class ReportCommand {

	private String studentNumber;
	private MultipartFile report; //file타입의 파라미터는 MultipartFile로 
	
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public MultipartFile getReport() {
		return report;
	}
	public void setReport(MultipartFile report) {
		this.report = report;
	}
	
	
}
