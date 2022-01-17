package com.kh.common;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {

	/**
	 * SqlSessionFactoryBuilder(mybatis-config.xml) - SqlSessionFactory - SqlSession
	 * 
	 * @return
	 */
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		String configLocation = "/mybatis-config.xml";
		try {
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(Resources.getResourceAsStream(configLocation));
			session = factory.openSession(false); // autoCommit 트랜잭션관리는 직접한다.
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
