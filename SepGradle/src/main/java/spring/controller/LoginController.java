package spring.controller;

import javax.validation.Valid;

import spring.service.AuthenticationException;
import spring.service.Authenticator;
import spring.service.LoginCommand;
import spring.validator.LoginCommandValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/login/login.do")
public class LoginController {

	private String formViewName = "login/form";
	
	@Autowired
	private Authenticator authenticator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(){
		return formViewName;
	}
	
	@ModelAttribute
	public LoginCommand formBacking(){
		return new LoginCommand();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@Valid LoginCommand loginCommand, BindingResult result){
		//@Valid : compile group: 'javax.validation', name: 'validation-api', version: '1.1.0.Final' 추가필요(buildGradle)
		//@Valid : parameter값을 저장한 loginCommand와 result를 가지고 validate()호출해서 유효성 검사
		if(result.hasFieldErrors()){
			return formViewName;
		}
		try{
			authenticator.authenticate(loginCommand);
			return "redirect:/index.jsp";
		} catch(AuthenticationException e){
			result.reject("invalidIdOrPassword", new Object[] {loginCommand.getUserId() }, null);
			return formViewName;
		}
	}
	
	@InitBinder //초기화시 실행
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new LoginCommandValidator());
		//LoginCommandValidator() : 기본 validator객체 
	}

	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}
	
	
}
