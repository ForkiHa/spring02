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
			//GET방식으로 들어왔을때만 실행
			MemberInfo mi = new MemberInfo();
			Address address = new Address();
			address.setZipcode(autoDetectZipcode(request.getRemoteAddr()));
			//request.getRemoteAddr() : 접속한 클라이언트의  ip를 가져옴 (이용안함)
			mi.setAddress(address);
			return mi;
		} else{
			//POST방식 일 때 
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
		//미리 만들어져있던 객체 주입 ( command라는 이름의 객체가 존재하기 때문에 ) 
		
		new MemberInfoValidator().validate(memberInfo,result);
		if(result.hasErrors()){
			return "account/creationForm";
		}
		return "account/created";
	}
	
}
