package com.ezen.spg02;

import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JavaController {

	@RequestMapping("/")
	public @ResponseBody String root() {
		// 함수 이름에 @ResponseBody가 있으면 리턴되는 문자열이 이름없는 페이지에 출력구문으로
		//직접 쓰여지게 됩니다
		return "JSP in Gradle";
	}
	
	@RequestMapping("/test1")
	public String test1() {
		return "main";
	}
	
	@RequestMapping("test2")
	public String test2() {
		return "sub/sub";
	}
}
