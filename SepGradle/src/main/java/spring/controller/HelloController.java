package spring.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	//Controller�� Ŭ�����ȿ��� @RequestMapping���� ���� 
	//HandlerMapping�� property ����? hello.do
	/*Controller�� ���� hello()����*/
	
	@RequestMapping("/hello.do")
	public ModelAndView hello(){
		ModelAndView mav = new ModelAndView();
		//view���� ����
		mav.setViewName("hello");
		mav.addObject("greeting", getGreeting());
		//model���� key�� value�� ¦�� ���� ����
		return mav;
	}
	
	private String getGreeting(){
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		//HOUR_OF_DAY : 0�ú��� 23��
		if(hour >=6 && hour <=10){
			return "���� ��ħ�Դϴ�.";
		} else if( hour >=12 && hour <=15){
			return "���� �ð��̿���~";
		} else if(hour >=18 && hour <=22){
			return "���� �� �Ǽ���";
		}
		return "�ȳ��ϼ���";
	}
}
