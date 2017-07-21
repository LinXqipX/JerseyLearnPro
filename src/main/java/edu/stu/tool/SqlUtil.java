package edu.stu.tool;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlUtil {
	static Reader reader;
	static SqlSessionFactory s;
	
    public static SqlSession createSqlSession() {
    	SqlSession session;
    	
    	try {
    		reader = Resources.getResourceAsReader("Configuration.xml");
    		s = new SqlSessionFactoryBuilder().build(reader);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	session = s.openSession();
    	
    	return session;
    }
}
