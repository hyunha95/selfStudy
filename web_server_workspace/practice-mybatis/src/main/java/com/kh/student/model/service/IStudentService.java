package com.kh.student.model.service;

import java.util.Map;

import com.kh.student.model.vo.Student;

public interface IStudentService {

	int insertStudent(Student student);

	int insertStudent(Map<String, Object> studentMap);

	int selectStudentTotalCount();

	Student selectOneStudent(int no);

	
}
