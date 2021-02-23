package kr.co.ch05.sub1;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Inject
	private JdbcTemplate jdbc;

	public void insertUser() {
		jdbc.update("INSERT INTO `USER1` VALUES ('sp101', '±Ë¿ØΩ≈', '010-1111-1111', 24)");
	}
	
	public List<UserVo> selectUser() {
		
		String sql = "SELECT * FROM `USER1`";
		List<UserVo> users = jdbc.query(sql, new UserRowMapper());
		
		return users;
	}
	
	public void updateUser() {
		
		String sql = "UPDATE `USER1` SET `hp`=?, `age`=? "
				   + "WHERE `uid`=?";
		
		Object[] values = {"010-1111-0001", 31, "sp101"};
		
		jdbc.update(sql, values);
	}
	
	public void deleteUser() {
		jdbc.update("DELETE FROM `USER1` WHERE `uid`=?", "sp101");
	}
	
}








