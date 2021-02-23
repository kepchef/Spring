package kr.co.ch07.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.ch07.vo.EmployeeVo;

@Repository
public class EmployeeDao {
	
	@Inject
	private JdbcTemplate jdbc;
		
	public void insertEmployee(EmployeeVo vo) {
		
		String sql = "INSERT INTO `Employee` VALUES (?,?,?,?,?,?,?, NOW())";
		Object[] params = {vo.getUid(), 
				           vo.getName(), 
				           vo.getGender(), 
				           vo.getHp(), 
				           vo.getEmail(), 
				           vo.getPos(), 
				           vo.getDep()};
		
		jdbc.update(sql, params);
	}
	
	public void selectEmployee() {}
	
	public List<EmployeeVo> selectEmployees() {
		
		String sql = "SELECT * FROM `Employee`";
		List<EmployeeVo> list = jdbc.query(sql, new EmployeeRowMapper());
		return list;
	}
	
	public void updateEmployee() {}
	
	public void deleteEmployee(String uid) {
		
		String sql = "DELETE FROM `Employee` WHERE `uid`=?";
		jdbc.update(sql, uid);
	}

}
