package spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.Address;
import spring.model.MemberInfo;
import spring.validator.MemberInfoValidator;

@Controller
@RequestMapping("/account/create.do")
public class CreateAccountController {

	@ModelAttribute("command")
	public MemberInfo formBacking(HttpServletRequest request){
		if(request.getMethod().equalsIgnoreCase("GET")){
			//GET������� ���������� ����
			MemberInfo mi = new MemberInfo();
			Address address = new Address();
			address.setZipcode(autoDetectZipcode(request.getRemoteAddr()));
			//request.getRemoteAddr() : ������ Ŭ���̾�Ʈ��  ip�� ������ (�̿����)
			mi.setAddress(address);
			return mi;
		} else{
			//POST��� �� �� 
			return new MemberInfo();
		}
	}
	
	private String autoDetectZipcode(String remoteAddr){
		return "000-000";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(){
		return "account/creationForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command")MemberInfo memberInfo,BindingResult result){
		//�̸� ��������ִ� ��ü ���� ( command��� �̸��� ��ü�� �����ϱ� ������ ) 
		
		new MemberInfoValidator().validate(memberInfo,result);
		if(result.hasErrors()){
			return "account/creationForm";
		}
		return "account/created";
	}
	
}
