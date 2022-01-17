package com.kh.spring.demo.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DemoDaoImpl implements DemoDao {

	@Autowired
	private SqlSessionTemplate session;
}
