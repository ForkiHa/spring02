package spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.service.SearchCommand;
import spring.service.SearchResult;
import spring.service.SearchService;
import spring.service.SearchType;

@Controller
public class GameSearchController {
//@RequestMapping�� ����Ǿ��ִ� �޼��� ȣ������ �޼��忡 @ModelAttribute�� ���� �����
//	search/game.do�� �����Ű������ Controller�� ���ƿ����� �ٽ� @ModelAttribute ����	
	private SearchService searchService;
	
	@ModelAttribute("searchTypeList")
	//searchTypeList��� �̸����� ���ϰ� options�� �𵨿� ����
	public List<SearchType> referenceSearchTypeList(){
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1,"��ü"));
		options.add(new SearchType(2,"������"));
		options.add(new SearchType(3,"ĳ����"));
		return options;
	}
	
	@ModelAttribute("popularQueryList")
	public String[] getPopularQueryList(){
		return new String[] {"����","âõ2","�����̵�"};
	}
	
	@RequestMapping("/search/main.do")
	public String main(){
		return "search/main";
	}
	
	@RequestMapping("/search/game.do")
	public ModelAndView search(@ModelAttribute("command") SearchCommand command){
		//ModelAndView������ ù��° �Ű������� view name
		ModelAndView mav = new ModelAndView("search/game");
		System.out.println("�˻���  =" + command.getQuery().toUpperCase());
		SearchResult result = searchService.search(command);
		mav.addObject("searchResult", result);
		return mav;
	//	�𵨵����� "command" / "searchTypeList" / "popularQueryList" / "searchResult" 
		}
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException ex){
		return "error/nullException";
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
	
	
}
