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
//@RequestMapping이 적용되어있는 메서드 호출전에 메서드에 @ModelAttribute이 먼저 적용됨
//	search/game.do을 실행시키기위해 Controller로 돌아왔을때 다시 @ModelAttribute 적용	
	private SearchService searchService;
	
	@ModelAttribute("searchTypeList")
	//searchTypeList라는 이름으로 리턴값 options를 모델에 저장
	public List<SearchType> referenceSearchTypeList(){
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1,"전체"));
		options.add(new SearchType(2,"아이템"));
		options.add(new SearchType(3,"캐릭터"));
		return options;
	}
	
	@ModelAttribute("popularQueryList")
	public String[] getPopularQueryList(){
		return new String[] {"게임","창천2","위메이드"};
	}
	
	@RequestMapping("/search/main.do")
	public String main(){
		return "search/main";
	}
	
	@RequestMapping("/search/game.do")
	public ModelAndView search(@ModelAttribute("command") SearchCommand command){
		//ModelAndView생성자 첫번째 매개변수는 view name
		ModelAndView mav = new ModelAndView("search/game");
		System.out.println("검색어  =" + command.getQuery().toUpperCase());
		SearchResult result = searchService.search(command);
		mav.addObject("searchResult", result);
		return mav;
	//	모델데이터 "command" / "searchTypeList" / "popularQueryList" / "searchResult" 
		}
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException ex){
		return "error/nullException";
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
	
	
}
