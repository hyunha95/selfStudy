package com.kh.student.model.dao;

import java.util.List;
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

	@Override
	public int updateStudent(SqlSession session, Student student) {
		return session.update("student.updateStudent", student);
	}

	@Override
	public int deleteStudent(SqlSession session, int no) {
		return session.delete("student.deleteStudent", no);
	}

	@Override
	public Map<String, Object> selectOneStudentMap(SqlSession session, int no) {
		return session.selectOne("student.selectOneStudentMap", no);
	}

	/**
	 * selectList는 조회된 행이 없는 경우에도 null을 리턴하지 않는다.
	 * 빈 list객체를 리턴한다
	 */
	@Override
	public List<Student> selectStudentList(SqlSession session) {
		return session.selectList("student.selectStudentList");
	}

	@Override
	public List<Map<String, Object>> selectStudentMapList(SqlSession session) {
		return session.selectList("student.selectStudentMapList");
	}

	
	
	
}
