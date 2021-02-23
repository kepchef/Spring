package kr.co.ch07.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ch07.service.EmployeeService;
import kr.co.ch07.vo.EmployeeVo;

@Controller
public class MainController {

	@Inject
	private EmployeeService service;
	
	
	@RequestMapping("/employee/list")
	public String list(Model model) {
		
		List<EmployeeVo> list = service.selectEmployees();
		
		// View에서 데이터를 출력하기 위한 model 참조 설정
		model.addAttribute("list", list);
		
		return "/employee/list";
	}
	
	@RequestMapping("/employee/modify")
	public String modify() {
		return "/employee/modify";
	}
	
	@GetMapping("/employee/register")
	public String register() {
		return "/employee/register";
	}	
	
	@PostMapping("/employee/register")
	public String register(EmployeeVo vo) {
		
		service.insertEmployee(vo);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/employee/delete")
	public String delete(String uid) {
		
		service.deleteEmployee(uid);
		return "redirect:/employee/list";
	}
	
	
}
