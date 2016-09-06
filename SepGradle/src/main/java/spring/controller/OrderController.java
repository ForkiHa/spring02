package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/order.do")
public class OrderController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(){
		return "order/orderForm";
		//return타입이 String이면 viewName
	}
	//링크를 타고 들어오면 get방식
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("order") OrderCommand orderCommand){
		/*1.disputcherServlet이 매개변수를 객체로 만들고 모델에 저장
		2.전송된 파라미터값이 있으면 저장 (400에러 (형변환)-> 전송되는 파라미터 타입 확인) 
		
		order라는 key이름으로 모델에 저장 */
		return "order/orderCompletion";
	}

}
