package kr.co.ch08.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch08.service.EmployeeService;
import kr.co.ch08.vo.EmployeeVo;

@Controller
public class EmployeeController {

	@Inject
	private EmployeeService service;
	
	@GetMapping(value = {"/", "/index"})
	public String index() {
		return "redirect:/employee/list";
	}
	
	@GetMapping("/employee/list")
	public String list(Model model) {
		
		List<EmployeeVo> list = service.selectEmployees();
		model.addAttribute("list", list);
		
		return "/employee/list";
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
	
	@GetMapping("/employee/modify")
	public String modify() {
		return "/employee/modify";
	}
	
	@GetMapping("/employee/delete")
	public String delete(String uid) {
		
		service.deleteEmployee(uid);
		
		return "redirect:/employee/list";
	}
	
	
}
