package com.ezen.spg16.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class MemberVO {
	
	@NotEmpty(message="아이디를 입력하세요")
	private String id;
	@NotEmpty(message="비밀번호를 입력하세요")
	private String pw;
	@NotEmpty(message="이름를 입력하세요")
	private String name;
	@NotEmpty(message="이메일를 입력하세요")
	private String email;
	@NotEmpty(message="전화번호를 입력하세요")
	private String phone1;
	@NotEmpty(message="전화번호를 입력하세요")
	private String phone2;
	@NotEmpty(message="전화번호를 입력하세요")
	private String phone3;
}
