package kr.co.ch11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch11.service.EmployeeService;
import kr.co.ch11.vo.EmployeeVo;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	@GetMapping("/employee/register")
	public String register() {
		return "/employee/register";
	}
	
	@PostMapping("/employee/register")
	public String register(EmployeeVo vo) {
		service.insertEmployee(vo);
		return "redirect:/employee/list";
	}
	
	@GetMapping("/employee/list")
	public String list(Model model) {
		
		List<EmployeeVo> list = service.selectEmployees();
		model.addAttribute("list", list);
		
		return "/employee/list";
	}
	
	@GetMapping("/employee/delete")
	public String delete(String uid) {
		service.deleteEmployee(uid);
		return "redirect:/employee/list";
	}
	
	@GetMapping("/employee/modify")
	public String modify(String uid, Model model) {
		
		EmployeeVo vo = service.selectEmployee(uid);
		model.addAttribute("vo", vo);
		
		return "/employee/modify";
	}
	
	@PostMapping("/employee/modify")
	public String modify(EmployeeVo vo) {
		
		service.updateEmployee(vo);
		
		return "redirect:/employee/list";
	}
}


