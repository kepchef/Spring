package kr.co.ch08.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.ch08.dao.EmployeeDao;
import kr.co.ch08.vo.EmployeeVo;

@Service
public class EmployeeService {

	@Inject
	private EmployeeDao dao;
	
	public void insertEmployee(EmployeeVo vo)  {
		dao.insertEmployee(vo);
	}
	
	public void selectEmployee()  {}
	
	public List<EmployeeVo> selectEmployees() {
		return dao.selectEmployees();
	}
	
	public void updateEmployee()  {}
	
	public void deleteEmployee(String uid)  {
		dao.deleteEmployee(uid);
	}
	
}
