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
		//returnŸ���� String�̸� viewName
	}
	//��ũ�� Ÿ�� ������ get���
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("order") OrderCommand orderCommand){
		/*1.disputcherServlet�� �Ű������� ��ü�� ����� �𵨿� ����
		2.���۵� �Ķ���Ͱ��� ������ ���� (400���� (����ȯ)-> ���۵Ǵ� �Ķ���� Ÿ�� Ȯ��) 
		
		order��� key�̸����� �𵨿� ���� */
		return "order/orderCompletion";
	}

}
