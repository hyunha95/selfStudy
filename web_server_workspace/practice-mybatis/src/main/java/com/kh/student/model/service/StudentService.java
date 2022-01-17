package com.kh.student.model.service;

import static com.kh.common.SqlSessionTemplate.*;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.student.model.dao.IStudentDao;
import com.kh.student.model.vo.Student;

public class StudentService implements IStudentService {

	private IStudentDao studentDao;

	public StudentService(IStudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	@Override
	public int insertStudent(Student student) {
		int result = 0;
		SqlSession session = getSqlSession();
		
		try {
			result = studentDao.insertStudent(session, student);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int insertStudent(Map<String, Object> studentMap) {
		int result = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSession();
			result = studentDao.insertStudent(session, studentMap);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int selectStudentTotalCount() {
		SqlSession session = getSqlSession();
		int totalCount = studentDao.selectStudentTotalCount(session);
		session.close();
		return totalCount;
	}

	@Override
	public Student selectOneStudent(int no) {
		SqlSession session = getSqlSession();
		Student student = studentDao.selectOneStudent(session, no);
		session.close();
		return student;
	}
	
	
}
