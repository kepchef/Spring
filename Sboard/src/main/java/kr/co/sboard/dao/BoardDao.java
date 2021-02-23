package kr.co.sboard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.BoardVo;

@Repository
public interface BoardDao {
	
	public void insertArticle(BoardVo vo);
	
	public int selectCountTotalArticle();
	public BoardVo selectArticle(int seq);
	public List<BoardVo> selectArticles(int start);
	public void updateArticle(BoardVo vo);
	public void deleteArticle();
	
	

}
