package com.ezen.spg11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.spg11.dao.IUserDao;
import com.ezen.spg11.dto.UserDto;

@Controller
public class UserController {
	
	@Autowired
	IUserDao udao;
	
	@RequestMapping("/")
	public String root(Model model) {
		List<UserDto> list = udao.list();
		model.addAttribute("users", list);
		return "userlist";
	}
}
