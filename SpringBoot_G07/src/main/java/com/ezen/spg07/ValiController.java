package com.ezen.spg07;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ValiController {

	@RequestMapping("/")
	public String main() {
		return "startPage";
	}
	
	@RequestMapping("/create")
	public String create(@ModelAttribute("dto") ContentDto contentdto, 
			BindingResult result) {
		ContentValidator validator = new ContentValidator();
		validator.validate(contentdto, result);
		if(result.hasErrors()) return "startPage";
		else return "DonePage";
	}
}
