package com.ezen.spg12.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.spg12.dao.IBbsDao;
import com.ezen.spg12.dto.BbsDto;

@Controller
public class BbsController {
	
	@Autowired
	IBbsDao bdao;

	@RequestMapping("/")
		public String userlistPage(Model model) {
		model.addAttribute("list", bdao.list());
		return "list";
	}
	
	@RequestMapping("/view")
	public String view(@RequestParam("id") int id, Model model) {
		model.addAttribute("dto", bdao.view(id));
		return "view";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm(Model model) {
		return "writeForm";
	}

	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute("dto") @Valid BbsDto bbsdto, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			if(result.getFieldError("writer")!=null)
				model.addAttribute("msg", result.getFieldError("writer").getDefaultMessage());
			else if(result.getFieldError("title")!=null)
				model.addAttribute("msg", result.getFieldError("title").getDefaultMessage());
			else if(result.getFieldError("content")!=null)
				model.addAttribute("msg", result.getFieldError("content").getDefaultMessage());
			return "writeForm";
		} else {
			bdao.write(bbsdto);
			//bdao.write(bbsdto.getWriter(), bbsdto.getTitle(), bbsdto.getContent());
			return "redirect:/";
		}
	}
	
	@RequestMapping("/updateForm")
	public String updateForm(@RequestParam("id") int id, Model model) {
		model.addAttribute("dto", bdao.view(id));
		return "updateForm";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@RequestParam("id") int id,
			@ModelAttribute("dto") @Valid BbsDto bbsdto, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			if(result.getFieldError("writer")!=null)
				model.addAttribute("msg", "작성자 입력 오류");
			else if(result.getFieldError("title")!=null)
				model.addAttribute("msg", "제목 입력 오류");
			else if(result.getFieldError("content")!=null)
				model.addAttribute("msg", "내용 입력 오류");
			return "updateForm";
		} else {
			//bdao.update(bbsdto.getWriter(),bbsdto.getTitle(),bbsdto.getContent(),id);
			bdao.write(bbsdto);
			return "redirect:/";
		}
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id, Model model) {
		bdao.delete(id);
		return "redirect:/";
	}
}