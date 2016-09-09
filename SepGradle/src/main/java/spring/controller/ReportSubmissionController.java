package spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.model.Item;
import spring.mybatis.SaveDAO;

@Controller
public class ReportSubmissionController {
	
	@Autowired
	private SaveDAO sd; 
	
	public void setSd(SaveDAO sd) {
		this.sd = sd;
	}

	public void upload(MultipartFile report)throws IOException,IllegalStateException{
		Long currentTime=System.currentTimeMillis();
		Random r=new Random();
		int i=r.nextInt(50);
		File file=new File("e://file/"+i+currentTime+report.getOriginalFilename());
		report.transferTo(file);	
		Item it=new Item();
		it.setFilename(report.getOriginalFilename());
		it.setFilePath(file.getPath());
		it.setFileSize((int) report.getSize());		
		System.out.println(it.getFilename()+it.getFilePath()+it.getFileSize());
		int x=sd.insert(it);
		System.out.println(x);
	
		
		
	}

	@RequestMapping(value = "/report/submission.do",method=RequestMethod.GET)
	public String form(){
		return "report/submissionForm";
	}
	
	@RequestMapping(value = "report/submitReport1.do", method=RequestMethod.POST)
	public String submitReport1(@RequestParam("studentNumber") String studentNumber, 
			@RequestParam("report") MultipartFile report) throws IllegalStateException, IOException{
		printInfo(studentNumber, report);
		upload(report);
		return "report/submissionComplete";
	} 
	
	private void printInfo(String studentNumber, MultipartFile report){
		System.out.println(studentNumber + "가 업로드 한 파일 :" + report.getOriginalFilename());
	}//파일에 입력한 값과 실제 파일명을 가져오는 메서드 이다
	
	@RequestMapping(value = "/report/submitReport2.do",method = RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request) throws IllegalStateException, IOException{
		String studentNumber = request.getParameter("studentNumber"); // 파라미터를 사용해서 이름 가져온다~~
		MultipartFile report = request.getFile("report"); //getfile로 멀티파트 파일로 받아와서 여러개라면 getfiles사용 
		printInfo(studentNumber, report);
		upload(report);
		
		return "report/submissionComplete";
	}
	
	@RequestMapping(value="/report/submitReport3.do",method=RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand) throws IllegalStateException, IOException{
		printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
		upload(reportCommand.getReport());
		return "report/submissionComplete"; //같은 이름의 파라미터의 변수를 만든다~~
	}
}
