package spring.service;

public class ArticleService {
	
	//모델에 저장되었음을 콘솔창에서 확인
	public void writeArticle(NewArticleCommand command){
		System.out.println("신규 게시글 등록 :" + command);
	}
}
