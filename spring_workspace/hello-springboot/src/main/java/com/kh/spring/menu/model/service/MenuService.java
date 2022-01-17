package com.kh.spring.menu.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.kh.spring.menu.model.vo.Menu;

public interface MenuService {

	List<Menu> selectAllMenu();

	List<Menu> selectMenuByTypeAndTaste(Map<String, Object> param);

	int insertMenu(Menu menu);

	Menu selectOneMenu(int id);

	List<Menu> selectPageMenu(RowBounds rowBounds);

	int updateMenu(Menu menu);

	int deleteMenu(int id);

}
