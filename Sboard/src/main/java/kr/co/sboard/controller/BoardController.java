package kr.co.sboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sboard.service.BoardService;
import kr.co.sboard.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	
	@GetMapping("/list")
	public String list(Model model, String pg) {		
		
		int start = service.getLimitStart(pg);
		int total = service.selectCountTotalArticle();
		int lastPageNum = service.getLastPageNum(total);
		int count = service.getListCount(total, start);
		
		List<BoardVo> articles = service.selectArticles(start);
		
		model.addAttribute("articles", articles);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("count", count);
		
		return "/list";
	}
	
	@GetMapping("/modify")
	public String modify(int seq, Model model) {
		
		BoardVo vo = service.selectArticle(seq);
		model.addAttribute("vo", vo);
		
		return "/modify";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVo vo) {
		
		service.updateArticle(vo);
		
		return "redirect:/view?seq="+vo.getSeq();
	}
	
	@GetMapping("/view")
	public String view(int seq, Model model) {
		
		BoardVo article = service.selectArticle(seq);
		model.addAttribute("article", article);
		
		return "/view";
	}
	
	@GetMapping("/write")
	public String write() {
		return "/write";
	}
	
	@PostMapping("/write")
	public String write(BoardVo vo, HttpServletRequest req) {
		
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		service.insertArticle(vo);
		
		return "redirect:/list";
	}
	
}
