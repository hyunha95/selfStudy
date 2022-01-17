package com.kh.student.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.student.model.vo.Student;

public interface IStudentDao {

	int insertStudent(SqlSession session, Student student);

	int insertStudent(SqlSession session, Map<String, Object> studentMap);

	int selectStudentTotalCount(SqlSession session);

	Student selectOneStudent(SqlSession session, int no);

	int updateStudent(SqlSession session, Student student);

	int deleteStudent(SqlSession session, int no);

	Map<String, Object> selectOneStudentMap(SqlSession session, int no);

	List<Student> selectStudentList(SqlSession session);

	List<Map<String, Object>> selectStudentMapList(SqlSession session);
	
	
}
