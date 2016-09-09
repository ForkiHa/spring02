package spring.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import spring.model.Item;

public class SaveDAO extends SqlSessionDaoSupport {
	SqlSession session;

	public void setSession(SqlSession session) {

	this.session = session;
	}
	public int insert(Item item){
		int x=0;
		
		x=getSqlSession().insert("myMap.insert", item);
		return x;
		
	}
	
}