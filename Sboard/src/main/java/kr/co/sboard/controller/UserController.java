package kr.co.sboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.sboard.service.UserService;
import kr.co.sboard.vo.TermsVo;
import kr.co.sboard.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/user/logout")
	public String logout(HttpSession sess) {
		
		sess.invalidate();
		
		return "redirect:/user/login";
	}
	
	@GetMapping("/user/login")
	public String login() {		
		return "/user/login";
	}
	
	@PostMapping("/user/login")
	public String login(UserVo vo, HttpSession sess) {		
		
		UserVo user = service.selectUser(vo);
		
		if(user != null) {
			sess.setAttribute("suser", user);
			return "redirect:/list";
		}else {
			return "redirect:/user/login";
		}
	}
	
	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
	
	@PostMapping("/user/register")
	public String register(UserVo vo, HttpServletRequest req) {
		
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		service.insertUser(vo);
		
		return "redirect:/user/login";
	}
	
	@GetMapping("/user/terms")
	public String terms(Model model) {
		
		TermsVo vo = service.selectTerms();
		
		model.addAttribute("vo", vo);
		
		return "/user/terms";
	}
	
	@ResponseBody
	@GetMapping("/user/checkUid")	
	public String checkUid(String uid) {
		
		int result = service.selectCountUid(uid);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
}
