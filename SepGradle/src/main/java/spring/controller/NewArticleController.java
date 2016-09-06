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
	
	//@RequestMapping �޼����� ���� Ÿ���� String => return���� viewname���� ���
	//@RequestMapping�� value���� ���ٸ� Controller�� ��ϵ� �⺻ url�� �̵�
	@RequestMapping(method=RequestMethod.GET)
	public String form(){
		return "article/newArticleForm";
	}
	//���� �����Ƿ� �信 ���������� ����
	
	/*@RequestMapping �޼����� �Ű������� ���޵� ��ü�� Model �����ͷ� view�� ���޵ȴ�.
	�̶� key�� Ÿ�Ը�(ù���� �ҹ���)�� Ű�̸����� ����Ѵ�.
	public String submit(NewArticleCommand command){
	key �̸� newArticleCommand */
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") NewArticleCommand command){
	/* �Ű������� �޾ƿ��� dispatcher-servlet�� �˾Ƽ� ��ü����� ������ �Ķ���Ͱ��� ������ �̸��� ���缭 ���� (setter�� ����)
		�𵨿� command��� �̸����� command��ü ���� */ 
	//@ModelAttribute("command") : ���� �������߰��� key �̸��� �����ϴ� �ֳ����̼�	
		articleService.writeArticle(command);
		return "article/newArticleSubmit";
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	
}
