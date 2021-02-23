package kr.co.sboard.dao;

import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.TermsVo;
import kr.co.sboard.vo.UserVo;

@Repository
public interface UserDao {

	public void insertUser(UserVo vo);	
	
	public TermsVo selectTerms();
	
	public UserVo selectUser(UserVo vo);
	
	
	public void selectUsers();
	public void updateUser();
	public void deleteUser();
	
	
	public int selectCountUid(String uid);
	
	
}
