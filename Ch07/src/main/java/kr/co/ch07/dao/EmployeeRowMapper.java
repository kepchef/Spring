package kr.co.ch07.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.co.ch07.vo.EmployeeVo;

public class EmployeeRowMapper implements RowMapper<EmployeeVo>{

	@Override
	public EmployeeVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		EmployeeVo vo = new EmployeeVo();
		
		vo.setUid(rs.getString(1));
		vo.setName(rs.getString(2));
		vo.setGender(rs.getInt(3));
		vo.setHp(rs.getString(4));
		vo.setEmail(rs.getString(5));
		vo.setPos(rs.getString(6));
		vo.setDep(rs.getInt(7));
		vo.setRdate(rs.getString(8).substring(2, 10));
		
		return vo;
	}
}
