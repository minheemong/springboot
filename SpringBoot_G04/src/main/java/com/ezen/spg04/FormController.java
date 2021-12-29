package com.ezen.spg04;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {

	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "Form 데이터 전달받아 사용하기";
	}
	
	@RequestMapping("/test1")
	public String test1(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "test1";
	}
	
	@RequestMapping("/test2")
	public String test2(@RequestParam("id") String id, 
			@RequestParam("name") String name, Model model) {
		// Model 객체를 이용해서, view로 Data 전달 : 데이터만 설정이 가능
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "test2";
	}
	

	@RequestMapping("/test3") // 가장 많이 사용
	public String test3(Member member, Model model) {
		// 파라미터와 일치하는 빈을 만들어서 매개변수로 사용할 수 있습니다
		// 전달된 파라미터는 매개변수 빈에 자동으로 입력됩니다
		// View 페이지에서 model을 사용하지 않고 member 빈을 전달합니다
		return "test3";
	}
	
	@RequestMapping("/test4/{studentId}/{name}")
	public String getStudent(@PathVariable String studentId,
			@PathVariable String name, Model model) {
		// Model 객체를 이용해서, view로 Data 전달 : 데이터만 설정이 가능
		model.addAttribute("id", studentId);
		model.addAttribute("name", name);
		return "test4";
	}
}
