package com.kh.student.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.student.model.vo.Student;

public class StudentDao implements IStudentDao {

	@Override
	public int insertStudent(SqlSession session, Student student) {
		// namespace.tagId
		return session.insert("student.insertStudent", student);
	}

	@Override
	public int insertStudent(SqlSession session, Map<String, Object> studentMap) {
		return session.insert("student.insertStudentMap", studentMap);
	}

	@Override
	public int selectStudentTotalCount(SqlSession session) {
		return session.selectOne("student.selectStudentTotalCount");
	}

	@Override
	public Student selectOneStudent(SqlSession session, int no) {
		return session.selectOne("student.selectOneStudent", no);
	}

	
	
}
