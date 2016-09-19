package spring.controller2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.controller2.Authenticator;
import spring.controller2.LoginCommand;

@Controller
@RequestMapping("/login/login")
public class LoginController {
	
	private Authenticator authenticator;
	
	@ModelAttribute("login")
	public LoginCommand formBacking(){
		return new LoginCommand();
	}
	//메서드에 @ModelAttribute - > 리턴값을 value로 ()값을  key값으로 모델에 추가
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(){
		return "loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("login") LoginCommand loginCommand, BindingResult result){
		new LoginCommandValidator().validate(loginCommand, result);
		if(result.hasErrors()){
			return "loginForm";
		}
		try{
			authenticator.authenticate(loginCommand.getId(),loginCommand.getPassword());
			return "loginSuccess";
		} catch(AuthenticationException ex){
			result.reject("invalidIdOrPassword", new Object[]{loginCommand.getId()},null);
			return "loginForm";
		}
	}
	
	@ModelAttribute("loginTypes")
	protected List<String> referenceData() throws Exception{
		List<String> loginTypes = new ArrayList<String>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터회원");
		
		return loginTypes;
	}

	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}
	
	
	

}
