package kr.co.sboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sboard.dao.BoardDao;
import kr.co.sboard.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao;
	
	public void insertArticle(BoardVo vo) {
		dao.insertArticle(vo);
	}
	public BoardVo selectArticle(int seq) {
		return dao.selectArticle(seq);
	}
	
	public List<BoardVo> selectArticles(int start) {
		return dao.selectArticles(start);
	}
	
	public void updateArticle(BoardVo vo) {
		dao.updateArticle(vo);
	}
	public void deleteArticle() {}
	
	public int selectCountTotalArticle() {
		return dao.selectCountTotalArticle();
	}
	
	public int getLimitStart(String pg) {
		
		if(pg == null) {
			return 0;
		}else {
			int page = Integer.parseInt(pg);
			return (page - 1) * 10;
		}
	}
	
	public int getLastPageNum(int total) {
		
		int lastPageNum = 0;
		
		if(total % 10 == 0) {
			lastPageNum = total / 10;
		}else {
			lastPageNum = (total / 10) + 1;
		}
		return lastPageNum;
	}
	
	public int getListCount(int total, int start) {		
		return total - start;
	}
	
}
