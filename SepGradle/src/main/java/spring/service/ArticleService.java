package spring.service;

public class ArticleService {
	
	//�𵨿� ����Ǿ����� �ܼ�â���� Ȯ��
	public void writeArticle(NewArticleCommand command){
		System.out.println("�ű� �Խñ� ��� :" + command);
	}
}
