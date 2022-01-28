package com.ezen.spn01.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MemberVO {

	@NotNull (message="id를 입력하세요")
	@NotEmpty(message="id를 입력하세요")
	private String id;
	@NotNull(message="비밀번호를 입력하세요")
	@NotEmpty(message="비밀번호를 입력하세요")
    private String pwd;     
	@NotNull(message="이름을 입력하세요")
	@NotEmpty(message="이름을 입력하세요")
    private String name;
	@NotNull(message="이메일을 입력하세요")
	@NotEmpty(message="이메일을 입력하세요")
    private String email;
    private String zip_num;
    private String address;
    private String phone;
    private String useyn;
    private Timestamp indate;
    
}
