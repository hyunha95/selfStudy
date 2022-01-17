package com.kh.spring.demo.model.service;

import java.util.List;
import java.util.Map;

import com.kh.spring.demo.model.vo.Dev;

public interface DemoService {

	int insertDev(Dev dev);

	List<Dev> selectDevList();

}
