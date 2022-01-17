package com.kh.spring.demo.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.spring.demo.model.vo.Dev;

public interface DemoDao {

	int insertDev(Dev dev);

	List<Dev> selectDevList();

}
