package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.service.ArticleService;
import spring.service.NewArticleCommand;

@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {

	@Autowired
	private ArticleService articleService;
	
	//@RequestMapping 메서드의 리턴 타입이 String => return값을 viewname으로 사용
	//@RequestMapping에 value값이 없다면 Controller에 등록된 기본 url로 이동
	@RequestMapping(method=RequestMethod.GET)
	public String form(){
		return "article/newArticleForm";
	}
	//모델이 없으므로 뷰에 보낼정보는 없음
	
	/*@RequestMapping 메서드의 매개변수로 전달된 객체는 Model 데이터로 view에 전달된다.
	이때 key는 타입명(첫글자 소문자)을 키이름으로 사용한다.
	public String submit(NewArticleCommand command){
	key 이름 newArticleCommand */
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") NewArticleCommand command){
	/* 매개변수로 받아오면 dispatcher-servlet이 알아서 객체만들고 전송한 파라미터값이 있으면 이름에 맞춰서 저장 (setter를 통해)
		모델에 command라는 이름으로 command객체 저장 */ 
	//@ModelAttribute("command") : 모델의 데이터추가시 key 이름을 지정하는 애노테이션	
		articleService.writeArticle(command);
		return "article/newArticleSubmit";
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	
}
