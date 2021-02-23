package kr.co.ch05.sub1;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<UserVo>{

	@Override
	public UserVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UserVo vo = new UserVo();
		vo.setUid(rs.getString(1));
		vo.setName(rs.getString(2));
		vo.setHp(rs.getString(3));
		vo.setAge(rs.getInt(4));	
		
		return vo;
	}

}
