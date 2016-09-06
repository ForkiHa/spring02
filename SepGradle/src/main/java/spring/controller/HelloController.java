package spring.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	//Controller로 클래스안에만 @RequestMapping지정 가능 
	//HandlerMapping에 property 저장? hello.do
	/*Controller에 의해 hello()실행*/
	
	@RequestMapping("/hello.do")
	public ModelAndView hello(){
		ModelAndView mav = new ModelAndView();
		//view정보 저장
		mav.setViewName("hello");
		mav.addObject("greeting", getGreeting());
		//model에는 key와 value를 짝을 지어 저장
		return mav;
	}
	
	private String getGreeting(){
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		//HOUR_OF_DAY : 0시부터 23시
		if(hour >=6 && hour <=10){
			return "좋은 아침입니다.";
		} else if( hour >=12 && hour <=15){
			return "점심 시간이예요~";
		} else if(hour >=18 && hour <=22){
			return "좋은 밤 되세요";
		}
		return "안녕하세요";
	}
}
