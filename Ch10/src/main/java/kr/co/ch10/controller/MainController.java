package kr.co.ch10.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch10.vo.EmployeeVo;

@Controller
public class MainController {

	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {
		
		String title = "Hello 타임리프!";
		EmployeeVo evo = null;
		
		List<EmployeeVo> list = new ArrayList<>();
		list.add(new EmployeeVo("a101", "김유신"));
		list.add(new EmployeeVo("a102", "김춘추"));
		list.add(new EmployeeVo("a103", "장보고"));
		list.add(new EmployeeVo("a104", "강감찬"));
		list.add(new EmployeeVo("a105", "이순신"));
		
		model.addAttribute("title", title);
		model.addAttribute("evo", evo);
		model.addAttribute("list", list);
		
		return "/index";
	}
	
}
