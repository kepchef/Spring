package kr.co.ch08.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.ch08.vo.EmployeeVo;

@Repository
public class EmployeeDao {

	@Inject
	private JdbcTemplate jdbc;
	
	@Inject
	private SqlSessionTemplate mybatis;
	
	public void insertEmployee(EmployeeVo vo)  {
		mybatis.insert("mapper.employee.INSERT_EMPLOYEE", vo);
	}
	
	
	public void selectEmployee()  {}
	
	public List<EmployeeVo> selectEmployees() {
		return mybatis.selectList("mapper.employee.SELECT_EMPLOYEES");
	}
	
	public void updateEmployee()  {}
	
	public void deleteEmployee(String uid)  {
		mybatis.delete("mapper.employee.DELETE_EMPLOYEE", uid);
	}
}






