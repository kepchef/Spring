package kr.co.sboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.sboard.vo.UserVo;

@Controller
public class MainController {
	
	@GetMapping(value = {"/", "/index"})
	public String index(HttpSession sess) {
		
		UserVo user = (UserVo) sess.getAttribute("suser");
		
		if(user != null) {
			return "redirect:/list";
		}else {
			return "redirect:/user/login";
		}
		
	}
	
}
