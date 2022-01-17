package com.kh.spring.menu.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import com.kh.spring.menu.model.vo.Menu;

/**
 * 
 * - namespace : com.kh.spring.menu.model.dao.MenuDao
 * - id : method이름
 *
 */
@Mapper
public interface MenuDao {

	List<Menu> selectAllMenu();

	List<Menu> selectMenuByTypeAndTaste(Map<String, Object> param);

	int insertMenu(Menu menu);

	@Select("select * from menu where id = #{id}")
	Menu selectOneMemu(int id);

	@Select("select * from menu order by id desc")
	List<Menu> selectPageMenu(RowBounds rowBounds);

	@Update("update menu set name=#{name}, "
			+ "restaurant = #{restaurant}, "
			+ "price = #{price}, "
			+ "type = #{type}, "
			+ "taste = #{taste} "
			+ "where id = #{id}")
	int updateMenu(Menu menu);

	@Delete("delete from menu where id = #{id}")
	int deleteMenu(int id);

	
}
