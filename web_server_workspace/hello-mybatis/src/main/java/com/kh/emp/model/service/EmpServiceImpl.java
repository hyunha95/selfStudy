package com.kh.emp.model.service;

import static com.kh.common.SqlSessionTemplate.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.emp.model.dao.EmpDao;

public class EmpServiceImpl implements EmpService {

	private EmpDao empDao;

	public EmpServiceImpl(EmpDao empDao) {
		super();
		this.empDao = empDao;
	}

	@Override
	public List<Map<String, Object>> selectEmpMapList() {
		SqlSession session = getSqlSession();
		List<Map<String, Object>> list = empDao.selectEmpMapList(session);
		session.close();
		return list;
	}

	@Override
	public List<Map<String, Object>> search1(Map<String, Object> param) {
		SqlSession session = getSqlSession();
		List<Map<String, Object>> list = empDao.search1(session, param);
		session.close();
		return list;
	}

	@Override
	public List<Map<String, Object>> search2(Map<String, Object> param) {
		SqlSession session = getSqlSession();
		List<Map<String, Object>> list = empDao.search2(session, param);
		session.close();
		return list;
	}

	@Override
	public List<Map<String, String>> selectJobList() {
		SqlSession session = getSqlSession();
		List<Map<String, String>> jobList = empDao.selectJobList(session);
		session.close();
		return jobList;
	}

	@Override
	public List<Map<String, Object>> search3(Map<String, Object> param) {
		SqlSession session = getSqlSession();
		List<Map<String, Object>> list = empDao.search3(session, param);
		session.close();
		return list;
	}

	@Override
	public Map<String, Object> selectOneEmpMap(Map<String, Object> param) {
		SqlSession session = getSqlSession();
		Map<String, Object> empMap = empDao.selectOneEmpMap(session, param);
		session.close();
		return empMap;
	}

	@Override
	public List<Map<String, String>> selectDeptList() {
		SqlSession session = getSqlSession();
		List<Map<String, String>> deptList = empDao.selectDeptList(session);
		session.close();
		return deptList;
	}

	@Override
	public int updateEmp(Map<String, Object> param) {
		SqlSession session = null;
		int result = 0;
		
		try {
			session = getSqlSession();
			result = empDao.updateEmp(session, param);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return result;
	}
	
	
	
	
	
}
