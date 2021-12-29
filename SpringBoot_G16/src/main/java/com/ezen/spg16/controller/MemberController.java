package com.ezen.spg16.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spg16.dto.MemberVO;
import com.ezen.spg16.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
	@RequestMapping("/")
	public String index() {
		return "loginform";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("dto") @Valid MemberVO membervo,
			BindingResult result, Model model, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			if(result.getFieldError("id")!=null) {
				model.addAttribute("message", result.getFieldError("id").getDefaultMessage());
				return "loginform";
			} else if(result.getFieldError("pw")!=null) {
				model.addAttribute("message", result.getFieldError("pw").getDefaultMessage());
				return "loginform";
			}
		}
		MemberVO mvo = ms.getMember(membervo.getId());
		if(mvo == null) {
			model.addAttribute("message", "아이디가 없습니다");
			return "loginform";
		}else if(mvo.getPw()==null) {
			model.addAttribute("message", "로그인 오류. 관리자에게 문의하세요");
			return "loginform";
		}else if(!mvo.getPw().equals(membervo.getPw())) {
			model.addAttribute("message", "비밀번호가 맞지 않습니다");
			return "loginform";
		}else if(mvo.getPw().equals(membervo.getPw())) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
			return "redirect:/main";
		}else {
			model.addAttribute("message", "알 수 없는 이유로 로그인이 불가합니다");
			return "loginform";
		}
	}
	
	@RequestMapping("memberJoinForm")
	public String join_form(Model model, HttpServletRequest request) {
		return "member/memberJoinForm";
	}
	
	@RequestMapping("/idcheck")
	public ModelAndView idcheck(@RequestParam("id") String id) {
		ModelAndView mav = new ModelAndView();
		
		MemberVO mvo = ms.getMember(id);
		if(mvo==null) mav.addObject("result", -1);
		else mav.addObject("result", 1);
		
		mav.addObject("id",id);
		mav.setViewName("member/idcheck");
		return mav;
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST)
	public ModelAndView memberJoin(@ModelAttribute("dto") @Valid MemberVO membervo,
			BindingResult result, @RequestParam("re_id") String reid, 
			@RequestParam("pw_check") String pwchk, Model model) {
		ModelAndView mav = new ModelAndView();
		
		if(result.getFieldError("id")!=null) {
			mav.addObject("message","아이디를 입력하세요");
			mav.addObject("re_id", reid);
			mav.setViewName("member/memberJoinForm");
		} else if(result.getFieldError("pw")!=null) {
			mav.addObject("message","비밀번호를 입력하세요");
			mav.addObject("re_id", reid);
			mav.setViewName("member/memberJoinForm");	
		} else if(result.getFieldError("name")!=null) {
			mav.addObject("message",result.getFieldError("name").getDefaultMessage());
			mav.addObject("re_id", reid);
			mav.setViewName("member/memberJoinForm");	
		} else if(!membervo.getId().equals(reid)) {
			mav.addObject("message","아이디 중복체크가 되지 않았습니다");
			mav.setViewName("member/memberJoinForm");
		} else if(!membervo.getPw().equals(pwchk)) {
			mav.addObject("message","비밀번호 확인이 일치하지 않습니다");
			mav.addObject("re_id", reid);
			mav.setViewName("member/memberJoinForm");
		} else {
			ms.insertMember(membervo);
			mav.addObject("message","회원가입이 완료되었습니다. 로그인 하세요");
			mav.setViewName("loginform");
		}
		return mav;
	}
	
	@RequestMapping("/memberEditForm")
	public String member_edit_form(Model model, HttpServletRequest request) {
		HttpSession session= request.getSession();
		if(session.getAttribute("loginUser")==null) return "loginform";
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		MemberVO dto = new MemberVO();
		dto.setId(loginUser.getId());
		dto.setName(loginUser.getName());
		dto.setEmail(loginUser.getEmail());
		dto.setPhone1(loginUser.getPhone1());
		dto.setPhone2(loginUser.getPhone2());
		dto.setPhone3(loginUser.getPhone3());
		model.addAttribute("dto", dto);
		return "member/memberEditForm";
	}
	

	@RequestMapping(value="/memberEdit", method=RequestMethod.POST)
	public String memberEdit(@ModelAttribute("dto") @Valid MemberVO membervo,
			BindingResult result, @RequestParam("pw_check") String pwchk, Model model,
			HttpServletRequest request) {
		if(result.getFieldError("pw")!=null) {
			model.addAttribute("message","비밀번호를 입력하세요");
			return "member/memberEditForm";
		} else if(result.getFieldError("name")!=null) {
			model.addAttribute("message","이름을 입력하세요");
			return "member/memberEditForm";
		} if(!membervo.getPw().equals(pwchk)) {
			model.addAttribute("message","비밀번호 확인이 일치하지 않습니다");
			return "member/memberEditForm";
		}else {
			ms.updateMember(membervo);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", membervo);
			return "redirect:/main";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
}